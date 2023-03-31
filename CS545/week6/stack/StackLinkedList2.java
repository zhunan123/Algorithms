package CS545.week6.stack;

public class StackLinkedList2 {

  private class Node {
    private Object data;
    private Node next;

    public Node(Object newElem) {
      data = newElem;
      next = null;
    }

    public Node(Object newElem, Node newNext) {
      data = newElem;
      next = newNext;
    }

    public Node next() {
      return next;
    }

    public Object elem() {
      return data;
    }
  }


  private Node top;

  public StackLinkedList2() {
    top = null;
  }

  public void push(Object elem) {
    Node newNode = new Node(elem);
    newNode.next = top;
    top = newNode;
  }

  public Object pop() {
    Object deleted;
    if (top == null) {
      return null;
    }

    deleted = top.data;
    top = top.next;
    return deleted;
  }
}
