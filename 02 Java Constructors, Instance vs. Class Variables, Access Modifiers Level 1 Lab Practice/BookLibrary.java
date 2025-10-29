
class BookLibrary {
    public String ISBN;
    protected String title;
    private String author;

    public BookLibrary(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
}

class EBook extends BookLibrary {
    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    public void displayAccess() {
        System.out.println("ISBN (public): " + ISBN +
            ", Title (protected): " + title);
    }

    public static void main(String[] args) {
        EBook eb = new EBook("889X", "Java Basics", "Smith");
        eb.displayAccess();
        eb.setAuthor("Johnson");
        System.out.println("Author (private, via getter): " + eb.getAuthor());
    }
}
