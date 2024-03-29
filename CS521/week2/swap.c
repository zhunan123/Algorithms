#include <stdio.h>
#include <fcntl.h>

void swap(int *a, int *b) {
    printf("Memory address of a and b: %p, %p\n", &a, &b); //printing address of *a, *b(the copy of memory adress)
    printf("Memory address of a and b: %p, %p\n", a, b);  //printing pointers/actual memory address
    int a_copy = *a;  //*means need to dereference it.----->dereference it in order to change/swap the value of a and b;
    int b_copy = *b;

    *a = b_copy;
    *b = a_copy;
}

int main(void) {
    int a = 3;
    int b = 8;
    printf("%d, %d\n", a, b);
    swap(&a, &b); //& is the actual memory address
    printf("Memory address of a and b: %p, %p\n", &a, &b);
    printf("%d, %d\n", a, b);

    int fd = open("file.txt", O_RDONLY);
    if (fd = -1) {
        perror("open");
    }