package CS545.week9.Heaps;

public class MinHeap2 {

  private int[] heap;
  private int maxSize;
  private int size;

  public MinHeap2(int max) {
    maxSize = max;
    heap = new int[maxSize];
    size = 0; // we didn't count heap[0] = Integer.MIN_VALUE
    heap[0] = Integer.MIN_VALUE;
  }

  public void print() {
    for (int i = 0; i < heap.length; i++) {
      System.out.println(heap[i] + " ");
    }
  }

  public void print2(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  public int leftChild(int pos) {
    return 2 * pos;
  }

  public int rightChild(int pos) {
    return 2 * pos + 1;
  }

  public int parent(int pos) {
    return pos / 2;
  }

  private int firstLeaf() {
    return size / 2 + 1;
  }

  private int lastNonLeaf() {
    return size / 2;
  }

  private boolean isLeaf(int pos) {
    if (pos > size / 2 && pos <= size) {
      return true;
    }
    return false;
  }

  private boolean isLeaf2(int pos, int[] arr) {
    int size = arr.length - 1;
    if (pos > size / 2 && pos <= size) {
      return true;
    }
    return false;
  }

  public void swap(int pos1, int pos2) {
    int temp = heap[pos1];
    heap[pos1] = heap[pos2];
    heap[pos2] = temp;
  }

  public void swap2(int pos1, int pos2, int[] arr) {
    int temp = arr[pos1];
    arr[pos1] = arr[pos2];
    arr[pos2] = temp;
  }

  public void insert(int elem) {
    size++;
    heap[size] = elem;

    int current = size;
    while (heap[current] < heap[parent(current)]) {
      swap(current, parent(current));
      current = parent(current);
    }
  }

  public int removeMin() {
    swap(1, size);
    size--;
    pushDown(1);
    return heap[size];
  }

  public void pushDown(int pos) { //min heap is binary tree and only have left child and right child
    while (!isLeaf(pos)) { //while is here, push down until position hits leaf
      int smallest = leftChild(pos); //smallest is the index
      //check if has right child which means rightChild(pos) will not greater than size
      if (rightChild(pos) <= size) {
        if (heap[rightChild(pos)] < heap[smallest]) {
          smallest = rightChild(pos);
        }
      }
      if (heap[smallest] < heap[pos]) { //if pos value > smallest value, swap the position
        swap(pos, smallest);
      } else {
        break;
      }

      pos = smallest; // update pos position
    }
  }

  public void buildMinHeapFromBottomUp(int[] heap) {
    //idea is find the last non-leaf is n / 2, write a for loop from last non-leaf to position 1
    //since 0 is negative infinity, for each non-leaf nodes we only need to do push down
    //for each non-leaf node, do push down to make each mini heap into min heap
    //then when we loop back until to first non-leaf node, so the entire heap will be sorted into min heap
    //in this case, the min heap is done building from the bottom up.
    int size = heap.length - 1;
    for (int i = size / 2; i > 0; i--) {
      pushDown2(heap, i);
    }
  }

  public void pushDown2(int[] arr, int pos) {
    while (!isLeaf2(pos, arr)) {
      int smallest = leftChild(pos);
      if (rightChild(pos) <= arr.length - 1) {
        if (arr[rightChild(pos)] < arr[smallest]) {
          smallest = rightChild(pos);
        }
      }
      if (arr[smallest] < arr[pos]) {
        swap2(pos, smallest, arr);
      } else {
        break;
      }

      pos = smallest; // update pos position
    }
  }

  public static void main(String[] args) {
    MinHeap2 heap = new MinHeap2(10);
//    heap.insert(14);
//    heap.insert(16);
//    heap.insert(5);
//    heap.insert(4);
//    heap.insert(1);
//
//    heap.removeMin();

//    heap.print();
//    heap.insert(26);
//    heap.insert(9);
//    heap.insert(7);
//    heap.insert(2);
//    heap.insert(13);
//    heap.insert(50);
//    heap.insert(1);
//    heap.insert(3);
//    heap.insert(15);
//    heap.insert(8);
//    heap.insert(0);

//    int[] array = {2 ,5 ,8 ,10 ,11 ,1, 12, 9, 4, 0, 7};
        int[] array = {Integer.MIN_VALUE, 26, 9, 7, 2, 13, 50, 1, 3, 15, 8, 0};
    heap.buildMinHeapFromBottomUp(array);
    heap.print2(array);
  }
}
