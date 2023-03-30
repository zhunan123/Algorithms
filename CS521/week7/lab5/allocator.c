/**
 * @file allocator.c
 * @author zshuai
 *
 * Implements a C memory allocator with a FIFO free list cache. Users can set
 * ALLOC_THRESH to determine how many free blocks are cached in the free list.
 */

#include <stddef.h>
#include <string.h>
#include <sys/mman.h>
#include <stdlib.h>

#include "logger.h"
#include "trace.h"

#define DEFAULT_THRESH 100

static size_t list_size = 0; /*< Actual Size of the list right now */
static ssize_t list_thresh = -1; /*< Max size of the list (threshold)*/

// TODO: add static instance variables here. Since you are maintaining a
//       doubly-linked list, you'll want to store the head, tail, etc.
//       You will also want to create functions that modify your linked
//       list so your code is easier to test.

struct mem_block {
    size_t size;
    struct mem_block *next_free;
    struct mem_block *prev_free;
};

struct mem_block *head = NULL;
struct mem_block *tail = NULL;

// Add a block (at HEAD!) to the doubly-linked free list.
void add_free(struct mem_block *block)
{
    // add block (at HEAD!) to the doubly-linked free list
    block->prev_free= NULL;
    block->next_free = head;
    if (head != NULL) {
        head->prev_free = block; // set the old head's prev to the new head
    } else {
        tail = block; // if head is NULL, we're adding the first block, so set the tail to the new head
    }
    head = block; // set the new head to the block

    list_size++;
}

// Remove a block from the doubly-linked free list.
void remove_free(struct mem_block *block)
{
    // remove a block from the list (update the links of its neighbors)
    struct mem_block *prev = block->prev_free; // previous block
    struct mem_block *next = block->next_free; // next block

    if (prev != NULL) {
        prev->next_free = next; // set the previous block's next to the next block
    } else {
        head = next; // if prev is NULL, we're removing the head, so set the new head to next
    }

    if (next != NULL) {
        next->prev_free = prev; // set the next block's prev to the previous block
    } else {
        tail = prev; // if next is NULL, we're removing the tail, so set the new tail to prev
    }

    // Just to be safe, set the pointers to NULL
    block->next_free = NULL;
    block->prev_free = NULL;
    list_size--;
}

// Loop through the free list (starting at TAIL), see if any blocks are big enough
// if we find one, return it
void *find_reusable(size_t size)
{
    // loop through the free list (starting at TAIL), see if any blocks are big enough
    // if we find one, return it
    struct mem_block *block = tail;
    while (block != NULL) {
        if (block->size >= size) {
            return (void *)block;
        }
        block = block->prev_free;
    }
    return NULL;
}

void init_list(void)
{
    // how to work with env variables from the shell:
    // - export VARIABLE=something   # sets VARIABLE to something (don't add spaces!)
    // - unset VARIABLE              # undefines an environment variable
    // Environment variables are UPPERCASE by convention (but don't have to be)
    //
    if (list_thresh == -1) { // we haven't initialized the threshold yet
        list_thresh = DEFAULT_THRESH;
        char *threshold = getenv("ALLOC_THRESH");
        if (threshold != NULL) {
            // read it
            list_thresh = strtol(threshold, NULL, 10);
        }
        LOG("Initialized our free list with size: %zu\n", list_thresh);
    }
}

/**
 * The malloc() function allocates size bytes and returns a pointer to the
 * allocated memory. The memory is not initialized.
 */
void *malloc(size_t size)
{
    init_list();

    // malloc(128) -> give me 128 bytes of memory to use
    // we can do mmap(128) and get 128 bytes of memory.. no problem!
    // but then we can't free it later: we don't know its size
    //
    // we need to know how big each allocation is so we can use munmap later
    // to know how big it is, we'll put a struct at the beginning of each allocation:
    //
    //     +---------------------+--------------------------------+
    //     | Header (size info)  | Actual data goes here (128)    |
    //     +---------------------+--------------------------------+
    //
    // Great! We have the allocation plus a struct with size info!
    // When we return it back to the user, we do this:
    //
    //     +---------------------+--------------------------------+
    //     | Header (size info)  | Actual data goes here (128)    |
    //     +---------------------+--------------------------------+
    //                           ^
    //                           |
    //                           +----- pointer that we return to the user (start of the data)

    size_t block_size = size + sizeof(struct mem_block);
    LOG("malloc request. size: %zu, block size: %zu\n", size, block_size);

    // TODO: scan through your doubly-linked free list, starting at the tail,
    //       and return a viable block if you find one. If no viable blocks are
    //       in the list, you can mmap a new block.

    struct mem_block *reuseable_block = find_reusable(block_size);
    if (reuseable_block != NULL) {
        remove_free(reuseable_block);
        return reuseable_block + 1;
    }

    // No reusable blocks, so we need to mmap a new block
    struct mem_block *block = mmap(
        NULL,
        block_size,
        PROT_READ | PROT_WRITE,
        MAP_PRIVATE | MAP_ANONYMOUS,
        -1,
        0);

    // Check for mmap errors
    if (block == MAP_FAILED) {
        perror("mmap");
        return NULL;
    }

    block->size = block_size;
    TRACE("Allocated block [%p]: %zu bytes", block, block_size);
    return block + 1;
}

/**
 * The free() function frees the memory space pointed to by ptr, which must
 * have been returned by a previous call to malloc() or related functions.
 * Otherwise, or if ptr has already been freed, undefined behavior occurs.
 * If ptr is NULL, no operation is performed.
 */
void free(void *ptr)
{
    if (ptr == NULL) {
        /* Freeing a NULL pointer does nothing. */
        return;
    }

    struct mem_block *block = (struct mem_block *) ptr - 1;
    LOG("free request. ptr: %p, size: %zu\n", block, block->size);
    size_t block_size = block->size;

    // TODO: find out what the size of the free list should be by checking the
    //       ALLOC_THRESH environment variable (note that getenv returns a
    //       string, not a number). You can store the size so you don't need to
    //       look it up every time.
     if ((ssize_t) list_size < list_thresh) {
        // add it to the list
        add_free(block);
        return;
    }

    // TODO: if there is space in our free list, add the block to the head of
    //       the list instead of unmapping it.
    if (munmap(block, block->size) == -1) {// The list is full, so we need to unmap the block
        perror("munmap");
    } else {
        TRACE("Unmapped block -- [%p]: %zu bytes", block, block_size);
    }
}

/**
 * The  calloc()  function  allocates  memory  for an array of nmemb elements
 * of size bytes each and returns a pointer to the allocated memory.  The
 * memory is set to zero.
 */
void *calloc(size_t nmemb, size_t size)
{
    LOG("calloc request. size: %zu memb, %zu bytes each\n", nmemb, size);
    void *ptr = malloc(nmemb * size);
    memset(ptr, 0, nmemb * size);
    return ptr;
}

/**
 * The realloc() function changes the size of the memory block pointed to by
 * ptr to size bytes.  The contents of the memory will be unchanged in the
 * range from the start of the region up to the minimum of the old and new
 * sizes.  If the new size is larger than the old size, the added memory will
 * not be initialized.
 */
void *realloc(void *ptr, size_t size)
{
    // If ptr is NULL, then the call is equivalent to malloc(size)
    if (ptr == NULL) {
        return malloc(size);
    }

    // If size is equal to zero, and ptr is not NULL, then the call is equivalent to free(ptr)
    if (size == 0) {
        free(ptr);
        return NULL;
    }

    LOG("realloc request. ptr: %p, new size: %zu\n", ptr, size);
    // TODO: check if the block can already accommodate the requested size.
    //       if it can, there's no need to do anything
    size_t block_size = size + sizeof(struct mem_block); // actual size needed
    struct mem_block *block = (struct mem_block *)ptr - 1;
    if (block->size >= block_size) { // if the block is bigger than the requested size, we can just return the pointer
        return ptr;
    }

    // TODO: if the block can't accommodate the requested size, then
    //       we should allocate a new block, copy the old data there,
    //       and then free the old block.
    void *new_ptr = malloc(size); // The old data size is the old block size minus the size of the header
    memcpy(new_ptr, ptr, block->size - sizeof(struct mem_block));
    free(ptr);

    return new_ptr;
}
