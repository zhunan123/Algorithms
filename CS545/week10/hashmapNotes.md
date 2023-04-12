* what is a hash table?
  * have array that elements is unsorted and stored non-contiguous
  * have a hash function takes a key and map it to index of array where element is stored
    * if hash(key) == i, we say this key hashes to the array index value i
    * hash(key) == i, i is computed by (array index value i = key % size)
    * map keys to index in array
    * disperse key in a random way
  * handle collision, when 2 keys hashes to same key value 
  * hash table size is always prime to make LinkedList not too long

* Method 1 chaining open hashing (LinkedList)
  * handle collision using linkedlist
  * insert in linkedlist head when collision happens (before insert in linkedlist head, we need to check if value already existed in linkedlist)
  * every time when we insert we need to do 
  * when insert need to (hash to key to find array index value)have the ((array index value) i = key % size)key mod by size of hash table/array in order to put key into correct hash table index
  * when want to find, we need hash the key to find array index value, then need to loop through the linkedlist
  * load factor = n(#elem in hash table) / k(#bins) is greater than certain threhold, then we need
    * to increase the HashTable capacity to maintain the search and insert operation complexity of O(1).

* Method 2 closed hashing
  * the collision elements need to be placed in other place 
  * if collision, means two keys have same value, the second key need to be placed into next available table cell.will keep going right to find available table cell.
    * linear probing - if collision happens, insert key will goes right and find next available open table cell.
      * find method in linear probing, will start at original index, then go right until find the key.
        * stopping point #1, find will go until next empty table cell, if not found the key, means the key not in hash table, becuase if key in this hash table, so it will appear in this empty table cell.
        * stopping point #2, will behave like circular fashion, after iterate to end, will start at beginning, then will stop at origin position.
  * when delete, will need to add a isDeleted boolean flag, to indicate the empty table cell has a deleted key. than it will affact the find method
    * when are we are finding the key. even if the table cell is available but isDeleted boolean flag is True, means we need to keep search right.
    * when insert, if boolean is true, means it is a empty table cell and we can insert and set boolean to false after insertion.
  * circular Linear probing, when reach end will start at begining
    * when collistion happens, every time insert index value position i = (i(origin index) + j) % size   j = 0, 1, 2 ......
      * means when collision happens, the key with same index will look for open table cell in right one cell by once cell in a linear fashion
  * circular quadratic probing ---->circular probing means when we iterate after end will start from beginning
  * when collision happens, every time insert index value position i = (i + j^2 ) % size   j = 0, 1, 2 ......
    * means when collision happens, the key with same index will look for open table cell in right in a quadratic fashion
      * first check index i + 0 ^2, if (i + 0 ^2) % size occupied,  then check i + 1 ^ 2, then if (i + 1 ^2) % occupied, check i + 2 ^ 2, if (i + 2 ^2) %occupied, check i + 3 ^ 2.....