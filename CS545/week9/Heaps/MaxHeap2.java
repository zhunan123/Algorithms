package CS545.week9.Heaps;

public class MaxHeap2 {

  private int[] heap;
  private int maxSize;
  private int size;

  public MaxHeap2(int max) {
    maxSize = max;
    heap = new int[maxSize];
    size = 0;
  }

  public void print() {
    for (int i = 0; i < heap.length; i++) {
      System.out.println(heap[i] + " ");
    }
  }

  private int leftChild(int pos) {
    return 2 * (pos + 1);
  }

  private int rightChild(int pos) {
    return 2 * pos + 2;
  }

  private int parent(int pos) {
    return (pos - 1) / 2;
  }

  private void swap(int pos1, int pos2) {
    int temp;
    temp = heap[pos1];
    heap[pos1] = heap[pos2];
    heap[pos2] = temp;
  }

  private void insert(int elem) {
    size++;
    heap[size] = elem;

    int current = size;
    while (parent(current) >= 0) {
      if ((heap[current] > heap[parent(current)])) {
        swap(current, parent(current));
      } else {
        break;
      }

      current = parent(current);
    }
  }

  private int removeMax() {
    swap(0, size);
    size--;
    pushDown(0);

    return heap[size];
  }

  private void pushDown(int pos) {
    while(!isLeaf(pos)) {
      int greatest = leftChild(pos);
      if (heap[rightChild(pos)] > heap[greatest]) {
        greatest = rightChild(pos);
      }

      if (heap[pos] < heap[greatest]) {
        swap(pos, greatest);
      } else {
        break;
      }
      pos = greatest;
    }
  }

  private boolean isLeaf(int pos) {
    return (pos >= size / 2) && (pos <= size);
  }




  public static void main(String[] args) {
    MaxHeap2 heap = new MaxHeap2(10);
    heap.insert(14);
    heap.insert(16);
    heap.insert(5);
    heap.insert(4);
    heap.insert(1);

    heap.removeMax();

    heap.print();

  }
}
