# Memory Allocator with FIFO Free List

## Submitting

Remember to check in your code and Makefile. Edit this README.md file to report and discuss your benchmark results.

## build
run `make`\
run `make clean`

## test
run `ALLOC_THRESH=10 LD_PRELOAD=$(pwd)/allocator.so find /home`     
run `cc allocator.c -shared -fPIC -DLOGGER=0 -DTRACE_ON=1 -o allocator.so`
run `ALLOC_THRESH=5 LD_PRELOAD=$(pwd)/allocator.so ./allocator-test`
* results below================>>>
  [TRACE] malloc(): Allocated block [0x7fbe27e64000]: 25 bytes     
  [TRACE] malloc(): Allocated block [0x7fbe27e63000]: 27 bytes     
  [TRACE] malloc(): Allocated block [0x7fbe27e62000]: 29 bytes    
  [TRACE] malloc(): Allocated block [0x7fbe27e61000]: 31 bytes   
  [TRACE] malloc(): Allocated block [0x7fbe27e60000]: 33 bytes     
  [TRACE] malloc(): Allocated block [0x7fbe27e5f000]: 35 bytes     
  [TRACE] free(): Unmapped block -- [0x7fbe27e5f000]: 35 bytes     
  [TRACE] malloc(): Allocated block [0x7fbe27e5f000]: 36 bytes      
  [TRACE] malloc(): Allocated block [0x7fbe27e5e000]: 1024 bytes     
  [TRACE] malloc(): Allocated block [0x7fbe27e5d000]: 1048 bytes     
  X is: 99         
  [TRACE] free(): Unmapped block -- [0x7fbe27e5e000]: 1024 bytes    
  [TRACE] free(): Unmapped block -- [0x7fbe27e63000]: 27 bytes

## Benchmarking
run `sudo pacman -Syu time`
run `ALLOC_THRESH=100 LD_PRELOAD=$(pwd)/allocator.so /usr/bin/time find / > /dev/null`
* The result I got is:
  0.04user 0.17system 0:11.02elapsed 2%CPU (0avgtext+0avgdata 15536maxresident)k
  128inputs+0outputs (3major+6307minor)pagefaults 0swaps

from my observation, when threshold=100, the program take 11.02 seconds to run.
* then we added run.sh to modify value of threshold
  run `chmod +x run.sh`

run `./run.sh`

run `sort -n -k 2 benchmark.out | head -n1`

results:
--->  0	5.73\
---> 10	3.24\
---> 20	2.71\
---> 30	2.35\
---> 40	2.27

results based on termgraph:        
0 : ▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇ 5.73         
10: ▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇ 3.24            
20: ▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇ 2.71           
30: ▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇ 2.35         
40: ▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇ 2.27

from my observation, the best threshold mightbe 40.