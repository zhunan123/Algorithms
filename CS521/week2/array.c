#include <stdio.h>

//the function decays into pointer, so it doesn't know about the size of array.
void good_function(int x[]) {
    printf("Memory address of x is: %p\n", &x);//address of the copy of the memory addressthat was made
    printf("Memory address of x (again) is: %p\n", x); //actual address/pointer
    printf("Size of an int is: %zu\n", sizeof(x) / sizeof(int)); //2
}

int main(void) {
    int a;
    int cool_array[4049];
    printf("Memory address of cool_array is: %p\n", &cool_array); //actual memory location of the array

    for (int i = 0; i< 4049; ++i) {
        if (cool_array[i] != 0) {
            printf("%d\n", cool_array[i]);
        }
    }

    printf("Size of an int is: %zu\n", sizeof(cool_array) / sizeof(int));

    good_function(cool_array);

    return 0;
}