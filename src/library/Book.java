package library;

public class Book {
    private String title;
    private String authorFirstName;
    private String authorLastName;
    private Category category; // this is an enum

    private int isbn;
    private String registrationCode;

    //BOOK CATEGORIES
    public enum Category {
        DETECTIVE, NOVEL, JUNIOR, PHILOSOPHY, SCIENCE_FICTION
    }

    //CONSTRUCTORS
    public Book() {
    }

    // public Book(String title, String authorFirstName,String authorLastName,Category category,  int isbn  , String registrationCode) {
    //     this.title = title;
    //     this.authorFirstName = authorFirstName;
    //     this.authorLastName = authorLastName;
    //     this.category = category;
    //     this.isbn = isbn;
    //     this.registrationCode = registrationCode;
    // }

    public Book(String title, String authorFirstName,String authorLastName,Category category,  int isbn ) {
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.category = category;
        this.isbn = isbn;
        setRegistrationCode();
    }

    //GETTERS

    public int getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public Category getCategory() {
        return category;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    //SETTERS

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    // // MADE IN QUESTION 1.A
    // public void setRegistrationCode(String registrationCode) {
    //     this.registrationCode = registrationCode;
    // }

    // Question 2.C:  
    public void setRegistrationCode() {
        // Two first letters of the author's first and last name
        String authorInitials = this.authorLastName.substring(0, 2).toUpperCase() + this.authorFirstName.substring(0, 2).toUpperCase();
        // The first two letters of the book's category
        String categoryCode = "";
        switch (this.category) {
            case DETECTIVE:
                categoryCode = "DE";
                break;
            case NOVEL:
                categoryCode = "NO";
                break;
            case JUNIOR:
                categoryCode = "JU";
                break;
            case PHILOSOPHY:
                categoryCode = "PH";
                break;
            case SCIENCE_FICTION:
                categoryCode = "SC";
                break;
        }
        // The last two digits of the book's ISBN
        int isbnLastTwoDigits = this.isbn % 100;
        this.registrationCode = authorInitials + categoryCode + isbnLastTwoDigits;
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", authorFirstName=" + authorFirstName + ", authorLastName=" + authorLastName + ", category=" + category + ", isbn=" + isbn + ", registrationCode=" + registrationCode + '}';
    }

    public void displayBook() {
        System.out.println("Book = {\n" + "\tTitle=" + title + ",\n\tAuthor firstName=" + authorFirstName + ",\n\tAuthor lastName=" + authorLastName + ",\n\tCategory=" + category + ",\n\tISBN=" + isbn + ",\n\tregistration code=" + registrationCode + "\n}");
    } 

    // Second method for question 2.F
    public void displayOnlyTitleAndCode() {
        System.out.println("Book = {\n" + "\tTitle=" + title + ",\n\tregistration code=" + registrationCode + "\n}");
    }
    
}
