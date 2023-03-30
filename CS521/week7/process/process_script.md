[zshuai@zshuai-vm nth-day]$ htop
[zshuai@zshuai-vm nth-day]$ ps
PID TTY          TIME CMD
3570003 pts/2    00:00:00 bash
3827594 pts/2    00:00:00 ps
[zshuai@zshuai-vm nth-day]$ ps aux
USER         PID %CPU %MEM    VSZ   RSS TTY      STAT START   TIME COMMAND
root           1  0.0  0.0 168068  7636 ?        Ss   Jan23  11:59 /usr/lib/systemd/systemd --system --deserialize 19
dbus          31  0.0  0.0   8780  1604 ?        Ss   Jan23   3:14 /usr/bin/dbus-daemon --system --address=systemd: --nofork --nopidfile --systemd-activation --syslog-
root          33  0.0  0.0  16968   384 ?        Ss   Jan23   2:41 /usr/lib/systemd/systemd-logind
zshuai        35  0.0  0.0  25456   180 ?        Ss   Jan23   2:13 /usr/bin/ttyd -p 12481 /usr/local/bin/busybox login
root          39  0.0  0.0   3052     0 pts/0    Ss+  Jan23   0:00 /sbin/agetty -o -p -- \u --noclear --keep-baud - 115200,38400,9600 vt220
root          68  0.0  0.0  10188   372 ?        Ss   Jan23   0:00 sshd: /usr/bin/sshd -D [listener] 0 of 10-100 startups
root     3257936  0.0  0.0  49808  8396 ?        Ss   Mar10   0:05 /usr/lib/systemd/systemd-journald
zshuai   3257944  0.0  0.0 710284 25820 ?        Ssl  Mar10   0:01 /usr/lib/code-server/lib/node /usr/lib/code-server
zshuai   3257965  0.0  1.2 1790340 799344 ?      Rl   Mar10  21:59 /usr/lib/code-server/lib/node /usr/lib/code-server/out/node/entry
zshuai   3257976  0.0  0.0 939376 41512 ?        Rl   Mar10  26:21 /usr/lib/code-server/lib/node /usr/lib/code-server/lib/vscode/out/bootstrap-fork --type=ptyHost --lo
zshuai   3378121  0.0  0.0 835392 18636 ?        Sl   Mar10   3:07 /usr/lib/code-server/lib/node /usr/lib/code-server/lib/vscode/out/bootstrap-fork --type=fileWatcher
zshuai   3520919  0.0  0.0 835476 17740 ?        Sl   Mar12   2:41 /usr/lib/code-server/lib/node /usr/lib/code-server/lib/vscode/out/bootstrap-fork --type=fileWatcher
zshuai   3570003  0.0  0.0   5472  2696 pts/2    Ss   Mar23   0:00 /usr/bin/bash --init-file /usr/lib/code-server/lib/vscode/out/vs/workbench/contrib/terminal/browser/
zshuai   3664294  0.0  0.0 622136 14164 ?        Sl   Mar28   0:03 /usr/lib/code-server/lib/node /usr/lib/code-server/lib/vscode/out/bootstrap-fork --type=fileWatcher
zshuai   3765221  5.0  0.1 975444 99436 ?        Sl   Mar29  15:38 /usr/lib/code-server/lib/node /usr/lib/code-server/lib/vscode/out/bootstrap-fork --type=extensionHos
zshuai   3765364  0.0  0.0 835648 22632 ?        Sl   Mar29   0:14 /usr/lib/code-server/lib/node /usr/lib/code-server/lib/vscode/out/bootstrap-fork --type=fileWatcher
zshuai   3765384  0.0  0.0 2167992 36712 ?       Sl   Mar29   0:05 /usr/bin/clangd
zshuai   3777769  0.0  0.0 595204 30992 ?        Sl   Mar29   0:05 /usr/lib/code-server/lib/node /usr/lib/code-server/lib/vscode/extensions/markdown-language-features/
root     3782067  0.0  0.0 152380  1472 ?        Ss   Mar29   0:00 gpg-agent --homedir /etc/pacman.d/gnupg --use-standard-socket --daemon
zshuai   3827619  0.0  0.0   7704  2252 pts/2    R+   00:18   0:00 ps aux
[zshuai@zshuai-vm nth-day]$ ps -r | wc -l
2
[zshuai@zshuai-vm nth-day] $ htop
[zshuai@zshuai-vm nth-day]$ uptime (tell load average, how many time your machine is up)
[zshuai@zshuai-vm nth-day]$ ps aux | grep a.out   (grep is finding a particular file, in this case is find the details of a.out file)
zshuai   3854625  0.0  0.0   2484   700 pts/2    S+   10:46   0:00 ./a.out
zshuai   3854696  0.0  0.0   3976  1616 pts/1    S+   10:46   0:00 grep a.out
[zshuai@zshuai-vm nth-day]$ kill -s SIGSEGV 3854625 (kill the process with seg fault, but we can block the seg fault signal)
[zshuai@zshuai-vm nth-day]$ kill -9 3854625 / kill -s SIGKILL 3854625(brutal kill) / kill -9 %%
[zshuai@zshuai-vm nth-day]$ ctrl-z to stop then fg to continue 