package week2.classAndObjectEncapsulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Library implements Iterable<Book>{
  private final List<Book> books;
  private int numBooks;
  private String title;


  public Library() {
    books = new ArrayList<>();
  }

  public void addBook(Book book) {
    books.add(book);
  }

  public int getNumBooks() {
    return numBooks;
  }

  public Book findBook(String title) {
    for (Book book1 : books) {
      if (book1.getTitle().equals(title)) {
        return book1;
      }
    }
    return null;
  }

  public boolean checkoutBook(Book book) {
    Book book1 = findBook(book.getTitle());
    if (book1 != null) {
      return book1.checkoutBook();
    }
    return false;
  }

  public boolean returnBook(String title) {
    Book book1 = findBook(title);
    if (book1 != null) {
      return book1.returnBook();
    }
    return false;
  }

  public String getAvailableBooks() {
    StringBuilder sb = new StringBuilder();
    for (Book book : books) {
      if (!book.isCheckout()) {
        sb.append(book.toString() + System.lineSeparator());
      }
    }
    return sb.toString();
  }

  // break encapsulation, when we call this method, we can delete all books if we want
  // shallow copy
  public List<Book> getBooks1() {
    return books;
  }

  // method 2 shallow copy
  public List<Book> getBooks2() {
    List<Book> copy = new ArrayList<>();
    for (Book book : books) {
      copy.add(book);
    }
    return copy;
  }

  // method 3 deep copy, this is best?
  public List<Book> getBooks3() {
    List<Book> copy = new ArrayList<>();
    for (Book book : books) {
      copy.add(new Book (book.getTitle(), book.getAuthor(), book.getYear(), book.getAvgRating()));
    }
    return copy;
  }

  // still able to modify the list?
  public List<Book> getBooks4() {
    return Collections.unmodifiableList(books);
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Book book : books) {
      sb.append(book.toString() + System.lineSeparator());
    }
    return sb.toString();
  }

  @Override
  public Iterator<Book> iterator() {
    return books.iterator();
  }
}
