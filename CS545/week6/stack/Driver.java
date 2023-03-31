package CS545.week6.stack;

public class Driver {

  public static void main(String[] args) {
    //array
    StackArray2 stack = new StackArray2();
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.push(6);

    System.out.println("popped element is : " + stack.pop());
    System.out.println("popped element is : " + stack.pop());
    System.out.println("popped element is : " + stack.pop());
    System.out.println("popped element is : " + stack.pop());
    System.out.println("popped element is : " + stack.pop());

    System.out.println("below is linked list");

    //linkedlist
    StackLinkedList2 stack1 = new StackLinkedList2();
    stack1.push(3);
    stack1.push(4);
    stack1.push(5);
    stack1.push(6);

    System.out.println("popped element is : " + stack1.pop());
    System.out.println("popped element is : " + stack1.pop());
    System.out.println("popped element is : " + stack1.pop());
    System.out.println("popped element is : " + stack1.pop());
    System.out.println("popped element is : " + stack1.pop());




//    stack.growStack();
    stack.isEmpty();
  }
}
