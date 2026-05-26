import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        library.loadBooks();

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Save Data");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    Book book =
                            new Book(id, title, author);

                    library.addBook(book);

                    break;

                case 2:

                    library.displayBooks();

                    break;

                case 3:

                    System.out.print("Enter Book ID: ");

                    int searchId = sc.nextInt();

                    Book found =
                            library.searchBook(searchId);

                    if (found != null) {
                        System.out.println(found);
                    }

                    else {
                        System.out.println("Book not found!");
                    }

                    break;

                case 4:

                    System.out.print("Enter Book ID: ");

                    int issueId = sc.nextInt();

                    library.issueBook(issueId);

                    break;

                case 5:

                    System.out.print("Enter Book ID: ");

                    int returnId = sc.nextInt();

                    library.returnBook(returnId);

                    break;

                case 6:

                    library.saveBooks();

                    break;

                case 7:

                    library.saveBooks();

                    System.out.println("Thank You!");

                    System.exit(0);

                    break;

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}