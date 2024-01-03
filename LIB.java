import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
class Library {
    private Map<String, Book> books;

    public Library() {
        books = new HashMap<>();
    }

    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        books.put(title, book);
    }

    public void displayBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : books.values()) {
            if (book.isAvailable()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }

    public boolean borrowBook(String title) {
        Book book = books.get(title);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            return true;
        }
        return false;
    }

    public void returnBook(String title) {
        Book book = books.get(title);
        if (book != null) {
            book.setAvailable(true);
            System.out.println("Thank you for returning " + title);
        }
    }
}
class User {
    private String userId;
    private List<String> borrowedBooks;

    public User(String userId) {
        this.userId = userId;
        borrowedBooks = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public List<String> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(String title) {
        borrowedBooks.add(title);
    }

    public void returnBook(String title) {
        borrowedBooks.remove(title);
    }
}
public class LIB {
    private Library library;
    private Map<String, User> users;

    public LIB() {
        library = new Library();
        users = new HashMap<>();
    }

    public void addUser(String userId) {
        users.put(userId, new User(userId));
    }

    public void addBook(String title, String author) {
        library.addBook(title, author);
    }

    public void displayAvailableBooks() {
        library.displayBooks();
    }

    public boolean borrowBook(String userId, String title) {
        User user = users.get(userId);
        if (user != null && library.borrowBook(title)) {
            user.borrowBook(title);
            return true;
        }
        return false;
    }

    public void returnBook(String userId, String title) {
        User user = users.get(userId);
        if (user != null) {
            user.returnBook(title);
            library.returnBook(title);
        }
    }
    
    public static void main(String[] args) {
        LIB digitalLibrary = new LIB();

        digitalLibrary.addUser("Ammu");
        digitalLibrary.addUser("sai");

        digitalLibrary.addBook("utopia", "thomasmoor");
        digitalLibrary.addBook("macbeth", "shakespeare");
        digitalLibrary.addBook("principia", "newton");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nDigital Library Menu:");
            System.out.println("1. Display Available Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Quit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    digitalLibrary.displayAvailableBooks();
                    break;
                case 2:
                    System.out.print("Enter User ID: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter Book Title to Borrow: ");
                    String bookToBorrow = scanner.nextLine();
                    if (digitalLibrary.borrowBook(userId, bookToBorrow)) {
                        System.out.println("Book borrowed successfully!");
                    } else {
                        System.out.println("Book not available or user not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter User ID: ");
                    String returnUserId = scanner.nextLine();
                    System.out.print("Enter Book Title to Return: ");
                    String bookToReturn = scanner.nextLine();
                    digitalLibrary.returnBook(returnUserId, bookToReturn);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }
}
