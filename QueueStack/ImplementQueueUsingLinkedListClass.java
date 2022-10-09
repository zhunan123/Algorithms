package QueueStack;

import java.util.LinkedList;

public class ImplementQueueUsingLinkedListClass {

    LinkedList<Integer> ll = new LinkedList<>();
    public void push_front(int item) {
        ll.addFirst(item);
    }

    public void push_back(int item) {
        ll.addLast(item);
    }

    public int pop_front() {
        return ll.removeFirst();
    }

    public int pop_back() {
        return ll.removeLast();
    }
}
