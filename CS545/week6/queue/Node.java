package CS545.week6.queue;

public class Node {
  public Object element;
  public Node next;
  public boolean isWord;
  public String prefix;
  public Node[] children;

  public Node(Object newelement) {
    element = newelement;
    next = null;
  }

  public Node(Object newelement, Node newnext) {
    element = newelement;
    next = newnext;
  }

  public Node next() {
    return next;
  }

  public Object element() {
    return element;
  }

}
