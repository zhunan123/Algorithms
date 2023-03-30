[zshuai@zshuai-vm nth-day]$ sudo pacman -Sy sl
[zshuai@zshuai-vm nth-day]$ time sl
[zshuai@zshuai-vm nth-day]$ sudo pacman -Sy strace
[zshuai@zshuai-vm nth-day]$ strace ls (check how many system call we used)
[zshuai@zshuai-vm nth-day]$ strace --summary-only ls /
bin  boot  bootstrap.sh  dev  etc  home  lib  lib64  mnt  opt  proc  root  run  sbin  srv  sys  tmp  usr  var
% time     seconds  usecs/call     calls    errors syscall
------ ----------- ----------- --------- --------- ----------------
  0.00    0.000000           0        14           read
  0.00    0.000000           0         1           write
  0.00    0.000000           0        23           close
  0.00    0.000000           0        25           mmap
  0.00    0.000000           0         4           mprotect
  0.00    0.000000           0         2           munmap
  0.00    0.000000           0         5           brk
  0.00    0.000000           0         2           ioctl
  0.00    0.000000           0         2           pread64
  0.00    0.000000           0         1         1 access
  0.00    0.000000           0         1           execve
  0.00    0.000000           0         6         4 prctl
  0.00    0.000000           0         2         1 arch_prctl
  0.00    0.000000           0         1           futex
  0.00    0.000000           0         4           getdents64
  0.00    0.000000           0         1           set_tid_address
  0.00    0.000000           0        23         2 openat
  0.00    0.000000           0        22           newfstatat
  0.00    0.000000           0         1           set_robust_list
  0.00    0.000000           0         1           prlimit64
  0.00    0.000000           0         1           getrandom
  0.00    0.000000           0         1           statx
  0.00    0.000000           0         1           rseq
------ ----------- ----------- --------- --------- ----------------
100.00    0.000000           0       144         8 total
[zshuai@zshuai-vm nth-day]$ strace --summary-only sl
% time     seconds  usecs/call     calls    errors syscall
------ ----------- ----------- --------- --------- ----------------
56.63    0.012288           3      3397           write
21.57    0.004680           2      1617           poll
11.42    0.002479           2       937           rt_sigaction
10.34    0.002244           9       232           clock_nanosleep
0.02    0.000005           0         7         1 newfstatat
0.02    0.000004           0        13           ioctl
0.00    0.000000           0         4           read
0.00    0.000000           0         4           close
0.00    0.000000           0        12           mmap
0.00    0.000000           0         4           mprotect
0.00    0.000000           0         1           munmap
0.00    0.000000           0         5           brk
0.00    0.000000           0         2           pread64
0.00    0.000000           0         2         1 access
0.00    0.000000           0         1           execve
0.00    0.000000           0         2         1 arch_prctl
0.00    0.000000           0         1           set_tid_address
0.00    0.000000           0         4           openat
0.00    0.000000           0         1           set_robust_list
0.00    0.000000           0         1           prlimit64
0.00    0.000000           0         1           getrandom
0.00    0.000000           0         1           rseq
------ ----------- ----------- --------- --------- ----------------
100.00    0.021700           3      6249         3 total

[zshuai@zshuai-vm L5-zhunan123]$ cc allocator.c -Wall -fPIC -shared -o allocator.so
[zshuai@zshuai-vm L5-zhunan123]$ LD_PRELOAD=$(pwd)/allocator.so ls
[zshuai@zshuai-vm L5-zhunan123]$ LD_PRELOAD=$(pwd)/allocator.so strace --summary-only ls  (this with customized allocator)
[zshuai@zshuai-vm L5-zhunan123]$ cc allocator.c -Wall -fPIC -shared -DLOGGER=0 -DTRACE_ON=0 -o allocator.so
[zshuai@zshuai-vm L5-zhunan123]$ kill -s SIGUSER1 3324
[zshuai@zshuai-vm L5-zhunan123]$ grep neato (search for file called neato)