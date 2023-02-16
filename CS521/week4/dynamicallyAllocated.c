#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char *hello(void) {
    // char *buf = "This is a great program";
    char *buf = malloc(sizeof(char) * 128); //null becuase when we return function, anything decleared on buf[128] will get cleaned up.
    strcpy(buf, "This is a great program");
    return buf;
}

int *hello2(void) {
    int *i = malloc(sizeof(int));
    *i = 8;
    return i; //dont return in local function
}

int foo() {
    char *str = malloc(1024 * 1024 * 1024);
    strcpy(str, "QQWWEERRTTYYYY");
    return foo();
}

int main(void) {
    char *result = hello();
    printf("The result is: %s\n", result);

    int *result2 = hello2();
    printf("this result is again: %d\n", *result2);

    // foo();
    free(result);
    free(result2);

    int * i = malloc(sizeof(int));
    *i = 3;
    printf("%d\n", *i);
    free(i);
    *i = 24;
    printf("%d\n", *i);

    char *my_string = malloc(5000);
    printf("Here is my string: %s\n", my_string);
    strcpy(my_string, "Changing my_string to a really long thing just to test this!");

    // int *ints = malloc(sizeof(int) * 500);
    int *ints = calloc(sizeof(int), 500);
    ints[3] = 24;
    ints[0] = 9;

    for (int x = 0; x < 500; ++x) {
        printf("ints[%d] = %d\n",x, ints[x]);
    }
    /*prefer in class*/
    int *other_ints = malloc(200 * sizeof(int));
    /*prefer in self writing,  below same thing as malloc, calloc*/
    memset(other_ints, 0, sizeof(*other_ints) * 200);

    // How can we make this relevant to our project?
    // ----> allocating file paths dynamically
    /**
        find /etc
        open /etc, find its contents
             for each directry, open those, and so on and on and on
             passwd ->/etc/passwd
    */

    return 0;
}