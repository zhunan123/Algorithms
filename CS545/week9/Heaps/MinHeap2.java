package CS545.week9.Heaps;

public class MinHeap2 {

  private int[] heap;
  private int maxSize;
  private int size;

  public MinHeap2(int max) {
    maxSize = max;
    heap = new int[maxSize];
    size = 0;
    heap[0] = Integer.MIN_VALUE;
  }

  public void print() {
    for (int i = 0; i < heap.length; i++) {
      System.out.println(heap[i] + " ");
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
    if (pos > size / 2 && pos < size) {
      return true;
    }
    return false;
  }

  public void swap(int pos1, int pos2) {
    int temp = heap[pos1];
    heap[pos1] = heap[pos2];
    heap[pos2] = temp;
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

//    while (!isLeaf(pos)) {
//      int smallest = leftChild(pos);
//      if (rightChild(pos) <= size) {
//        if (heap[rightChild(pos)] < heap[smallest]) {
//          smallest = rightChild(pos);
//        }
//      }
//
//
//      if (heap[smallest] < heap[pos]) {
//        swap(pos, smallest);
//      } else {
//        break;
//      }
//      pos = smallest;
//    }
  }

  public static void main(String[] args) {
    MinHeap2 heap = new MinHeap2(10);
    heap.insert(14);
    heap.insert(16);
    heap.insert(5);
    heap.insert(4);
    heap.insert(1);

    heap.removeMin();

    heap.print();

  }
}
