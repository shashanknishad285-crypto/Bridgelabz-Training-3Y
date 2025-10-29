
public class LibraryBook {
    private String title;
    private String author;
    private double price;
    private boolean available;

    public LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }

    public void borrow() {
        if (available) {
            available = false;
            System.out.println("Borrowed: " + title);
        } else {
            System.out.println("Book is not available.");
        }
    }

    public void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: " + price + ", Available: " + available);
    }

    public static void main(String[] args) {
        LibraryBook book = new LibraryBook("Gravity's Rainbow", "Thomas Pynchon", 570.0);
        book.displayBook();
        book.borrow();
        book.displayBook();
        book.borrow();
    }
}
