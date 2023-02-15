/**
 * readdir.c
 *
 * Demonstrates reading directory contents.
 */
#include <string.h>
#include <dirent.h>
#include <stdio.h>

struct struct_name {
    int first_integer;
    int second_integer;
    float single_float;
    char first_name[500];
};

void to_string(struct struct_name *s) {
    printf("got some data here [%s]: %d, %d, %f\n", s->first_name, s->first_integer, s->second_integer, s->single_float);
}

int main(void) {
    DIR *directory;
    //ls
    //opens CWD (".")
    if ((directory = opendir(".")) == NULL) {
        perror("opendir");
        return 1;
    }

    struct dirent *entry;
    while ((entry = readdir(directory)) != NULL) {
        printf("-> %s\n", entry->d_name);
        if (entry->d_type == DT_DIR){
            //this is directory
        }
    }


    /* Creating a struct: */

    struct struct_name s; /* <-- Values may be uninitialized */
    /* Creating a struct and populating it: */
    struct struct_name s1;
    s1.first_integer = 3;
    s1.second_integer = 9;
    s1.single_float = 3.3f;
    strcpy(s1.first_name, "John");

    /* The same thing, but defined inline: */
    struct struct_name s2 = { 3, 9, 3.3f };
    /* Initializing everything to 0: */
    struct struct_name s3 = { 0 };

    to_string(&s1);

    closedir(directory);

    return 0;
}