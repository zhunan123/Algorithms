#include <ctype.h>
#include <limits.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>
#include <string.h>
#include <sys/stat.h>

#include "logger.h"
#include "elist.h"
#include "util.h"

struct da_entry {
    char *path;
    __off64_t size;
    time_t time;
};

/* Forward declarations: */
void print_usage(char *program_name);
int compare_by_name(const void *a, const void *b);
int compare_by_size(const void *a, const void *b);
int compare_by_time(const void *a, const void *b);
void print_list(struct elist *list, size_t limit);
void destruct_list(struct elist *list);
void traverse_directory(struct elist *list, char *directory);


void print_usage(char *program_name) {
fprintf(stderr, "Disk Analyzer (da): analyzes disk space usage\n");
fprintf(stderr, "Usage: %s [-ahs] [-l limit] [directory]\n\n", program_name);

fprintf(stderr, "If no directory is specified, the current working directory is used.\n\n");

fprintf(stderr, "Options:\n"
"    * -a              Sort the files by time of last access (descending)\n"
"    * -h              Display help/usage information\n"
"    * -l limit        Limit the output to top N files (default=unlimited)\n"
"    * -s              Sort the files by size (default, ascending)\n\n"
);
}



int compare_by_name(const void *a, const void *b) {
    struct da_entry *entry_a = (struct da_entry *) a;
    struct da_entry *entry_b = (struct da_entry *) b;
    return strcmp(entry_b->path, entry_a->path);
}



int compare_by_size(const void *a, const void *b) {
    struct da_entry *entry_a = (struct da_entry *) a;
    struct da_entry *entry_b = (struct da_entry *) b;
    return entry_a->size - entry_b->size;
}



int compare_by_time(const void *a, const void *b) {
    struct da_entry *entry_a = (struct da_entry *) a;
    struct da_entry *entry_b = (struct da_entry *) b;
    return entry_b->time - entry_a->time;
}



void print_list(struct elist *list, size_t limit) {
    size_t elistSize = elist_size(list);

    // If the limit is 0, print the entire list
    // Otherwise, print the last 'limit' elements
    size_t start_index = 0;
    if (limit != 0 && elistSize > limit) {
        start_index = elistSize - limit;
    }

    for (unsigned int i = start_index; i < elistSize; i++) {
        struct da_entry *entry = elist_get(list, i);
        char size[64];
        char time[64];
        human_readable_size(size, sizeof(size), (double) entry->size, 1);
        simple_time_format(time, sizeof(time), entry->time);
        printf("%10s | %11s | %s\n", size, time, entry->path);
    }
}



void destruct_list(struct elist *list) {
    size_t size = elist_size(list);
    for (unsigned int i = 0; i < size; i++) {
        struct da_entry *entry = elist_get(list, i);
        free(entry->path);
    }
    elist_destroy(list);
}



void traverse_directory(struct elist *list, char *directory) {
    DIR *dir = opendir(directory);

    if (dir == NULL) {
        LOG("Error: could not open directory [%s]\n", directory);
        return;
    }

    struct dirent *entry;
    while ((entry = readdir(dir)) != NULL) {
        if (strcmp(entry->d_name, ".") == 0 || strcmp(entry->d_name, "..") == 0) {
            continue;
        }
        char *full_path = malloc(sizeof(char) *
                                 (strlen(directory) + strlen(entry->d_name) + strlen("/") + 1));
        sprintf(full_path, "%s/%s", directory, entry->d_name);

        if (entry->d_type == DT_DIR) {
            traverse_directory(list, full_path);
        } else {
            // create a new da_entry and add it to the list
            struct da_entry da_entry;

            struct stat st;
            if (stat(full_path, &st) == -1) {
                LOG("Error: could not stat file [%s]\n", full_path);
                continue;
            }
            char *entry_path = malloc(sizeof(char) * strlen(full_path) + 1);
            strcpy(entry_path, full_path);

            da_entry.path = entry_path;
            da_entry.size = st.st_size;
            da_entry.time = st.st_atime;

            elist_add(list, &da_entry);
            LOG("Added [%s] to list, size: [%lu], time: [%lu]\n", full_path, st.st_size, st.st_atime);
        }
        free(full_path);
    }
    closedir(dir);
}

int main(int argc, char *argv[])
{
    /* Create a struct to hold program options and initialize it by declaring an
     * 'options' variable. Defaults:
     *      - sort by size (time=false)
     *      - limit of 0 (unlimited)
     *      - directory = '.' (current directory) */
    struct da_options {
        bool sort_by_time;
        unsigned int limit;
        char *directory;
    } options
        = { false, 0, "." };

    int c;
    opterr = 0;
    while ((c = getopt(argc, argv, "ahl:s")) != -1) {
        switch (c) {
            case 'a':
                options.sort_by_time = true;
                break;
            case 'h':
                print_usage(argv[0]);
                return 0;
            case 's':
                options.sort_by_time = false;
                break;
            case 'l': {
                /*    ^-- to declare 'endptr' here we need to enclose this case
                 *    in its own scope with curly braces { } */
                char *endptr;
                long llimit = strtol(optarg, &endptr, 10);
                if (llimit < 0 || llimit > INT_MAX || endptr == optarg) {
                    fprintf(stderr, "Invalid limit: %s\n", optarg);
                    print_usage(argv[0]);
                    return 1;
                }
                options.limit = (int) llimit;
                break;
                }
            case '?':
                if (optopt == 'l') {
                    fprintf(stderr,
                            "Option -%c requires an argument.\n", optopt);
                } else if (isprint(optopt)) {
                    fprintf(stderr, "Unknown option `-%c'.\n", optopt);
                } else {
                    fprintf(stderr,
                            "Unknown option character `\\x%x'.\n", optopt);
                }
                print_usage(argv[0]);
                return 1;
            default:
                abort();
        }
    }

    if (optind < argc) {
        options.directory = argv[optind];
    }

    LOGP("Done parsing arguments.\n");
    LOG("Sorting by: [%s], limit: [%u]\n",
            options.sort_by_time == true ? "time" : "size",
            options.limit);
    LOG("Directory to analyze: [%s]\n", options.directory);

    /* TODO:
     *  - check to ensure the directory actually exists
     *  - create a new 'elist' data structure
     *  - traverse the directory and store entries in the list
     *  - sort the list (either by size or time)
     *  - print formatted list
     */

    // check if dir exists, if not, return 1
    DIR* temp_dir = opendir(options.directory);
    if (temp_dir) {
        /* Directory exists. */
        closedir(temp_dir);
    } else {
        return 1;
    }

    struct elist *list = elist_create(10, sizeof(struct da_entry));

    traverse_directory(list, options.directory);

    elist_sort(list, compare_by_name);
    if (options.sort_by_time) {
        elist_sort(list, compare_by_time);
    } else {
        elist_sort(list, compare_by_size);
    }

    print_list(list, options.limit);

    destruct_list(list);
    return 0;
}
