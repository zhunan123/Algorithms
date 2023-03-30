CC = cc
CFLAGS = -Wall

allocator.so: allocator.c
	$(CC) $(CFLAGS) -shared -fPIC -DLOGGER=0 -DTRACE_ON=0 $^ -o $@

clean:
	rm allocator.so

allocator.o: allocator.c logger.h trace.h