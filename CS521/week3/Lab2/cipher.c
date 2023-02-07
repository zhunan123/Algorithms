/**
 * cipher.c -- implements a reciprocal letter substitution cipher.
 *
 * The current version of this code provides an implementation of a basic ROT-13
 * cipher on lowercase letters. You'll implement the rotate() function to allow
 * arbitrary ranges of characters (assuming the range is evenly divisible to
 * ensure our cipher is reciprocal).
 *
 * Once completed, you should use the following ranges of characters for
 * encryption:
 *  - 'a', 'z'
 *  - 'A', 'Z'
 *  - ' ', '?' (this includes numeric characters)
 * You may want to take a look at an ASCII table (or implement your own in C) to
 * get a sense of where the characters are located.
 *
 *
 * Compile:
 *  gcc -g -Wall cipher.c -o cipher
 *
 * Run:
 *  # Encrypts 'file.txt':
 *  ./cipher < file.txt
 *
 *  # Encrypts the string 'hello world':
 *  echo "hello world" | ./cipher
 *
 *  # Encrypts and saves the output to a file:
 *  ./cipher < file.txt > encrypted.txt
 *
 *  # Decrypts a file (same as encrypting):
 *  ./cipher < encrypted.txt
 */

#include <stdio.h>

/**
 * Rotates a given character within an overall range of characters as part of a
 * reciprocal cipher algorithm. For example, rotating '3' within the range
 * '0' -- '9' would shift by 5 characters to '8', and rotating '8' again
 * would return it back to '3'.
 *
 * Steps:
 *  1. Determine the size of the range. '0' through '9' would be a range of 10
 *     characters. If the range is not even, then it is invalid and the function
 *     will return -2 to indicate failure.
 *
 *  2. Calculate the amount of characters to rotate. This will be exactly half
 *     the range, so using the previous example would produce a rotation of 5.
 *
 *  3. Perform the rotation (assuming the provided character actually falls
 *     within the specified range).
 *
 * @param ch    pointer to the character to (potentially) rotate. If the
 *              rotation is successful, the character is modified in place and
 *              the function returns 0. Otherwise, the function returns -1 to
 *              indicate that the rotation did not occur.
 * @param start the beginning of the character range
 * @param end   the end of the character range
 *
 * @return  0 if the character was rotated successfully,
 *         -1 if it is out of range, and
 *         -2 if the specified range is invalid (not evenly divisible)
 */
int rotate(int *ch, int start, int end) {
    //is this range invalid, if it is, return -2.
    if ((end - start + 1) % 2 != 0) {
        return -2;
    }
    if (start > end) {
        return -2;
    }

    //target character is in the range
    if (*ch >= start && *ch <= end) {

        int half_range = (end - start + 1) / 2;
        int ch_copy = *ch; //dereference it so we can change the value
        int new_pos = ch_copy + half_range;

        if (new_pos > end) {
            if (new_pos - (end - start + 1) > end || new_pos < start) { //check if start > end
                return -1;
            }
        }

        if (new_pos <= end) { // if won't go back after rotate
            *ch = *ch + half_range;
        } else { //if need to go to start of list after rotate
            *ch = *ch + half_range - (end - start + 1);
        }

        return 0;
    } else {
        //return -1 if character not in the range.
        return -1;
    }
}

int main(void)
{
    int c;
    while ((c = getc(stdin)) != EOF) {
        rotate(&c, 'a', 'z');
        rotate(&c, 'A', 'Z');
        rotate(&c, ' ', '?');
        putc(c, stdout);
    }
    fflush(stdout);

    return 0;
}
