package CS545.week9.Heaps;

public class MinHeap3 {

    private int[] heap;
    private int maxSize;
    private int size;

    public MinHeap3(int max) {
        maxSize = max;
        heap = new int[maxSize];
        // we assume the size with is just size of heap without negtive infinity
        size = 0; // we didn't count heap[0] = Integer.MIN_VALUE  heap.length
        heap[0] = Integer.MIN_VALUE;
    }

    public void print() {
       for (int i = 0; i < heap.length; i++) {
           System.out.print(heap[i] + " ");
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
       if (pos < size / 2 && pos <= size) {
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
        swap(1,size);
        size--;
        pushDown(1);
        return heap[size];
    }

    public void pushDown(int pos) {
        while (!isLeaf(pos)) {
            int smallest = leftChild(pos);
            if (rightChild(pos) <= size) {
                if (heap[rightChild(pos)] < heap[smallest]) {
                    smallest = rightChild(pos);
                }
            }
            if (heap[pos] > heap[smallest]) {
                swap(pos, smallest);
            } else {
                break;
            }

            pos = smallest;
        }

    }

    public void buildMinHeapFromBottomUp(int[] heap) {
        for (int i = size / 2; i > 0; i--) {
            pushDown2(i);
        }
    }

    public void pushDown2(int pos) {
        while (!isLeaf(pos)) {
            int smallest = leftChild(pos);
            if (rightChild(pos) <= size) {
                if (heap[rightChild(pos)] < heap[smallest]) {
                    smallest = rightChild(pos);
                }
            }
            if (heap[pos] > heap[smallest]) {
                swap(pos, smallest);
            } else {
                break;
            }
            pos = smallest;
        }
    }
}
