#include <stdio.h>
#include <string.h>

int main(void) {
    /**
     - Requirements
        1.Open a text file with words to use (maybe in /usr/share/dict ?)
            -> make a word list from those words(only 5 letters, no special char)
        2. Pick one word randomly
        3. Read guesses on standard input(stdin) -- but only give them 6 chances
            -> Check if its a actually a valid word
            -> Check if the letter is in the right spot, or at least in the word.
        4. Either print that they win or lose. (with personalization, e.g., "you are terrible")
        5. Let user know which letters have already been used
            ->Track which letters are wrong
        6. Ask them if they want to play again
        7.Have some way showing what was right/wrong, how many times guesses, how many left

     - Special Features;
        1.Stats(wins, losses, how many guesses, streaks) / previous result
            -> Print to text file for bragging rights
        2.Let user choose the size of the word
        3.Use colors to indicate right, wrong and "out of place"
        4.Cowsay integration
        5.Time limit
    */
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