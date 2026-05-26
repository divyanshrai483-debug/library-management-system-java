import java.io.Serializable;

public class Book implements Serializable {

    private int bookId;
    private String title;
    private String author;
    private boolean issued;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return issued;
    }

    public void issueBook() {
        issued = true;
    }

    public void returnBook() {
        issued = false;
    }

    @Override
    public String toString() {

        return "Book ID: " + bookId +
                "\nTitle: " + title +
                "\nAuthor: " + author +
                "\nStatus: " +
                (issued ? "Issued" : "Available") +
                "\n---------------------";
    }
}