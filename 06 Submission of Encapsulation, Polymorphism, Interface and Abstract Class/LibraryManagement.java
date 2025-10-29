
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public void getItemDetails() {
        System.out.println("ID: "+itemId+", Title: "+title+", Author: "+author);
    }

    public abstract int getLoanDuration(); // days
}

class Book extends LibraryItem implements Reservable {
    private boolean reserved;

    public Book(String id, String title, String author) {
        super(id, title, author);
        reserved = false;
    }

    @Override
    public int getLoanDuration() {
        return 21; // 3 weeks
    }

    public void reserveItem() {
        if (!reserved) {
            reserved = true;
            System.out.println("Book reserved: " + getTitle());
        } else {
            System.out.println("Book already reserved.");
        }
    }

    public boolean checkAvailability() {
        return !reserved;
    }
}

class Magazine extends LibraryItem {
    public Magazine(String id, String title, String author) {
        super(id, title, author);
    }
    @Override
    public int getLoanDuration() {
        return 7; // 1 week
    }
}

class DVD extends LibraryItem {
    public DVD(String id, String title, String author) {
        super(id, title, author);
    }
    @Override
    public int getLoanDuration() {
        return 5; // 5 days
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        LibraryItem[] items = {
            new Book("B001", "Effective Java", "Joshua Bloch"),
            new Magazine("M001", "National Geographic", "NatGeo"),
            new DVD("D001", "Inception", "Christopher Nolan")
        };

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            if (item instanceof Reservable) {
                Reservable reservable = (Reservable) item;
                reservable.reserveItem();
                System.out.println("Available? " + reservable.checkAvailability());
            }
            System.out.println();
        }
    }
}
