package week2.classAndObjectEncapsulation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LibraryTestDriver {
  public static void main(String[] args) {
    Library lib = new Library();
    Book b1 = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, 4.34);
    Book b2 = new Book("The Hobbit or There and Back Again", "J.R.R. Tolkien", 1937, 4.25);
    Book b3 = new Book("The Kite Runner", "Khaled Hosseini", 2003, 4.26);

    lib.addBook(b1);
    lib.addBook(b2);
    lib.addBook(b3);
    System.out.println(lib);

    // iterator # 1
    Iterator<Book> it = lib.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }

    // iterator # 2
    List<Book> books = new ArrayList<>();
    books.add(b1);
    books.add(b2);
    books.add(b3);

    Iterator<Book> it2 = books.iterator();
    while (it2.hasNext()) {
      System.out.println(it2.next());
    }

    //method 1, will break encapsulation! can delete all books if you want
    // because this book list stores the reference/memory address of book list in Library class, so you can easily delete the entire book list
    List<Book> list = lib.getBooks1();
//    list.clear();
    System.out.println("library after using getBooks1 method");
    System.out.println(lib);
    System.out.println("----------------------------------------------------------------");



    // method 2, creates a shallow copy of original book list
    List<Book> list2 = lib.getBooks2();
    // this will not clear the books, so the book List is protected since it is the copy of the original bookList,
    // list is cleared but original library book list is not cleared
//    list2.clear();
    System.out.println("the list is cleared: " +  list2.toString());
    System.out.println("library after using getBooks2 method");
    System.out.println("original list is not cleared: " + System.lineSeparator() + lib);
    // but if you access into each book in list and change the value, the value in original list will be changed since its a shallow copy
    // and since each value in this shallow copied object is still shared and point to original value even though it is a different copy
    System.out.println("available books before checkout first: " + lib.getAvailableBooks());
    list.get(0).checkoutBook();
    System.out.println("available books after checkout first: " + lib.getAvailableBooks());
    System.out.println("----------------------------------------------------------------");



    // method3 deep copy but still not elegant, still can change the deep copy list and value
    List<Book> list3 = lib.getBooks3();
//    list3.clear();
    System.out.println(lib);
    list3.get(0).checkoutBook();
    System.out.println(lib.getAvailableBooks());
    System.out.println("----------------------------------------------------------------");

    // method 4 is best Collections.unmodifiableList(list4),
    // Collections.unmodifiableList() protect the list not being able to modified, but not protect individual item, individual item still being accessed and modified
    // but this way is more element than method 2 and 3 which is shallow copy and deep copy using Collections.unmodifiableList();
    List<Book> list4 = lib.getBooks4();
//    list4.clear(); // this will have error now, not able to clear since its not modifiedable
    list4.get(0).checkoutBook(); // this still can checkout in the deep copy list and modify the lib
    System.out.println("check out first book: " + lib.getAvailableBooks()); // first book still able to be checkout and be modified so no good still
    System.out.println(lib);
  }
}
