package library;
import java.util.HashMap;

public class BookList {
    // Question 3.a.1 
    private HashMap<String, Book> list;
    
    // Question 3.a.2
    public BookList() {
        list = new HashMap<>();
    }

    // Question 3.a.3
    public void addBook(Book newBook) {
        list.put(newBook.getRegistrationCode(), newBook);
    }

    // Question 3.a.4
    public void searchBook(String authorFirstName, String authorLastName,String category, int isbn) {
        for (Book book : list.values()) {
            if (book.getAuthorFirstName().equals(authorFirstName) && book.getAuthorLastName().equals(authorLastName) && book.getCategory().equals(category) && book.getIsbn() == isbn) {
                System.out.println("The book is in the library.");
                return;
            }
        }
        System.out.println("The book is not in the library.");
    }

    // Question 3.a.5
    public void removeBook(String authorFirstName, String authorLastName,String category, int isbn) {
        for (Book book : list.values()) {
            if (book.getAuthorFirstName().equals(authorFirstName) && book.getAuthorLastName().equals(authorLastName) && book.getCategory().equals(category) && book.getIsbn() == isbn) {
                list.remove(book.getRegistrationCode());
                System.out.println("The book has been removed from the library.");
                return;
            }
        }
        System.out.println("The book is not in the library.");
    }

    // Question 3.a.6
    public void displayAllBooks() {
        System.out.println("[INFO] All books in the library:");
        for (Book book : list.values()) {
            book.displayBook();
            //System.out.println(book);
        }
    }
    
}
