import java.io.*;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    // Add Book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book Added Successfully!");
    }

    // View All Books
    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Search Book
    public Book searchBook(int id) {

        for (Book book : books) {

            if (book.getBookId() == id) {
                return book;
            }
        }

        return null;
    }

    // Issue Book
    public void issueBook(int id) {

        Book book = searchBook(id);

        if (book == null) {
            System.out.println("Book not found!");
        }

        else if (book.isIssued()) {
            System.out.println("Book already issued.");
        }

        else {
            book.issueBook();
            System.out.println("Book issued successfully.");
        }
    }

    // Return Book
    public void returnBook(int id) {

        Book book = searchBook(id);

        if (book == null) {
            System.out.println("Book not found!");
        }

        else if (!book.isIssued()) {
            System.out.println("Book was not issued.");
        }

        else {
            book.returnBook();
            System.out.println("Book returned successfully.");
        }
    }

    // Save Data
    public void saveBooks() {

        try {

            ObjectOutputStream out =
                    new ObjectOutputStream(
                            new FileOutputStream("library.dat"));

            out.writeObject(books);

            out.close();

            System.out.println("Data Saved Successfully!");

        }

        catch (IOException e) {

            System.out.println("Error Saving Data!");
        }
    }

    // Load Data
    @SuppressWarnings("unchecked")
    public void loadBooks() {

        try {

            ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream("library.dat"));

            books = (ArrayList<Book>) in.readObject();

            in.close();

            System.out.println("Data Loaded Successfully!");

        }

        catch (Exception e) {

            System.out.println("No Previous Data Found.");
        }
    }
}