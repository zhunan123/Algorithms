package CS545.week6.queue;

public class buildQueueUsingLinkedList1 {

    private Node head;
    private Node tail;

    buildQueueUsingLinkedList1() {
        head = null;
        tail = null;
    }

    //with linked list approach, we are enqueue new elem end of linkedlist
    // and dequeue at the front of linkedlist

    public void enqueue(Object elem) {
        if (head == null) {
            head  = new Node(elem);
            tail = head;
            //如果不想用下面的else，上面的if statement必须要return东西
        } else {
            tail.next = new Node(elem);
            tail = tail.next;
        }
    }

    //return dequeue item value which is object
    public Object dequeue() {
        if (head == null) {
            return null;
        }
        Object deletedNode = head.element;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return deletedNode;
    }
}
