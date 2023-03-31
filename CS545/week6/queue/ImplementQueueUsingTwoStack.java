package CS545.week6.queue;

import CS545.week8.GeneralTree.HW5.MyQueue;

public class ImplementQueueUsingTwoStack {

  ListStack stack1 = new ListStack();
  ListStack stack2 = new ListStack();

  public void enqueue(Object elem) {
    while (!stack1.empty()) {
      stack2.push(stack1.pop());
    }
    stack1.push(elem);

    while (!stack2.empty()) {
      stack1.push(stack2.pop());
    }
  }

  public boolean isEmpty() {
    return stack1.empty();
  }

  public Object dequeue() {
    if (stack1.empty()) {
      System.out.println("there is nothing to dequeue");
      return null;
    } else {
      Object dequeued = stack1.pop();
      return dequeued;
    }
  }

  public static void main(String[] args) {
    MyQueue queue = new MyQueue();
    System.out.println("queue empty?: " + queue.empty()); //true
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    System.out.println("queue empty?: " + queue.empty()); // false
    queue.enqueue(4);
    queue.enqueue(5);
    System.out.println("dequeueing: " + queue.dequeue()); // 1
    System.out.println("dequeueing: " + queue.dequeue()); //2
    queue.enqueue(6);
    queue.enqueue(7);
    System.out.println("dequeueing: " + queue.dequeue()); //3
    System.out.println("dequeueing: " + queue.dequeue()); //4
    System.out.println("dequeueing: " + queue.dequeue()); //5
    System.out.println("dequeueing: " + queue.dequeue()); //6
    System.out.println("dequeueing: " + queue.dequeue()); //7
    System.out.println("queue empty?: " + queue.empty()); // true
    System.out.println("dequeueing: " + queue.dequeue()); // nothing to print
  }
}
