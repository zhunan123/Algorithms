package week3.designPattern.iterable;

import week2.classAndObjectEncapsulation.Book;

import java.util.Iterator;

public class LibraryWithIterableDriver {
    public static void main(String[] args) {
        LibraryWithIterable lib = new LibraryWithIterable();
        Book b1 = new week2.classAndObjectEncapsulation.Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, 4.34);
        Book b2 = new week2.classAndObjectEncapsulation.Book("The Hobbit or There and Back Again", "J.R.R. Tolkien", 1937, 4.25);
        Book b3 = new Book("The Kite Runner", "Khaled Hosseini", 2003, 4.26);
        lib.addBook(b1);
        lib.addBook(b2);
        lib.addBook(b3);

        Iterator<Book> it = lib.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
