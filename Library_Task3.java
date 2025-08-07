import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.*;

class Book
{
	int bookId;
	String title;
	boolean isIssued;

	public Book(int bookID, String title)
	{
		this.bookId = bookId;
		this.title = title;
		this.isIssued = isIssued;
	}
}

class User
{
	int UserID;
	String userName;
	public String name;

	public User(int userId, String userName)
	{
		this.UserID = userId;
		this.userName = userName;
	}
}

class Library {
    List<Book> books = new ArrayList<>();
    Map<Integer, Integer> issuedBooks = new HashMap<>(); // bookId -> userId

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book book : books) {
            String status = book.isIssued ? "Issued" : "Available";
            System.out.println(book.bookId + ": " + book.title + " [" + status + "]");
        }
    }

    public void issueBook(int bookId, User user) {
        for (Book book : books) {
            if (book.bookId == bookId) {
                if (!book.isIssued) {
                    book.isIssued = true;
                    issuedBooks.put(bookId, user.UserID);
                    System.out.println("Book issued to " + user.name);
                    return;
                } else {
                    System.out.println("Book is already issued.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(int bookId, User user) {
        for (Book book : books) {
            if (book.bookId == bookId) {
                if (book.isIssued && issuedBooks.get(bookId) == user.UserID) {
                    book.isIssued = false;
                    issuedBooks.remove(bookId);
                    System.out.println("Book returned by " + user.name);
                    return;
                } else {
                    System.out.println("Return failed. Either book is not issued or wrong user.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }
}


public class Library_Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        boolean running = true;

        while (running) {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    library.addBook(new Book(bookId, title));
                    break;

                case 2:
                    library.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter User ID: ");
                    int uid1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter User Name: ");
                    String uname1 = sc.nextLine();
                    User user1 = new User(uid1, uname1);
                    library.issueBook(issueId, user1);
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter User ID: ");
                    int uid2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter User Name: ");
                    String uname2 = sc.nextLine();
                    User user2 = new User(uid2, uname2);
                    library.returnBook(returnId, user2);
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
