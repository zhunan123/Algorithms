#include <stdio.h>
#include <string.h>;

int main(void) {
   char y[] = "HelloWorld my password is: hunter2";
   char x[5] = {'H', 'E', 'L', 'L', 'O'};
   char z[200] = "World  why is this happening"; //just gonna be the stirng since theres a termintor(0\) in the end

   printf("The sizes of y, x, z are: %zu %zu %zu\n", sizeof(y), sizeof(x), sizeof(z));
   printf("%s\n", x);

   printf("%s\n", z); //if the array size is exceeding it still will just print the string;

   size_t len = strlen(z);//length will be length of string, size will be the size the array that is initialized
   z[len] = 'f'; //replacing the null byte with 'f'; ---->这样就没有terminator 0\了 ，print world why is this happeningf

   return 0;
}