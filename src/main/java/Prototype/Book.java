package Prototype;

public class Book {
    private String title;
    private String author;
    private String genre;
    private int publicationYear;

    public Book(String author, String title, String genre, int publicationYear) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.publicationYear = publicationYear;

    }
    @Override
    public Book clone() {
        try {
            Book clonedBook = (Book) super.clone();
            return clonedBook;
        } catch (CloneNotSupportedException e) {
            return new Book(this.author, this.title, this.genre, this.publicationYear);
        }
    }

    @Override
    public String toString() {
        return String.format("%s by %s (%s, %d)", title, author, genre, publicationYear);
    }
}