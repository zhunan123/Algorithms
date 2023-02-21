#include <studio.h>
#include <stdbool.h>


void readFile(File *file) {
    char buf[1024];
        //read stdin
    while (fgets(buf, 1024, stdin) != NULL) {
      fputs(buf, stdout);
    }
}

int main(int argc, char *argv[]) {
    //we have no args: read from stdin
    //we have a - : also read from stdin
    //otherwise, try to open a file
    if (argc == 1) {
        readFile(stdin);
        return 0;
    }

    for (int i = 1; i < argc; i++){
        bool is_stdin = false;
        FILE * file;
        if ((strcmp(argv[i][0], "-") == 0) {
            file = stdin;
            is_stdin = true;
        } else {
            file = fopen(argv[i], r);
            if (file == NULL) {
                perror("fopen");
            continue;
            }
        }
        readFile(file);
        if (!is_stdin) {
            rewind(stdin);
        }
    }
 }