#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(void) {
    /* Tokenize based on space and newline characters: */
    char line[] = "Here is my amazing line of text!";
    char *token = strtok(line, " \n"); //dereference pointer
    while (token != NULL) {
        /* do something with token */
        /* then grab the next token: */
        printf("-> %s\n", token);
        token = strtok(NULL, " \n");
    }

    // printf("we are done now, here is the contents of line: %s\n", &line[11]);
    printf("we are done now, here is the contents of line: %s\n", line + 11);


    /* Tokenize based on space and newline characters: */
    char *line2 = malloc(128 * sizeof(char));
    strcpy(line2, "Here is my amazing line of text!");
    char *token2;
    char *ptr_copy = line2;

    while ((token2 = strsep(&line2, " \n")) != NULL) {
        printf("-> %s [%p]\n" , token2, line2);
    }
    /* DANGER: MEMORY LEAK! (and a sneaky one at that) */
    printf("This is what it is: %s\n", line2); //line2 can be null; cannot free(line2);
    free(ptr_copy);
}