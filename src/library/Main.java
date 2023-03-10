package library;
import java.util.Scanner;

public class Main {
    // Question 2.b: Display the characteristics of the book object
    public static void displayBookCharacteristics(Book book) {
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthorFirstName() + " " + book.getAuthorLastName());
        System.out.println("Category: " + book.getCategory());
        System.out.println("ISBN: " + book.getIsbn());
        System.out.println("Registration code: " + book.getRegistrationCode());
    }

    //verify if the input length is greater than 2 characters because the registration code must be at least 2 characters
    public static boolean verifyInputLength(String input) {
        if (input.length() < 2) {
            return false;
        }
        return true;
    }

    public static boolean verifyISBNInputLength(int number) {
        if (number < 10) {
            return false;
        }
        return true;
    }
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // test class Book
        Book book = new Book("The Lord of the Rings", "J.R.R.", "Tolkien", Book.Category.NOVEL, 123456789, "ABC123");
        System.out.println(book);

        // Question 1.b        
        Book pocketBook = new Book();

        System.out.println("********** Welcome to my library **********");
        System.out.println("Enter the title of the book: ");
        pocketBook.setTitle(scanner.nextLine());
        
        System.out.println("Enter the first name of the author: ");
        String firstName = scanner.nextLine();
        while (!verifyInputLength(firstName)) {
            System.out.println("Invalid input. Please enter at least 2 characters: ");
            firstName = scanner.nextLine();
        }
        pocketBook.setAuthorFirstName(firstName);
        
        System.out.println("Enter the last name of the author: ");
        String lastName = scanner.nextLine();
        while (!verifyInputLength(lastName)) {
            System.out.println("Invalid input. Please enter at least 2 characters: ");
            lastName = scanner.nextLine();
        }
        pocketBook.setAuthorLastName(lastName);
        
        System.out.println("Enter the category of the book: ");
        String categoryInput = scanner.nextLine().toUpperCase();
        // While the category is not valid, we continue to ask the user to enter a valid category
        while (!categoryInput.equals("DETECTIVE") && !categoryInput.equals("NOVEL") && !categoryInput.equals("JUNIOR") && !categoryInput.equals("PHILOSOPHY") && !categoryInput.equals("SCIENCE_FICTION")) {
            System.out.println("Invalid category. Please enter a valid category [DETECTIVE, NOVEL, JUNIOR, PHILOSOPHY, SCIENCE_FICTION]:");
            categoryInput = scanner.nextLine().toUpperCase();
        }
        pocketBook.setCategory(Book.Category.valueOf(categoryInput));
        
        System.out.println("Enter the ISBN of the book: (int)");
        int isbn = scanner.nextInt();
        while (!verifyISBNInputLength(isbn)) {
            System.out.println("Invalid input. Please enter at least 2 digits: ");
            isbn = scanner.nextInt();
        }
        pocketBook.setIsbn(isbn);
        
        // Changed in Question 2.C
        // System.out.println("Enter the registration code of the book: (String)");
        // pocketBook.setRegistrationCode(scanner.next());
        pocketBook.setRegistrationCode();
        
        System.out.println("[INFO] Book created successfully!");
        System.out.println("[DEBUG] " + pocketBook.toString());
        
        // Question 2.A:
        pocketBook.displayBook();

        // Question 2.B:
        displayBookCharacteristics(pocketBook);

        System.out.println("********** thank you for using my library **********");

        scanner.close();
    }
    
}

