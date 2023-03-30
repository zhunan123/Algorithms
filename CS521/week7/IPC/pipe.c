#include <fcntl.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

//cat /etc/passwd | grep bananas > something.txt
//argv[1] -> file to read
//argv[2] -> string to search for
//argv[3] -> file to write the output tp


int main(int argc, char *argv[]) {

    char *cat_args[3];
    cat_args[0] = "cat";
    cat_args[1] = argv[1];
    cat_args[2] = NULL;

    char *grep_args[3];
    grep_args[0] = "grep";
    grep_args[1] = argv[2];
    grep_args[2] = NULL;

    /* Creates a pipe. */
    int fd[2];
    pipe(fd);

    pid_t pid = fork();
    if (pid == 0) {
        /* Child */
        close(fd[1]);
        dup2(fd[0], STDIN_FILENO);
        int output = open(argv[3], O_CREAT | O_WRONLY, 0666);
        dup2(output, STDOUT_FILENO);
        execvp(grep_args[0], grep_args);
        close(fd[0]);
    } else {
        /* Parent */
        close(fd[0]);
        dup2(fd[1], STDOUT_FILENO);
        execvp(cat_args[0], cat_args);
        close(fd[1]);
    }

