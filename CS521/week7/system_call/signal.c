/**
 * signal.c
 *
 * Demonstrates signal handling. During normal operation this program counts up
 * each second, starting from 1. Upon receiving SIGINT, the final count will be
 * printed and the program will exit. Many programs use this type of signal
 * handling to clean up and gracefully exit when the user presses Ctrl+C.
 *
 * Compile: gcc -g -Wall signal.c -o signal
 * Run: ./signal
 */

#include <signal.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

unsigned long count = 0;

void sigint_handler(int signo) {
    printf("\n");
    printf("Final count is: %ld\n", count);
    printf("Goodbye!\n");
    exit(0);
}

int main(void) {

    /* Set up our signal handler. SIGINT can be sent via Ctrl+C */
    signal(SIGINT, sigint_handler);

    while (true) {
        count++;
        printf("Count: %ld\n", count);
        sleep(1);
    }

    return 0;

}