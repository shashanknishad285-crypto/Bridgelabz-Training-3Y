
class Book {
    protected String title;
    protected int publicationYear;
    public Book(String title, int year) {
        this.title = title;
        this.publicationYear = year;
    }
    public void displayInfo(){
        System.out.println("Book: " + title + ", Year: " + publicationYear);
    }
}
class Author extends Book {
    private String name;
    private String bio;
    public Author(String title, int year, String name, String bio) {
        super(title, year);
        this.name = name;
        this.bio = bio;
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Author: " + name);
        System.out.println("Bio: " + bio);
    }
}
public class BookAuthorInheritance {
    public static void main(String[] args){
        Author a = new Author("The Great Gatsby", 1925, "F. Scott Fitzgerald", "Famous American author");
        a.displayInfo();
    }
}
