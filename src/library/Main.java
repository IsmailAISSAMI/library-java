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

        String title, firstName, lastName, category;
        int choice=-1,isbn;
        
        //create a book list object
        BookList bookList = new BookList();

        System.out.println("********** Welcome to my library **********");

        //while the user does not choose to exit the program, we continue to ask him to choose an option
        while (choice != 6) {
            //create a menu for the user to choose what he wants to do
            System.out.println("Please choose an option:");
            System.out.println("1. Add a book");
            System.out.println("2. Search a book");
            System.out.println("3. Remove a book");
            System.out.println("4. Display all books");
            System.out.println("5. Display a book");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Book pocketBook = new Book();
                    System.out.println("Enter the title of the book: ");
                    pocketBook.setTitle(scanner.nextLine());
                    
                    System.out.println("Enter the first name of the author: ");
                    firstName = scanner.nextLine();
                    while (!verifyInputLength(firstName)) {
                        System.out.println("Invalid input. Please enter at least 2 characters: ");
                        firstName = scanner.nextLine();
                    }
                    pocketBook.setAuthorFirstName(firstName);
                    
                    System.out.println("Enter the last name of the author: ");
                    lastName = scanner.nextLine();
                    while (!verifyInputLength(lastName)) {
                        System.out.println("Invalid input. Please enter at least 2 characters: ");
                        lastName = scanner.nextLine();
                    }
                    pocketBook.setAuthorLastName(lastName);
                    
                    System.out.println("Enter the category of the book: ");
                    category = scanner.nextLine().toUpperCase();
                    // While the category is not valid, we continue to ask the user to enter a valid category
                    while (!category.equals("DETECTIVE") && !category.equals("NOVEL") && !category.equals("JUNIOR") && !category.equals("PHILOSOPHY") && !category.equals("SCIENCE_FICTION")) {
                        System.out.println("Invalid category. Please enter a valid category [DETECTIVE, NOVEL, JUNIOR, PHILOSOPHY, SCIENCE_FICTION]:");
                        category = scanner.nextLine().toUpperCase();
                    }
                    pocketBook.setCategory(Book.Category.valueOf(category));
                    
                    System.out.println("Enter the ISBN of the book: ");
                    isbn = scanner.nextInt();
                    while (!verifyISBNInputLength(isbn)) {
                        System.out.println("Invalid input. Please enter at least 2 digits: ");
                        isbn = scanner.nextInt();
                    }
                    pocketBook.setIsbn(isbn);

                    pocketBook.setRegistrationCode();

                    System.out.println("Here is the book you have entered: ");
                    displayBookCharacteristics(pocketBook);
                    
                    bookList.addBook(pocketBook);
                    break;
                case 2:
                    System.out.println("Enter the title of the book you want to search: ");
                    title = scanner.nextLine();
                    Book searchedBook = bookList.searchBookByTitle(title);
                    if (searchedBook != null) {
                        System.out.println("Here is the book you have searched for: ");
                        displayBookCharacteristics(searchedBook);
                    } else {
                        System.out.println("The book you have searched for does not exist in the library.");
                    }
                    break;
                case 3:
                    System.out.println("Enter the Infos about the book you want to remove: ");
                    System.out.println("Enter the first name of the author: ");
                    firstName = scanner.nextLine();
                    while (!verifyInputLength(firstName)) {
                        System.out.println("Invalid input. Please enter at least 2 characters: ");
                        firstName = scanner.nextLine();
                    }
                    System.out.println("Enter the last name of the author: ");
                    lastName = scanner.nextLine();
                    while (!verifyInputLength(lastName)) {
                        System.out.println("Invalid input. Please enter at least 2 characters: ");
                        lastName = scanner.nextLine();
                    }
                    System.out.println("Enter the category of the book: ");
                    category = scanner.nextLine().toUpperCase();
                    while (!category.equals("DETECTIVE") && !category.equals("NOVEL") && !category.equals("JUNIOR") && !category.equals("PHILOSOPHY") && !category.equals("SCIENCE_FICTION")) {
                        System.out.println("Invalid category. Please enter a valid category [DETECTIVE, NOVEL, JUNIOR, PHILOSOPHY, SCIENCE_FICTION]:");
                        category = scanner.nextLine().toUpperCase();
                    }
                    System.out.println("Enter the ISBN of the book: ");
                    isbn = scanner.nextInt();
                    while (!verifyISBNInputLength(isbn)) {
                        System.out.println("Invalid input. Please enter at least 2 digits: ");
                        isbn = scanner.nextInt();
                    }
                        
                    bookList.removeBook(firstName, lastName, Book.Category.valueOf(category), isbn);
                    break;
                case 4:
                    System.out.println("Here is the list of all the books in the library: ");
                    bookList.displayAllBooks();
                    break;
                case 5:
                    System.out.println("Enter the registration code of the book you want to display: ");
                    String registrationCode = scanner.nextLine();
                    bookList.displayBook(registrationCode);
                    break;
                case 6:
                    System.out.println("Thank you for using my library!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid choice: ");
                    break;
            }
                    
        }
        
        scanner.close();

        // // Question 1.b        
        // Book pocketBook = new Book();

        // System.out.println("********** Welcome to my library **********");
        // System.out.println("Enter the title of the book: ");
        // pocketBook.setTitle(scanner.nextLine());
        
        // System.out.println("Enter the first name of the author: ");
        // String firstName = scanner.nextLine();
        // while (!verifyInputLength(firstName)) {
        //     System.out.println("Invalid input. Please enter at least 2 characters: ");
        //     firstName = scanner.nextLine();
        // }
        // pocketBook.setAuthorFirstName(firstName);
        
        // System.out.println("Enter the last name of the author: ");
        // String lastName = scanner.nextLine();
        // while (!verifyInputLength(lastName)) {
        //     System.out.println("Invalid input. Please enter at least 2 characters: ");
        //     lastName = scanner.nextLine();
        // }
        // pocketBook.setAuthorLastName(lastName);
        
        // System.out.println("Enter the category of the book: ");
        // String categoryInput = scanner.nextLine().toUpperCase();
        // // While the category is not valid, we continue to ask the user to enter a valid category
        // while (!categoryInput.equals("DETECTIVE") && !categoryInput.equals("NOVEL") && !categoryInput.equals("JUNIOR") && !categoryInput.equals("PHILOSOPHY") && !categoryInput.equals("SCIENCE_FICTION")) {
        //     System.out.println("Invalid category. Please enter a valid category [DETECTIVE, NOVEL, JUNIOR, PHILOSOPHY, SCIENCE_FICTION]:");
        //     categoryInput = scanner.nextLine().toUpperCase();
        // }
        // pocketBook.setCategory(Book.Category.valueOf(categoryInput));
        
        // System.out.println("Enter the ISBN of the book: (int)");
        // int isbn = scanner.nextInt();
        // while (!verifyISBNInputLength(isbn)) {
        //     System.out.println("Invalid input. Please enter at least 2 digits: ");
        //     isbn = scanner.nextInt();
        // }
        // pocketBook.setIsbn(isbn);
        
        // // Changed in Question 2.C
        // // System.out.println("Enter the registration code of the book: (String)");
        // // pocketBook.setRegistrationCode(scanner.next());
        // pocketBook.setRegistrationCode();
        
        // System.out.println("[INFO] Book created successfully!");
        // System.out.println("[DEBUG] " + pocketBook.toString());
        
        // // Question 2.A:
        // pocketBook.displayBook();

        // // Question 2.B:
        // displayBookCharacteristics(pocketBook);

        // // Question 2.F:
        // System.out.println("[INFO] The question 2.f");

        // System.out.println("-First method-");
        // System.out.println("The title of the pocket book is: "+ pocketBook.getTitle());
        // System.out.println("The code of the pocket book is: "+ pocketBook.getRegistrationCode());

        // System.out.println("-Second method-");
        // pocketBook.displayOnlyTitleAndCode();
        // System.out.println("********** thank you for using my library **********");
        // scanner.close();

        // // ****** Question 3 ********
        // BookList lib = new BookList();
        // Book book1 = new Book("The Lord of the Rings", "J.R.R", "Tolkien", Book.Category.NOVEL, 1234567890);

        // //QUESTION 3.B.1
        // lib.addBook(book1);
        // lib.addBook(pocketBook);

        // //QUESTION 3.B.2
        // lib.removeBook(pocketBook.getAuthorFirstName(), pocketBook.getAuthorLastName(), pocketBook.getCategory(), pocketBook.getIsbn());

        // //QUESTION 3.B.3
        // lib.displayAllBooks();

        // //QUESTION 3.B.4
        // lib.displayBook(book1.getRegistrationCode());

        // // ****** Question 5 ********
        // //test
        // BookFile test = new BookFile();

        // System.exit(0);

    }
    
}

