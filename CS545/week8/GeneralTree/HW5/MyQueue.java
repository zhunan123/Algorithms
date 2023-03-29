package CS545.week8.GeneralTree.HW5;

public class MyQueue implements Queue{
  //stack1 是用来store basic q item的，是queue 的本体
  private Stack stack1 = new ListStack();
  //stack2是用来操作，reverse stack1的item的，是辅助性的
  private Stack stack2 = new ListStack();

  public void enqueue(Object item) {
    // FILL IN CODE (must be constant time)
    while (!stack1.empty()) {
      stack2.push(stack1.pop());
    }
    stack1.push(item);
    while (!stack2.empty()) {
      stack1.push(stack2.pop());
    }
  }

  public Object dequeue() {
    // FILL IN CODE: will be linear time
    if (stack1.empty()) {
      System.out.println("Nothing to dequeue");
      System.exit(0);
    }
    return stack1.pop();

  }

  public boolean empty() {
    // FILL IN CODE
    return stack1.empty();
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
