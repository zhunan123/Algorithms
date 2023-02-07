#include <stdio.h>
#include <string.h>

int main(void) {
    char *target = "shirk";

    for (int i = 0; i < 6; i++)  {
        char guess[100];
        printf("Enter your name: ");
        scanf("%s", guess);

        if (strlen(guess) != 5) {
            printf("that is not 5 character, please do it again.\n");
        }

        for (int j = 0; j < 5; j++) {
            if (target[i] == guess[j]) {
                printf("o");
            } else if (strchr(target, guess[j]) != NULL) {
                printf("a");
            } else {
                printf("x");
            }
        }
        printf("\n");

         if (strncmp(target, guess, 5) == 0) {
            printf("you win!\n");
            break;
        }
    }
}