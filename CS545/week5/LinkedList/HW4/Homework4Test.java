package CS545.week5.LinkedList.HW4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class Homework4Test {

  @Test
  public void testSublist() {
    LinkedList list = new LinkedList();
    list.append(40);
    list.append(15);
    list.append(34);
    list.append(5);
    list.append(30);
    list.append(31);
    list.append(1);
    list.append(18);

    LinkedList res = list.sublist(10, 30);

    // This is what we expect to get after calling sublist(10, 30):
    ArrayList<Integer> expected  = new ArrayList<>();
    expected.add(15);
    expected.add(30);
    expected.add(18);

    compareLinkedLists(res, expected);

  }

  @Test
  public void testInsertInSortedOrderInsertBeforeHead() {
    LinkedList list = new LinkedList();
    list.append(4);
    list.append(10);
    list.append(12);
    list.append(34);
    list.append(55);
    list.insertInSortedList(0);
    //System.out.println("After insertion:");
    //list.printNodes();
    //System.out.println();

    // This is what we expect to get after calling insert(0):
    ArrayList<Integer> expected  = new ArrayList<>();
    expected.add(0);
    expected.add(4);
    expected.add(10);
    expected.add(12);
    expected.add(34);
    expected.add(55);
    compareLinkedLists(list, expected);

  }

  @Test
  public void testInsertInSortedOrderInsertMiddle() {
    LinkedList list = new LinkedList();
    list.append(4);
    list.append(10);
    list.append(12);
    list.append(34);
    list.append(55);
    list.insertInSortedList(11);
    list.printNodes();

    // This is what we expect to get after calling insert(0):
    ArrayList<Integer> expected  = new ArrayList<>();
    expected.add(4);
    expected.add(10);
    expected.add(11);
    expected.add(12);
    expected.add(34);
    expected.add(55);
    compareLinkedLists(list, expected);
  }

  @Test
  public void testInsertInSortedOrderInsertEnd() {
    LinkedList list = new LinkedList();
    list.append(4);
    list.append(10);
    list.append(12);
    list.append(34);
    list.append(55);
    list.insertInSortedList(60);

    // This is what we expect to get after calling insert(0):
    ArrayList<Integer> expected  = new ArrayList<>();
    expected.add(4);
    expected.add(10);
    expected.add(12);
    expected.add(34);
    expected.add(55);
    expected.add(60);

    compareLinkedLists(list, expected);
  }


  @Test
  public void getKLargest() {
    LinkedList list = new LinkedList();
    list.append(4);
    list.append(10);
    list.append(12);
    list.append(34);
    list.append(55);
    LinkedList res = list.getKLargest(3);

    // This is what we expect to get after calling insert(0):
    ArrayList<Integer> expected  = new ArrayList<>();
    expected.add(12);
    expected.add(34);
    expected.add(55);

    compareLinkedLists(res, expected);
  }

  @Test
  public void mergeSortedLists() {
    LinkedList list1 = new LinkedList();
    list1.append(4);
    list1.append(10);
    list1.append(12);
    list1.append(34);
    list1.append(55);

    LinkedList list2 = new LinkedList();
    list2.append(1);
    list2.append(11);
    list2.append(22);

    LinkedList res = LinkedList.mergeSortedLists(list1, list2);

    // This is what we expect to get after calling insert(0):
    ArrayList<Integer> expected  = new ArrayList<>();
    expected.add(1);
    expected.add(4);
    expected.add(10);
    expected.add(11);
    expected.add(12);
    expected.add(22);
    expected.add(34);
    expected.add(55);

    compareLinkedLists(res, expected);
  }


  /** Helper function for comparing the resulting and expected lists
   *
   * @param res linked list
   * @param expected expected values given in an ArrayList
   */
  public void compareLinkedLists(LinkedList res, ArrayList<Integer> expected) {

  }
}
