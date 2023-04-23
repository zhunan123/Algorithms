package CS545.week9.Heaps;

public class MaxHeap3 {
    private int[] heap;
    private int maxSize;
    private int size;

    public MaxHeap3(int max) {
        maxSize = max;
        heap = new int[maxSize];
        size = 0; //in this case we are not setting heap[0] to max infinity, so everything need to be
        //different from min heap
    }

    public void print() {
        for (int i = 0; i < heap.length; i++) {
            System.out.println(heap[i] + " ");
        }
    }

    private int leftChild(int pos) {
        return pos * 2 + 1;
    }

    private int rightChild(int pos) {
        return pos * 2 + 2;
    }

    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    private boolean isLeaf(int pos) {
        if (pos >= size / 2 && pos <= size) {
            return true;
        }
        return false;
    }

    private int firstLeaf() {
        return size / 2;
    }

    private int lastNonLeaf() {
        return size / 2 - 1;
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
        while (parent(current) > 0) {
            if (heap[current] > heap[parent(current)]) {
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
        while (!isLeaf(pos)) {
            int greatest = leftChild(pos);
            if (rightChild(pos) <= size) {
                if (heap[rightChild(pos)] > heap[greatest]) {
                    greatest = rightChild(pos);
                }
            }
            if (heap[greatest] > heap[pos]) {
                swap(pos, greatest);
            } else {
                break;
            }
            pos = greatest;
        }
    }
}
