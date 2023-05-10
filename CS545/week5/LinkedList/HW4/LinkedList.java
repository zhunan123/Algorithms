package CS545.week5.LinkedList.HW4;

import java.util.Iterator;

/** A class representing a singly linked list from scratch.  Fill in code.
 *
 *  Note: you may NOT use any of Java's built in classes that store a collection of elements
 *  such as ArrayList, LinkedList (Java's built in), HashMap, HashTree, HashSet etc. */
public class LinkedList {
  private Node head, tail;

  /** Constructor */
  public LinkedList() {
    head = null;
    tail = null;
  }

  /**
   * Creates a new node with the given element and adds it to the back of the
   * list. No need to change this method.
   */
  public void append(int elem) {
    Node newNode = new Node(elem);
    if (tail != null) {
      tail.setNext(newNode);
      tail = newNode;
    } else {
      head = tail = newNode;
    }

  }

  /** Prints all the nodes in the link list. No need to change this method. */
  public void printNodes() {
    Node current = head;
    while (current != null) {
      System.out.print(current.elem() + " ");
      current = current.next();
    }
  }

  /**
   * Return a sublist of this list where the values of elements are in the range
   * from value1 to value2, inclusive.
   * Your method should not destroy the original list and its nodes should *not* reference
   * the nodes in the input list (you need to create new nodes instead).
   * Example:
   * If the list is 6->40->3->17->1 and value1 is 3 and value2 is 20,
   * then the result should be 6->3->17.
   * @param value1 value 1
   * @param value2 value 2
   * @return a sublist of this list where the values of elements are in the range
   * 	 * from value1 to value2, inclusive.
   */
  public LinkedList sublist(int value1, int value2) {
    LinkedList res = new LinkedList();

    Node current = head;
    while (current != null) {
      if (current.elem() >= value1 && current.elem() <= value2) {
        res.append(current.elem());
      }
      current = current.next();
    }
    return res;
  }

  /**
   * Insert a new node with the given element into the sorted linked list.
   * Insert it in the right place based on the value in the node. Assume the
   * list is sorted by the elem, from smallest to largest. The
   * list should remain sorted after this insert operation.
   * Example: If this list is 5->10->18 and we insert 15, then after that the operation,
   * the list will become 5->10->15->18.
   */
  public void insertInSortedList(int elem) {
    // insert a node into the sorted list
    // FILL IN CODE
    Node newNode = new Node(elem);

    if (head == null) {
      head = newNode;
      tail = newNode;
    } else if (elem < head.elem()) { // insert head
      newNode.setNext(head);
      head = newNode;
    } else {
      // find insert position
      Node prev = head;
      while (prev.next() != null) {
        if (prev.next().elem() < elem) {
          prev = prev.next();
        } else {
          break;
        }
      }
      // if pos == tail and else
      if (prev == tail) {
        tail.setNext(newNode);
        tail = newNode;
      } else {
        newNode.setNext(prev.next());
        prev.setNext(newNode);
      }
    }

  }

  /**
   * Assume this linked list is sorted in ascending order, and we do not know the
   * 	 * number of elements.
   * 	 * Return a LinkedList that contains k largest elements in the list.
   * 	 * Use slow & fast pointers to find the k-th node from the end (required). Note: This method
   * 	 * should be linear and should not count the number of nodes. Do NOT use reverse().
   * @param k index from the end
   * @return linked list that contains k largest elements (k elements from the end of the list)
   */
  public LinkedList getKLargest(int k) {
    LinkedList result = new LinkedList();
    Node pointer1 = head;
    Node pointer2 = head;
    int count = 0;
    while (count < k) {
      pointer1 = pointer1.next();
      count++;
    }
    while (pointer1 != null) {
      pointer1 = pointer1.next();
      pointer2 = pointer2.next();
    }

    while (pointer2 != null) {
      result.append(pointer2.elem());
      pointer2 = pointer2.next();
    }

    return result;
  }


  /**
   * Merge two sorted linked lists into a single sorted linked list.
   *
   * @param list1
   * @param list2
   * Your method should not destroy the original list and its nodes should *not* reference
   * the nodes in the input list (you need to create new nodes instead).
   */
  public static LinkedList mergeSortedLists(LinkedList list1, LinkedList list2) {
    LinkedList res = new LinkedList();
    Node curr1 = list1.head;
    Node curr2 = list2.head;



    return res;
  }

  /** Return an iterator that allows to traverse the list */
  public Iterator<Node> iterator() {
    return new ListIterator(0);
  }

  /**
   * The inner class that represents the iterator for the linked list.
   * Iterates over the nodes of the list. No need to modify.
   */
  private class ListIterator implements Iterator<Node> {
    Node curr = head;

    public ListIterator(int index) {
      int count = 0;
      while (curr != null && count < index) {
        curr = curr.next();
        count++;
      }
      // System.out.println(curr == head);

    }

    @Override
    public boolean hasNext() {
      return curr != null;
    }

    @Override
    public Node next() {
      Node currNode = curr;
      curr = curr.next();
      return currNode;
    }

  }

}
