/**
 * readdir.c
 *
 * Demonstrates reading directory contents.
 */

#include <dirent.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(void) {
    char *start_path = "/etc";
    DIR *directory;
    // opens the CWD: (".")
    if ((directory = opendir(start_path)) == NULL) {
        perror("opendir");
        return 1;
    }

    struct dirent *entry;
    while ((entry = readdir(directory)) != NULL) {
        // base path, subdirectory, slash, and the null terminator!!!!
        char *buf = malloc(strlen(start_path) + strlen(entry->d_name) + strlen("/") + 1);
        if (buf == NULL) {
            // something bad happened! We don't have enough memory to allocate
        }
        // use either strcpy (first string) + strcat, or do this:
        sprintf(buf, "%s/%s", start_path, entry->d_name);

        printf("-> %s\n", buf);
        if (entry->d_type == DT_DIR) {
            // this is a directory!
        }
        free(buf);
    }

    closedir(directory);
    return 0;
}