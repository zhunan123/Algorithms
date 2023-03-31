package CS545.week6.queue;

public class Driver {

  public static void main(String[] args) {
    // Create a ListQueue
		QueueLinkedList2 queue1  = new QueueLinkedList2();
		queue1.enqueue(15);
		System.out.println(queue1);
		System.out.println("Dequeue elem:" + queue1.dequeue());
		System.out.println("Dequeue elem:" + queue1.dequeue());

    // Create an ArrayQueue
//    QueueArray2 queue2 = new QueueArray2();
//    queue2.enqueue(5);
//    queue2.enqueue(1);
//    queue2.enqueue(2);
//    System.out.println("Dequeued: " + queue2.dequeue());
//    System.out.println("Dequeued: " + queue2.dequeue());
//    System.out.println("Dequeued: " + queue2.dequeue());
//    System.out.println("Dequeued: " + queue2.dequeue());

    // there should always be one empty spot; this is considered "full"

  }
}
