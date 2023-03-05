package CS545.week5.LinkedList;

/* A class representing a node in a singly linked list */
public class Node {
  private int elem;
  private Node next;

  public Node(int elem) {
    this.elem = elem;
    next = null;
  }

  public Node(int elem, Node next) {
    this.elem = elem;
    this.next  = next;
  }

  /** Getter for the next
   *
   * @return a reference to the next node
   */
  public Node next() {
    return next;
  }

  /**
   * Setter for the next
   * @param other reference to the next node
   */
  public void setNext(Node other) {
    next = other;
  }

  /** Getter for the elem
   *
   * @return elem
   */
  public int elem() {
    return elem;
  }

  /**
   * Setter for the elem
   * @param elem new value of the element
   */
  public void setElem(int elem) {
    this.elem = elem;
  }

}
