/**
 * fork.c
 *
 * Demonstrates using the fork() system call.
 *
 */

#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

//how to clone a process and run something else

int main(void)
{
    pid_t my_pid = getpid();
    printf("Starting up, my PID is %d\n", my_pid);
    pid_t child = fork(); //create a clone of our process
    //fork return 3 possibilities, -1 error, 0->process, #->process of parent
    if (child == -1) {
        perror("fork");
    } else if (child == 0) {
        /* I am the child */
        pid_t my_pid = getpid();
        printf("Hello from the child! PID = %d. Going to sleep.\n", my_pid);
        sleep(5);
        //turn the program we wrote into ls -l, replaces the child process with a completely different image, so a.out has now become 'ls -l'
        execl("/bin/ls", "ls", "-l", (char *) 0); //make the child do ls -l
        printf("hi\n"); /* Will this print? */
        // no, it will not because the process got replaces with 'ls'
    } else {
        /* I am the parent */
        pid_t my_pid = getpid();
        printf("Hello from the parent! PID = %d\n", my_pid);
        printf("PID %d waiting for its child (%d)!\n", my_pid, child);
        int status;
        wait(&status);// parent will not pass this point until child is finished.
        printf("Child finished executing. Parent exiting.\n");
    }

    return 0;