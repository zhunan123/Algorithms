[zshuai@zshuai-vm nth-day]$ grep neato file.txt | sort   (seatch neato in file.txt and then send output to sort so that we can sort the outfile line by line)
[zshuai@zshuai-vm nth-day]$ mkfifo pipe(create a named pipe)
[zshuai@zshuai-vm nth-day]$ mkfifo pipe
[zshuai@zshuai-vm nth-day]$ ls
L5-zhunan123  a.out  fork.c  pipe  readdir.c  shell.c  shell.txt  signal.c
[zshuai@zshuai-vm nth-day]$ ls -l
total 63
drwxr-xr-x 3 zshuai wheel    19 Mar 29 23:40 L5-zhunan123
-rwxr-xr-x 1 zshuai wheel 15592 Mar 30 10:47 a.out
-rw-r--r-- 1 zshuai wheel  1423 Mar 30 00:33 fork.c
prw-r--r-- 1 zshuai wheel     0 Mar 30 11:17 pipe
-rw-r--r-- 1 zshuai wheel   342 Mar 29 22:51 readdir.c
-rw-r--r-- 1 zshuai wheel  2720 Mar 23 16:12 shell.c
-rw-r--r-- 1 zshuai wheel   241 Mar 23 15:11 shell.txt
-rw-r--r-- 1 zshuai wheel  1013 Mar 30 10:47 signal.c
[zshuai@zshuai-vm nth-day]$ echo hi > pipe (send data to pipe)
[zshuai@zshuai-vm nth-day]$ cat < pipe  (will read the file)
[zshuai@zshuai-vm nth-day]$ ls / > pipe (send ls stuff to pipe file)
