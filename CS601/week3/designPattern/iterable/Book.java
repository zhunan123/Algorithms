package week3.designPattern.iterable;

public class Book {
    private String title;
    private String author;
    private int year;
    private double avgRating;
    public boolean isCheckout;

    public Book(String title, String author, int year, double avgRating) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.avgRating = avgRating;
//    this.isCheckout = isCheckout;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public boolean isCheckout() {
        return isCheckout;
    }

    public boolean checkoutBook() {
        if (!isCheckout) {
            isCheckout = true;
            return true;
        }
        return false;
    }

    public boolean returnBook() {
        if (isCheckout) {
            isCheckout = false;
            return true;
        }
        return false;
    }

    public String toString() {
        return title + ", " + author + ", " + year;
    }
}
