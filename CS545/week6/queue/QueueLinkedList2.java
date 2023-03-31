package CS545.week6.queue;

public class QueueLinkedList2 {

  private Node head;
  private Node tail;

  QueueLinkedList2() {
    head = null;
    tail = null;
  }

  public void enqueue(Object elem) {
    if (head == null) {
      head = new Node(elem);
      tail = head;
    } else {
      tail.next = new Node(elem);
      tail = tail.next;
    }
  }

  public Object dequeue() {
    if (head == null) {
      return null;
    } else {
      Object dequeued = head.element;
      head = head.next;

      //handle only 1 element in queue, need to update tail
      if (head == null) {
        tail = null;
      }
      return dequeued;
    }
  }
}
