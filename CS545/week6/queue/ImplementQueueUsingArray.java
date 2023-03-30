package CS545.week6.queue;

public class ImplementQueueUsingArray {

  /**
   * we are actually just shifting pointers when dequeue. so when we try to add more queue elements
   * will cause out of bounds error, so we need to use circular array
   * */

  //queue using circular array, we say queue is full when there's 1 cell left.
  static final int defaultsize = 100;

  private  Object data[];
  private int head, tail;

  private int size;

  public ImplementQueueUsingArray() {
    data = new Object[defaultsize];
    head = 0;
    tail = 0;
    size = defaultsize;
  }

  public void enqueue(Object elem) {
    //check if queue is full, we define full when there's 1 cell left
    //tail is the empty cell after the last elem
    if ((tail + 1) % size == head) {
      System.out.println("The queue is full");
      return;
    }
    data[tail] = elem;
    tail = (tail + 1 ) % size;
  }

  public boolean isEmpty() {
    return head == tail;
  }

  public Object dequeue() {
    //check if the queue is empty, when tail is head
    if (tail == head) {
      return null;
    }
    Object deletedObj;
    deletedObj = data[head];
    head = (head + 1) % size;
    return deletedObj;
  }
}
