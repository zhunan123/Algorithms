#include <stdio.h>
#include <string.h>

int main(void) {
   char y[] = "HelloWorld my password is: hunter2";
   char x[5] = {'H', 'E', 'L', 'L', 'O'}; //character has size of 1 so when sizeof(x) is 5
   char z[200] = "World  why is this happening"; //just gonna be the stirng since theres a termintor(0\) in the end
   int b[10] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; //size of a int array is the size of int(4) * size of array, in this case sizeof(b) = 10 * 4 = 40


   printf("The sizes of y, x, z are: %zu %zu %zu %zd\n", sizeof(y), sizeof(x), sizeof(z), sizeof(b));
   printf("%s\n", x);

   printf("%s\n", z); //if the array size is exceeding it still will just print the string;

   size_t len = strlen(z);//length will be length of string, size will be the size the array that is initialized
   z[len] = 'f'; //replacing the null byte with 'f'; ---->这样就没有terminator 0\了 ，print world why is this happeningf

   return 0;
}