* Double Hashing
  * linear probing -> i = h(k), next empty table cell index value can check is ---> (h(k) + j) % size, j = 0, 1 ,2...
  * quadratic probing -> (h(k) + j^2) % size, j = 0, 1 ,2...
  * insert in double hashing -> (h(k) + d(k)) % size, j = 0, 1 ,2...
    * d(k) = q - (key % q), q need to be prime number normally we can pick 7
    * steps------> this is only insert for one key (if insert a different key need to start from j = 0)
      * first separately compute h(k) = key % size, and d(k) = 7 - key % 7
        * j = 0, i = (h(k) + 0 * d(k)) % size, if index i is not available, need to find next available index
        * j = 1, i = (h(k) + 1 * d(k)) % size, if index i is not available, need to find next available index
        * j = 2, i = (h(k) + 2 * d(k)) % size, then if index i only available again, repeat the above steps until find the opening spot
  * find in double hashing
    * hash(key) into origin index i, then apply (i + d(k)) % size to search for it
    * load factor is n / k = (number of occupied table cell / entire table size)
      * if the load factor is too high, so say original size is 13, then we want to double the size 13 * 2 = 26, but we need to take the smallest prime number greater than 26 which is 29
* 