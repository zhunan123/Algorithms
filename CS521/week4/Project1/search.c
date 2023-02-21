/**
 * @file search.c
 * @author Zhunan Shuai
 *
 * This program is a file search utility inspired by find(1). At its core, it
 * recursively traverses a directory structure and reports its contents with a
 * variety of filtering options.
 */

#include <ctype.h>
#include <dirent.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

#include "logger.h"

struct options {
    int max_depth;
    bool exact_match : 1;
    bool show_dirs : 1;
    bool show_files : 1;
    bool show_hidden : 1;
};

struct options default_options = {-1, false, true, true, false};

/**
 * Prints help/program usage information.
 *
 * This output is displayed if there are issues with command line option parsing
 * or the user passes in the -h flag.
 */
void print_usage(char *prog_name)
{
    printf("Usage: %s [-defhH] [-l depth-limit] [directory] [search-pattern]\n" , prog_name);
    printf("\n");
    printf("Options:\n"
"    * -d    Only display directories (no files)\n"
"    * -e    Match search-pattern exactly; no partial matches reported.\n"
"    * -f    Only display files (no directories)\n"
"    * -l    Set a depth limit, e.g., recurse no more than 2 directories deep.\n"
"    * -h    Display hidden files.\n"
"    * -H    Display help/usage information\n");
    printf("\n");
}

int recursive_search(struct options *opts, char *dir, char *search_term, int depth) {
    //open the directory
    char *start_path = dir;
    DIR *directory = opendir(start_path);

    //handle null
    if (directory == NULL) {
        return 1;
    }

     if (directory) {
        struct dirent *entry;
        //read the contents
        while ((entry = readdir(directory)) != NULL) {
            char *full_path = malloc(strlen(start_path) + strlen(entry->d_name) + strlen("/") + 1);
            sprintf(full_path, "%s/%s", start_path, entry->d_name);
            if (full_path == NULL) {
                printf("we are running out of memeory to allocate!");
            }

            if (opts->show_files == false){ //Only display directories (no files)
                if (entry->d_type == DT_DIR && entry->d_name[0] != '.') {
                    if (opts->exact_match == true) {
                        if (strcmp(entry->d_name, search_term) == 0) {
                            printf("%s\n", full_path);
                        }
                    } else {
                        if (strstr(entry->d_name, search_term)) {
                            printf("%s\n", full_path);
                        }
                    }
                } else {
                    continue;
                }
            } else if (opts->show_hidden == true) { //Display hidden files.
                if (opts->exact_match == true) {
                        if (strcmp(entry->d_name, search_term) == 0) {
                            printf("%s\n", full_path);
                        }
                } else {
                    if (strstr(entry->d_name, search_term)) {
                        printf("%s\n", full_path);
                    }
                }
            } else if (opts->show_dirs == false){ //Only display files (no directories)
                if (entry->d_type != DT_DIR && entry->d_name[0] != '.') {
                    if (opts->exact_match == true) {
                        if (strcmp(entry->d_name, search_term) == 0) {
                            printf("%s\n", full_path);
                        }
                    } else {
                        if (strstr(entry->d_name, search_term)) {
                            printf("%s\n", full_path);
                        }
                    }
                } else {
                    continue;
                }
            }
            else { //general condition
                if (entry->d_name[0] != '.') {
                    if (opts->exact_match == true) {
                            if (strcmp(entry->d_name, search_term) == 0) {
                                printf("%s\n", full_path);
                            }
                    } else {
                            if (strstr(entry->d_name, search_term)) {
                                printf("%s\n", full_path);
                        }
                    }
                }
            }

            // if its a directory, call revursive_search on it.
            if (entry->d_type == DT_DIR) {
                if (opts->max_depth != -1 && depth >= opts->max_depth) {
                    continue;
                }
                if (entry->d_name[0] != '.') {
                    recursive_search(opts, full_path, search_term, depth + 1);
                }
            }
            free(full_path);
        }
     }
    closedir(directory);
    return 0;
}

int main(int argc, char *argv[]) {
    /* Create a struct to hold our default options. We can update this as we
     * parse through the command line arguments. */
    struct options opts;
    opts = default_options;

    int c;
    opterr = 0;
    while ((c = getopt(argc, argv, "defhHl:")) != -1) {
        switch (c) {
            case 'd':
                // handle option 'd' here, then 'break' to keep parsing...
                opts.show_files = false;
                break;
            case 'e':
                opts.exact_match = true;
                break;
            case 'f':
                opts.show_dirs = false;
                break;
            case 'h':
                opts.show_hidden = true;
                break;
            case 'H':
                print_usage(argv[0]);
                return 1;
            case 'l': {
                //TODO: convert num_string to a actual integer here!
                //otps.max_depth = whatever that convert to.
                /**
                 while (num_string[i] && (num_string[i] >= '0' && num_string[i] <= '9')) {
                    num = num * 10 + (num_string[i] - '0');
                    i++;
                    if(num_string[i] && (num_string[i] <  '0' || num_string[i] > '9')){
                        return 1;
                    }
                 }
                 */
                opts.max_depth = num;
                char *end;
                opts.max_depth = (int) strtol(optarg, &end, 10);
                if (end == optarg) {
                    fprintf(stderr, "Unforunately that is not a number! \n");
                    print_usage(argv[0]);
                    return 1;
                }
                break;
            }
            case '?':
                if (optopt == 's') {
                    fprintf(stderr, "Option -%c requires an argument.\n", optopt);
                } else if (isprint(optopt)) {
                    fprintf(stderr, "Unknown option '-%c'.\n", optopt);
                } else {
                    fprintf(stderr, "Unknown option character `\\x%x'.\n", optopt);
                }
                print_usage(argv[0]);
                return 1;
            default:
                abort();
        }
    }

    /* Default values. We search the current working directory (CWD) '.', and
     * provide an empty search string (no filtering applied). */
    char *dir = ".";
    char *search = "";
    int depth = 1;

    /* Both of the following arguments are optional, so we have to check for
     * their presence first. */

    if (optind < argc) {
        // We have one extra argument after the options.
        // This should be the search directory.
        dir = argv[optind];
    }

    // check if dir exists, if not, return 1
    DIR* temp_dir = opendir(dir);
    if (temp_dir) {
        /* Directory exists. */
        closedir(temp_dir);
    } else {
        return 1;
    }

    if (optind + 1 < argc) {
        // One more extra argument. Should be the search pattern.
        search = argv[optind + 1];
    }

    LOG("Starting search. Directory: %s; Search pattern: %s\n", dir, search);
    LOG("Depth limit: %d; Exact match %s; Show files %s; Show dirs %s; Show hidden %s\n",
            opts.max_depth,
            opts.exact_match ? "ON" : "OFF",
            opts.show_files ? "ON" : "OFF",
            opts.show_dirs ? "ON" : "OFF",
            opts.show_hidden ? "ON" : "OFF");

    // TODO: call your recursive directory traversal function here.
    //       Hint: you may also want to design a function that determines
    //       whether a file/directory should be printed or not based on the
    //       options that we just configured above.

    // recursive_search(&opts, dir, search);
    recursive_search(&opts, dir, search, depth);
    return 0;
}