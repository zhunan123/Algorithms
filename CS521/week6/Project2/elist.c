#include <errno.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>

#include "elist.h"

#define DEFAULT_INIT_SZ 10
#define RESIZE_MULTIPLIER 2

struct elist {
    size_t capacity;         /*!< Storage space allocated for list items */
    size_t size;             /*!< The actual number of items in the list */
    size_t item_sz;          /*!< Size of the items stored in the list */
    void *element_storage;   /*!< Pointer to the beginning of the array */
};

bool idx_is_valid(struct elist *list, size_t idx);

/**
 * Creates a new elist using the given size (or the default if set to 0) and
 * element size.
 */
struct elist *elist_create(size_t list_sz, size_t item_sz)
{
    /* initialize elist struct */
    struct elist *list = malloc(sizeof(struct elist));
    if (list == NULL) {
        return NULL;
    }

    if (list_sz == 0) {
        list_sz = DEFAULT_INIT_SZ;
    }

    list->capacity = list_sz;
    list->size = 0;
    list->item_sz = item_sz;
    list->element_storage = malloc(list_sz * item_sz);
    if (list->element_storage == NULL) {
        free(list);
        return NULL;
    }

    return list;
}

/**
 * Frees memory for the specified elist.
 */
void elist_destroy(struct elist *list)
{
    free(list->element_storage);
    free(list);
}

/**
 * Sets the capacity for an elist. This can grow or shrink the amount of memory
 * set aside for element storage.
 *
 * @return -1 on failure, 0 on success
 */
int elist_set_capacity(struct elist *list, size_t capacity)
{
    if (list->element_storage == NULL) {
        list->element_storage = malloc(capacity * list->item_sz);
        if (list->element_storage == NULL) {
            return -1;
        }
        list->capacity = capacity;
        list->size = 0;
    } else {
        void *list2 = malloc(capacity * list->item_sz);
        if (list2 == NULL) {
            return -1;
        }
        size_t min_capacity = capacity < list->capacity ? capacity : list->capacity;
        memcpy(list2, list->element_storage, min_capacity * list->item_sz);
        free(list->element_storage);
        list->element_storage = list2;
        list->capacity = capacity;
        list->size = list->size < capacity ? list->size : capacity;
    }
    return 0;
}

/**
 * Retrieves the elist capacity (amount of space set aside for elements in
 * memory).
 */
size_t elist_capacity(struct elist *list)
{
    return list->capacity;
}

/**
 * Adds an item to the end of the list.
 *
 * @return -1 on failure, 0 on success
 */
ssize_t elist_add(struct elist *list, void *item)
{
/**
    if (list->size == list->capacity) {
            struct elist *list2 = elist_create(list->capacity * RESIZE_MULTIPLIER + 1, list->item_sz);
            if (list2 == NULL) {
                return -1;
            }
            memcpy(list2->element_storage, list->element_storage, list->capacity * list->item_sz);
            free(list->element_storage);
            list->capacity = RESIZE_MULTIPLIER * list->capacity + 1;
            list->element_storage = list2->element_storage;
        }
*/
/* above will cause memory leak */
    if (list->size == list->capacity) {
        if (elist_set_capacity(list, list->capacity * RESIZE_MULTIPLIER + 1) == -1) {
            return -1;
        }
    }

    memcpy(list->element_storage + list->size * list->item_sz, item, list->item_sz);
    list->size++;
    return 0;
}

/**
 * Allocates memory for an item, adds it to the end of the list, and returns a
 * pointer to the newly-allocated memory.
 *
 * @return -1 on failure, 0 on success
 */

void *elist_add_new(struct elist *list)
{
    if (list->size == list->capacity) {
        elist_set_capacity(list, list->capacity * RESIZE_MULTIPLIER + 1);
    }

    void *newSpace = list->element_storage + list->size * list->item_sz;
    list->size++;
    return newSpace;
}

/**
 * Copies an item into the list at the specified index.
 *
 * @return -1 on failure, 0 on success
 */
int elist_set(struct elist *list, size_t idx, void *item)
{
    if(!idx_is_valid(list,idx)) {
        return -1;
    }
    memcpy(list->element_storage + idx * list->item_sz, item, list->item_sz);
    return 0;
}

/**
 * Retrieves a particular item from the list based on its index.
 *
 * @return NULL if the index does not exist or is invalid
 */
void *elist_get(struct elist *list, size_t idx)
{
    if(!idx_is_valid(list,idx)) {
        return NULL;
    }
    return list->element_storage + idx * list->item_sz;
}

size_t elist_size(struct elist *list)
{
    return list->size;
}

/**
 * Removes an item from the list.
 *
 * @return -1 on failure, 0 on success
 */
int elist_remove(struct elist *list, size_t idx)
{
    if(!idx_is_valid(list,idx)) return -1;
    memmove(list->element_storage + idx * list->item_sz,
            list->element_storage + (idx + 1) * list->item_sz,
            (list->capacity - idx - 1) * list->item_sz);
    list->size--;
    return 0;
}

/**
 * "Clears" the array by resetting its size to 0.
 */
void elist_clear(struct elist *list)
{
    list->size = 0;
}

/**
 * Clears the array AND zeroes out its memory.
 */
void elist_clear_mem(struct elist *list)
{
    list->size = 0;
    memset(list->element_storage, 0, list->capacity * list->item_sz);
}

/**
 * Sorts the list using the given comparator. This function does not actually
 * implement a sorting algorithm, but simply acts as interface to the qsort
 * function.
 */
void elist_sort(struct elist *list, int (*comparator)(const void *, const void *))
{
    qsort(list->element_storage,list->size,list->item_sz,comparator);
}

bool idx_is_valid(struct elist *list, size_t idx)
{
    if(idx < 0 || idx >= list->size) {
        return 0;
    } else {
        return 1;
    }
}