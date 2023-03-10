package library;

import java.io.*; 
import java.util.*;

public class BookFile {
    private String fileName = "library.dat";
    private File file;
    private BookList library;
    
    public BookFile() {
        try{
            //Question 5.a.1
            // Create a file object
            file = new File(fileName);
            library = new BookList();
            
            // Create the file if it does not exist
            if(!file.exists()) {
                file.createNewFile();
            }
            System.out.println("[INFO] File " + fileName + " has been created.");
            
            //Question 5.a.2
            //read the file and populate the library
            if (file.length() > 0) { // Only read the file if it is not empty
                FileInputStream fileIn = new FileInputStream(fileName);
                ObjectInputStream in = new ObjectInputStream(fileIn);

                HashMap<String, Book> bookMap = (HashMap<String, Book>) in.readObject();
                
                in.close();
                fileIn.close();
                
                for (Map.Entry<String, Book> entry : bookMap.entrySet()) {
                    library.addBook(entry.getValue());
                }
                System.out.println("[INFO] " + bookMap.size() + " books have been read from the file and added to the library.");
            }

            //Question 5.a.3
            List<Book> books = new ArrayList<>();
            books.add(new Book("The Lord of the Rings", "J.R.R", "Tolkien", Book.Category.NOVEL, 1234567890));
            books.add(new Book("The Hobbit", "J.R.R", "Tolkien", Book.Category.NOVEL, 1234567891));
            //display the books
            System.out.println("[DEBUG] The following books will be added to list:");
            for (Book book : books) {
                book.displayBook();
            }

            saveBooks(books);

        } catch(Exception e) {
            System.out.println("[ERROR] (In Book File constructor) => " + e.getMessage());
        }
    }

    public void saveBooks(List<Book> books) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(books);
            out.close();
            fileOut.close();
            System.out.println("[INFO] The book list has been saved to " + fileName);
        } catch (IOException e) {
            System.out.println("[ERROR] (In Book File saveBooks method) => " + e.getMessage());
        }
    }

}
