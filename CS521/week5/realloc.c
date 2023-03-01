#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int *arr = malloc(sizeof(int) * 12);

    for (int i = 0; i < 12; i++) {
        arr[i] = i + 5;
    }

    int *temp_arr = realloc(arr, sizeof(int) * 24);
    if (temp_arr == NULL) {
        perror("realloc");
    } else {
        arr = temp_arr;
    }

    for (int i =0; i < 24; i++) {
        printf("arr[%d] = %d\n", i, arr[i]);
    }

    arr = realloc(arr, sizeof(int) * 3);

    int *y = malloc(sizeof(int) * 1);
    *y = 521;
    puts("Second time around");

    for (int i =0; i < 24; i++) {
        printf("arr[%d] = %d\n", i, arr[i]);
    }

    printf("memory address of arr: %p\n", arr);
    printf("memory address of y: %p\n", y);

    return 0;
}