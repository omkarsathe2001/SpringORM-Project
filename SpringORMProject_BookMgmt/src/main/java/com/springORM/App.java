package com.springORM;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springORM.BooksImplemented.BookImplemented;
import com.springORM.Entity.BookStore;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println("Project Starting");
        
        Scanner sc = new Scanner(System.in);
        
        // Load Spring configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        BookImplemented imp = (BookImplemented) context.getBean("bimpl");
        
        // Display menu to the user
        int choice = 0;
        while (choice != 6) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add a Book");
            System.out.println("2. Change a Book");
            System.out.println("3. Remove a Book");
            System.out.println("4. Get Book by ID");
            System.out.println("5. Show All Books");
            System.out.println("6. Exit");
            System.out.print("Enter Choice :- ");
            
            choice = sc.nextInt(); // Get user input for the operation
            
            switch (choice) {
                case 1:
                    // Add a book
                    System.out.print("Enter book ID: ");
                    int addId = sc.nextInt();
                    sc.nextLine(); // Consume the newline character
                    System.out.print("Enter book name: ");
                    String addName = sc.nextLine();
                    System.out.print("Enter author name: ");
                    String addAuthor = sc.nextLine();
                    System.out.print("Enter book price: ");
                    double addPrice = sc.nextDouble();
                    
                    BookStore newBook = new BookStore(addId, addName, addAuthor, addPrice);
                    imp.add(newBook);
                    System.out.println("Book Added Successfully...!!!");
                    break;
                    
                case 2:
                    // Change a book
                    System.out.println("Enter book ID to change: ");
                    int changeId = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.println("Enter new book name: ");
                    String changeName = sc.nextLine();
                    System.out.println("Enter new author name: ");
                    String changeAuthor = sc.nextLine();
                    System.out.println("Enter new price: ");
                    double changePrice = sc.nextDouble();
                    
                    BookStore changeBook = new BookStore(changeId, changeName, changeAuthor, changePrice);
                    imp.change(changeBook);
                    System.out.println("Book Changed Successfully...!!!");
                    break;
                    
                case 3:
                    // Remove a book
                    System.out.println("Enter book ID to remove: ");
                    int removeId = sc.nextInt();
                    imp.remove(removeId);
                    System.out.println("Book Removed Successfully...!!!");
                    break;
                    
                case 4:
                    // Get book by ID
                    System.out.println("Enter book ID to get: ");
                    int getId = sc.nextInt();
                    imp.getBookByID(getId);
                    break;
                    
                case 5:
                    // Show all books
                    imp.showAllBooks();
                    break;
                    
                case 6:
                    // Exit the program
                    System.out.println("Exiting...");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        
        sc.close();
    }
}
