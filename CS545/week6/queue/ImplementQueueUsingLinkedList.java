package CS545.week6.queue;

public class ImplementQueueUsingLinkedList {
  private Node head;
  private Node tail;

  public ImplementQueueUsingLinkedList() {
    head = null;
    tail = null;
  }

  //with linked list approach, we are enqueue new elem end of linkedlist
  // and dequeue at the front of linkedlist

  public void enqueue(Object elem) {
    Node newNode = new Node(elem);
    if (head == null) {
      head = newNode;
      tail = head;
    } else {
      tail.next = newNode;
      tail = tail.next;
    }
  }

  //return dequeue item value which is object
  public Object dequeue() {
    if (head == null) {
      return null;
    }
    Object dequeuedItemValue = head.element();
    head = head.next;
    if (head == null) {
      tail = null;
    }
    return dequeuedItemValue;
  }

  public boolean isEmpty() {
    return head == tail;
  }
}
