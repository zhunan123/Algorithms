package ShoulderU.HashMap;

public class DesignHashMapOpenHashingLinkedList {

  /**
   * Design a HashMap without using any built-in hash table libraries.
   *
   * Implement the MyHashMap class:
   *
   * MyHashMap() initializes the object with an empty map.
   * void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
   * int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
   * void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
   *
   *
   * Example 1:
   *
   * Input
   * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
   * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
   * Output
   * [null, null, null, 1, -1, null, 1, null, -1]
   *
   * Explanation
   * MyHashMap myHashMap = new MyHashMap();
   * myHashMap.put(1, 1); // The map is now [[1,1]]
   * myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
   * myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
   * myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
   * myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
   * myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
   * myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
   * myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
   * */


  class MyHashMap {

    private int size = 100;
    private Node[] bucket = new Node[size];

    public class Node {
      int key;
      int val;
      Node next;
      Node (int key, int val) {
        this.key = key;
        this.val = val;
      }
    }

    public MyHashMap() {

    }

    public void put(int key, int value) {
      //insert into linkedlist head
      int index = hash(key);
      Node head = bucket[index];

      if (head == null) {
        bucket[index] = new Node(key, value);
        return;
      } else {
        //this below will insert at head
        // bucket[index] = new Node(key, value);
        // bucket[index].next = head;

        //in this case we insert at tail need to prev here since head will become null
        Node prev = head;
        while (head != null) {
          if (head.key == key) {
            head.val = value;
            return;
          }
          prev = head;
          head = head.next;
        }
        prev.next = new Node(key, value);
      }
    }

    public int get(int key) {
      int index = hash(key);
      Node head = bucket[index];
      while (head != null) {
        if (head.key == key) {
          return head.val;
        }
        head = head.next;
      }
      return -1;
    }

    public void remove(int key) {
      int index = hash(key);
      Node head = bucket[index];

      if (head == null) {
        return;
      }
      //如果head 就是要removed的key
      if (head.key == key) {
        bucket[index] =  head.next;
      } else { //removed key is not head
        while (head.next != null) {
          if (head.next.key == key) {
            head.next = head.next.next;
            return;
          }
          head = head.next;
        }
      }
    }

    public int hash(int key) {
      return key % size;
    }
  }
}
