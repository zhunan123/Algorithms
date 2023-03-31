package CS545.week6.queue;

public class QueueArray2 {

  static final int defaultsize = 100;

  private  Object data[];
  private int head, tail;

  private int size;

  public QueueArray2() {
    data = new Object[defaultsize];
    head = 0;
    tail = 0;
    size = defaultsize;
  }

  public void enqueue(Object item) {
    if ((tail + 1) % size == head) {
      System.out.println("queue is full");
      return;
    }

    data[tail] = item;
    tail = (tail + 1) % size;
  }

  public Object dequeue() {
    if (tail == head) {
      System.out.println("q is empty");
      return null;
    }

    Object dequeued = data[head];
    head = (head + 1) % size;
    return dequeued;
  }

}
