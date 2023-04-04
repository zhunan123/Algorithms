package CS545.week9.Heaps;

public class MinHeap {

    private int[] heap;
    private int maxSize;
    private int size; // current number of element in the array

    public MinHeap(int max) {
        maxSize = max;
        heap = new int[maxSize];
        size = 0;
        heap[0] = Integer.MIN_VALUE;
    }

    private int leftChild(int pos) {
        return 2 * pos;
    }

    private int rightChild(int pos) {
        return 2 * pos + 1;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int firstLeaf() {
        return size / 2 + 1;
    }

    private int lastNonLeaf() {
        return size / 2;
    }

    private boolean isLeaf(int pos) {
        return (pos > size / 2) && (pos <= size);
    }

    private void swap(int pos1, int pos2) {
        int temp;
        temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }

    public void pushDown(int pos) {
        while (!isLeaf(pos)) {
            //first, set smallest child index to the left child index, then compare with right child, if left child is smaller than the right child, left child is the smallest child
            //smallest is the index not the value;
            int smallest = leftChild(pos);
            if (rightChild(pos) <= size) { // need to check if right child pos is exceed the current size of heap, check if right child exist
                //but I want to know what condition will rightChild(pos) > size?
                if (heap[smallest] > heap[rightChild(pos)]) {
                    smallest = heap[rightChild(pos)];
                }
            }

            if (heap[smallest]  < heap[pos]) {
                swap(pos, smallest);
            } else {
                //need to set stopping condition to break the while loop if heap[smallest]  > heap[pos],
                // otherwise the loop while continue until find not leaf pos. and will be wrong;

                break;
            }

            pos = smallest;
        }
    }

    /**
     * step to remove min (push down/bubble down)
     * 1.swap the smallest with the heap's size (the last elem in the heap array, and is size since we start at 1, heap[0] is negative infinity)
     * 2.remove the min element
     * 3.now you are in top initial position, find the smallest child. if the smallest child is smaller then root parent elem,
     *      swap this root with smallest child, then keep pushing down(bubble down) current level to child level.
     * 4.when the smallest child is greater then the root val, then we stop, and done with remove min.
     * */
    public int removeMin() {
        swap(1, size);
        size--;

        if (size != 0) {
            pushDown(1);
        }

        return heap[size + 1];
    }

    /**
     * steps to insert elem into min heap (pushing up/bubble down)
     * 1.first increment heap array size
     * 2.make current to heap's size (add insert value after last elem in heap array)
     * 3.compare with the parent node in while loop, if smaller than the parent node, swap with parent
     * 4.while loop will stop when current is greater then parent.
     * 5.finally heap insertion is done
     * */
    public void insert(int elem) {
        size++;
        heap[size] = elem;

        int current = size;
        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print() {
        for (int i = 0; i < heap.length; i++) {
            System.out.print(heap[i] + " ");
        }
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(20);
        heap.insert(14);
        heap.insert(16);
        heap.insert(5);
        heap.insert(4);
        heap.insert(0);

        heap.print();

        heap.removeMin();//0, 4, 14, 16, 5
        heap.print(); //4, 5, 14, 16
    }
}
