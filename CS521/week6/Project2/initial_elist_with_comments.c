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
    //创建一个新的elist结构体，并为结构题里面的element_storage指针指向一个新开辟的内存作为数组
    /* initialize elist struct */
    struct elist *list = malloc(sizeof(struct elist));
    if (list == NULL) { //如果没有申请到内存
        return NULL;
    }

    if (list_sz == 0) { //如果申请的数组长度为0，则设置成默认长度
        list_sz = DEFAULT_INIT_SZ;
    }

    list->capacity = list_sz; //给结构题赋值数组相关属性
    list->size = 0; //????
    list->item_sz = item_sz;
    list->element_storage = malloc(list_sz * item_sz); //开辟内存
    if (list->element_storage == NULL) { //如果开辟失败
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
    //给数组重新开辟内存空间，并把原来的数据拷贝过去
    if (list->element_storage == NULL) {
        //如果原来就不存在数组内存，就直接开辟
        list->element_storage = malloc(capacity * list->item_sz);
        if (list->element_storage == NULL) {
            return -1;
        }
        list->capacity = capacity;
        list->size = 0;  //????
    } else {
        void *list2 = malloc(capacity * list->item_sz);//开辟新的内存空间
        if (list2 == NULL) {
            return -1;
        }
        //比较之前的内存大小，和现在要新开辟的内存大小，取最小值，这部分的是需要拷贝的
        size_t min_capacity = capacity < list->capacity ? capacity : list->capacity;
        memcpy(list2, list->element_storage, min_capacity * list->item_sz);
        free(list->element_storage);//释放之前的内存空间
        list->element_storage = list2;//赋值新的内存空间
        list->capacity = capacity; //重新赋值属性
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
    //返回elist最多能容纳多少个元素
    return list->capacity;
}

/**
 * Adds an item to the end of the list.
 *
 * @return -1 on failure, 0 on success
 */
ssize_t elist_add(struct elist *list, void *item)
{
    if (list->size == list->capacity) {
        //当数组元素已经满的时候，需要开辟原来2倍的空间
        //list->capacity * RESIZE_MULTIPLIER + 1：
        // 加1是因为可能capacity为被调整成了0，乘以RESIZE_MULTIPLIER之后还是0，做不到扩展容量
        struct elist *list2 = elist_create(list->capacity * RESIZE_MULTIPLIER + 1, list->item_sz);
        if (list2 == NULL) {
            return -1;
        }
        //拷贝数据到新开辟的内存
        memcpy(list2->element_storage, list->element_storage, list->capacity * list->item_sz);
        free(list->element_storage);//释放原来的内存
        list->capacity = RESIZE_MULTIPLIER * list->capacity + 1; //赋值新属性
        list->element_storage = list2->element_storage;
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
    if(!idx_is_valid(list,idx)) return NULL;
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
            (list->capacity - idx -1) * list->item_sz);
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
void elist_clear_mem(struct elist *list)ß
{
    list->size = 0;
    memset(list->element_storage,0,list->capacity * list->item_sz);
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
    if(idx < 0 || idx >= list->size) return 0;
    else return 1;
}
