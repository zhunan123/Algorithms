package CS545.week6.queue;

public class buildQueueUsingArray1 {
    static final int defaultsize = 100;

    private  Object data[];
    private int head, tail;

    private int size;

    public buildQueueUsingArray1() {
        data = new Object[defaultsize];
        head = 0;
        tail = 0;
        size = defaultsize;
    }

    public void enqueue(Object elem) {
        //check if queue is full, we define full when there's 1 cell left
        //tail is the empty cell after the last elem
      if ((tail + 1) % size == head) {
          System.out.println("queue is full");
          return;
      }

      data[tail] = elem;
      tail = (tail + 1 ) % size;
    }

    public Object dequeue(Object elem) {
        //check if the queue is empty, when tail is head
      if (tail == head) {
          return null;
      }

      Object deletedObj = data[head];
      head = (head + 1) % size;
      return deletedObj;
    }
}
