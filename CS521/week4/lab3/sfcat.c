/**
 * sfcat.c -- concatenates files
 *
 * Compile:
 *     make
 * cc -Wall sfcat.c -o sfcat
 * Run:
 *     ./sfcat file1.txt file2.txt etc.
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/* int main(int argc, char *argv[])
{
    //TODO Build your own version of `cat`. Functions to use:
    //    - fopen
    //    - fgets
    //    - fclose

    FILE *file = NULL;
    char str[1000];
    char line[128]; //buffer
    int cur_file = argc > 1 ? 1 : 0;

    while (cur_file < argc) {
        if (argc > 1 && *argv[1] != '-') {
            file = fopen(argv[cur_file], "rb");
            if (file == NULL) {
                printf("%s : no such file or directory\n", argv[cur_file]);
                exit(1);
            }
        } else {
            scanf("%[^\n]s",str);
            printf("%s\n", str);
            return 0;
        }
        while (fgets(line, sizeof(line), file)) {
            int c;
            int len = strlen(line);
            line[len] = '\0';

            if((c = fgetc(file)) != EOF) {
                printf("%s", line);
            } else {
                printf("%s\n", line);
            }
        }
        fclose(file);
        cur_file++;
    }
    return 0;
}
*/

int main(int argc, char *argv[])
{
    //TODO Build your own version of `cat`. Functions to use:
    //    - fopen
    //    - fgets
    //    - fclose

    FILE *file = NULL;
    char str[1000];
    char line[4096]; //buffer
    int cur_file = argc > 1 ? 1 : 0;

    while (cur_file < argc) {
        // printf("%d %s", cur_file, argv[cur_file]);
        if (argc > 1 && *argv[cur_file] != '-') {
            file = fopen(argv[cur_file], "r");
            if (file == NULL) {
                printf("%s : no such file or directory\n", argv[cur_file]);
                exit(1);
            }
            while (fgets(line, sizeof(line), file)) {
                printf("%s", line);
            }
            fclose(file);
            printf("\n");
        } else {
            /* if has echo, print whatever echo text , else print stdin*/
            /* echo Wow | ./sfcat README.md - sfcat.c */
            scanf("%[^\n]",str);
            printf("%s\n", str);
        }
        cur_file++;
    }
    return 0;
}
