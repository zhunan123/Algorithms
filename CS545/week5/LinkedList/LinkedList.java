package CS545.week5.LinkedList;

import CS545.codeExamples.src.main.java.linkedLists.ListIterator;
import CS545.codeExamples.src.main.java.linkedLists.Node;

/** A class representing a linked list. */
public class LinkedList {
  private CS545.codeExamples.src.main.java.linkedLists.Node head, tail;

  public LinkedList() {
    head = null;
    tail = null;
  }

  /** Inserts a new node to the front of the list */
  public void insertAtFront(int elem) {
    CS545.codeExamples.src.main.java.linkedLists.Node newNode = new CS545.codeExamples.src.main.java.linkedLists.Node(elem);
    if (head == null) {
      head = newNode;
      tail  = newNode;
    }
    else {
      newNode.setNext(head);
      head = newNode;
    }

    // A shorter version:
		/*if (head != null) {
			newNode.setNext(head);
		} else {
			tail = newNode;
		}
		head = newNode; */
  }

  /**
   * Creates a new node with the given element and adds it to the back of the
   * list
   */
  public void append(int elem) {
    CS545.codeExamples.src.main.java.linkedLists.Node newNode = new CS545.codeExamples.src.main.java.linkedLists.Node(elem);
    if (tail != null) {
      tail.setNext(newNode);
      tail = newNode;
    } else {
      head = tail = newNode;
    }

  }

  /** Prints all the nodes in the link list */
  public void printNodes() {
    CS545.codeExamples.src.main.java.linkedLists.Node current = head;
    while (current != null) {
      System.out.print(current.elem() + " ");
      current = current.next();
    }
    System.out.println();

  }

  /** Return true if the given element is in the list */
  public boolean find(int elem) {
    CS545.codeExamples.src.main.java.linkedLists.Node current = head;
    while (current != null) {
      if (current.elem() == elem)
        return true;
      current = current.next();
    }
    return false;
  }


  /**
   * Insert a given element at index i in the linked list
   * @param index index where to insert
   * @param elem element to insert
   */
  public void insert(int index, int elem) {
    CS545.codeExamples.src.main.java.linkedLists.Node newNode = new CS545.codeExamples.src.main.java.linkedLists.Node(elem);
    if (head == null) {
      head = newNode;
      tail = newNode;
    }
    else if (index == 0) {
      newNode.setNext(head);
      head =  newNode;
    }
    else {
      CS545.codeExamples.src.main.java.linkedLists.Node prev = head;
      int count = 0;
      while (prev != null && count < index - 1) {
        prev = prev.next();
        count++;
      }
      System.out.println("prev = " + prev.elem());

      if (prev != null) {
        //System.out.println(curr.elem());
        newNode.setNext(prev.next());
        prev.setNext(newNode);
      }
    }

  }

  /**
   * Remove the node after "previousNode". Return the value of the element at
   * the deleted node
   */
  public int remove(CS545.codeExamples.src.main.java.linkedLists.Node previousNode) {
    if ((previousNode == null) || (previousNode.next() == null)) {
      System.out.println("Nothing to remove");
      return Integer.MAX_VALUE;
    }
    int elem = previousNode.next().elem();

    // if removing the tail
    if (previousNode.next() == tail) {
      tail = previousNode;
      tail.setNext(null);

    } else {
      // delete node
      previousNode.setNext(previousNode.next().next());
    }

    return elem;
  }

  public CS545.codeExamples.src.main.java.linkedLists.Node tail() {
    return tail;
  }

  public int middleElement() {
    CS545.codeExamples.src.main.java.linkedLists.Node slow = head;
    CS545.codeExamples.src.main.java.linkedLists.Node fast = head;

    while (fast != tail && fast.next()!= tail) {
      slow = slow.next();
      fast = fast.next().next();
      //System.out.println("slow = " + slow.elem());
      //System.out.println("fast = " + fast.elem());
    }
    if (slow != null)
      return slow.elem();
    else
      throw new IllegalArgumentException();
  }

  public ListIterator listIterator() {
    return new CS545.week5.LinkedList.LinkedList.MyListIterator();
  }

  public class MyListIterator implements ListIterator {
    Node current = null;

    MyListIterator() {
      current = head;
    }

    public boolean hasNext() {
      return current != null;
    }

    public int next() {
      int elem = current.elem();
      current = current.next();
      return elem;
    }
  }

  public static void main(String[] args) {
    CS545.codeExamples.src.main.java.linkedLists.LinkedList list = new CS545.codeExamples.src.main.java.linkedLists.LinkedList();
    list.insertAtFront(0);
    list.insertAtFront(9);
    list.insertAtFront(2);
    list.insertAtFront(3);
    list.insertAtFront(7);
    list.insertAtFront(1);
    list.insertAtFront(5);
    list.printNodes();

    // Example of using an iterator to iterate over elements of the linked list
		/*ListIterator it = list.listIterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		} */
  }
}