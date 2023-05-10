package CS545.week5.LinkedList;

import java.util.LinkedList;

public class LinkedListExercise {
  private Node head, tail;

  public LinkedListExercise() {
    head = null;
    tail = null;
  }

  /** Inserts a new node to the front of the list
   *
   * @param elem value to insert in the linked list
   */
  public void insertAtFront(int elem) {
    Node newNode = new Node(elem);
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.setNext(head);
      head = newNode;
    }
  }

  public void insertAtFront2(int elem) {
    Node newNode = new Node(elem);
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.setNext(head);
      head = newNode;
    }
  }

  /** Creates a new node with the given element and adds it to the back of the list
   *
   * @param elem new value to append to the linked list
   */
  public void append(int elem) {
    Node newNode = new Node(elem);
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.setNext(null);
      tail.setNext(newNode);
      tail = newNode;
    }
  }

  public void append2(int elem) {
    Node newNode = new Node(elem);
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.setNext(null);
      tail.setNext(newNode);
      tail = newNode;
    }
  }

  /** Prints all the nodes in the link list */
  public void printNodes() {
    Node current = head;
    while (current != null) {
      System.out.println(current.elem());
      current = current.next();
    }
  }

  public void printNode2() {
    if (head == null) {
      return;
    }

    Node current = head;
    while (current != null) {
      System.out.print(current.elem() + " ");
      current = current.next();
    }
  }

  /** Return true if the given element is in the list
   *
   * @param elem value to find
   * @return true if found the node with this value, false otherwise
   */
  public boolean find(int elem) {
    Node current = head;
    while (current != null) {
      if (current.elem() == elem) {
        return true;
      }
      current = current.next();
    }
    return false;
  }

  public boolean find2(int elem) {
    Node current = head;
    while (current != null) {
      if (current.elem() == elem) {
        return true;
      }
      current = current.next();
    }
    return false;
  }

  /**
   * Insert a given element at index i in the linked list
   * @param index index where to insert
   * @param elem element to insert
   */
  public void insert(int index, int elem) { //insert at particular index
    Node newNode = new Node(elem);
    if (head == null) { // the linked list was previously empty, the new node becomes the head and the tail
      head = newNode;
      tail = newNode;
    } else if (index == 0) { // inserting in front
      newNode.setNext(head);
      head =  newNode;
    } else { // General case: need to move prev to index - 1
      // then insert the new node after it
      Node prev = head;
      int count = 0;
      while (prev != null && (count < index - 1)) {
        prev = prev.next();
        count++;
      }
      if (prev == null) {
        throw new IllegalArgumentException();
      } else {
        newNode.setNext(prev.next());
        prev.setNext(newNode);

        if (prev == tail) {
          newNode.setNext(null);
          prev.setNext(newNode);
          tail = newNode;
        }
      }
    }
  }

  public void insertAtIndex(int index, int elem){
    Node newNode = new Node(elem);
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else if (index == 0) {
      newNode.setNext(head);
      head = newNode;
    } else {
      Node prev = head;
      int count = 0;
      while (prev != null && count < index - 1) { // find insert position which
        prev = prev.next();
        count++;
      }
      if (prev != null) {
        if (prev == tail) {
          newNode.setNext(null);
          prev.setNext(newNode);
          tail = newNode;
        } else {
          newNode.setNext(prev.next());
          prev.setNext(newNode);
        }
      }
    }
  }

  /**
   * Remove the node after "previousNode". Return the value of the element at
   * the deleted node
   */
  public int remove(Node previousNode) { //remove the element after the previous node
    if ((previousNode == null) || (previousNode.next() == null)) {
      System.out.println("Nothing to remove");
      return Integer.MAX_VALUE;
    }
    int elem = previousNode.next().elem();

    // if removing the tail
    if (previousNode.next() == tail) {
      previousNode.setNext(null);
      tail = previousNode;
    } else { // General case: delete node
      previousNode.setNext(previousNode.next().next());
    }
    return elem;
  }

  public int remove2(Node previousNode) {
    if (previousNode == null || previousNode.next() == null) {
      return 0;
    }

    int removed = previousNode.next().elem();
    if (previousNode.next() == tail) {
      previousNode.setNext(null);
      tail = previousNode;
    } else {
      previousNode.setNext(previousNode.next().next());
    }
    return removed;
  }

  public Node tail() {
    return tail;
  }

  /** Returns the value of the middle node
   *
   * @return value stored in the middle node
   */
  public int middleElement() {
    Node slow = head;
    Node fast = head;

    if (head == null) {
      throw new IllegalArgumentException();
    }

    while (fast != tail && fast.next() != tail) {
      /* while (fast.next() != null && fast.next().next() != null)*/
      fast = fast.next().next();
      slow = slow.next();
    }

    return slow.elem();
  }

  public static void main(String[] args) {
    LinkedListExercise list = new LinkedListExercise();
    list.insertAtFront(0);
    list.insertAtFront(9);
    list.insertAtFront(2);
    list.insertAtFront(3);
    list.insertAtFront(7);
    list.insertAtFront(1);
    list.insertAtFront(5);
    list.printNodes();
    list.insert(4, 6);
    list.printNodes();

//    LinkedListExercise list1 = new LinkedListExercise();
//		list1.append(35);
//		list1.append(40);
//		list1.append(10);
//		list1.printNodes();
//    System.out.println("middle: " + list1.middleElement());
//    Node head = list1.head;
//    list1.remove(head);
//    System.out.println("after removing the element after head");
//    list1.printNodes();


		/*list.insert(0, 4);
		list.printNodes();
		list.insert(1, 5);
		list.printNodes();
		list.insert(3, 88);
		list.printNodes();
		list.insert(5, 100);
		list.printNodes(); */
  }
}
