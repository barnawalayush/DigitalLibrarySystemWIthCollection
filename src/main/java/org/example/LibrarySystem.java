package org.example;

import org.example.MiddleWare.Controller.LibrarianController;
import org.example.MiddleWare.Controller.ManagementSystemController;
import org.example.MiddleWare.Controller.UserController;
import org.example.entity.*;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.Scanner;

public class LibrarySystem {

    private static UserController userController;
    private static LibrarianController librarianController;
    private static ManagementSystemController managementSystemController;
    private static User user;
    private static Boolean loggedIn;
    private static Connection connection;

    public static void main(String[] args) {

        LibraryDatabase.generateDatabase();

        connection = DatabaseConnection.connect();

        loggedIn = true;

        userController = new UserController();
        librarianController = new LibrarianController();
        managementSystemController = new ManagementSystemController();

        System.out.println("Select mode to LogIn:");
        System.out.println("1. Customer");
        System.out.println("2. Librarian");

        Scanner scanner = new Scanner(System.in);

        String selectedMode = scanner.nextLine();
        while(true){
            if(selectedMode.equals("1")){
                authenticateUser(scanner);
                break;
            }else if(selectedMode.equals("2")){
                authenticateLibrarian(scanner);
                break;
            }else {
                System.out.println("\nPlease Select the right Option!\n");
                selectedMode = scanner.nextLine();
            }
        }

    }



    private static void authenticateUser(Scanner scanner) {

        System.out.println("Please enter your login detail:");
        System.out.print("UserName: ");
        String name  = scanner.nextLine();
        System.out.print("password: ");
        String password = scanner.nextLine();

        if(managementSystemController.logInUser(new User(name, password), connection)){
            user = managementSystemController.getUser(new User(name, password), connection);
            System.out.println("Welcome to Library");
            handleUser(scanner);
        }else{
            System.out.println("bad Credential");
            authenticateUser(scanner);
        }

    }
    private static void authenticateLibrarian(Scanner scanner) {

        System.out.println("Please enter your login detail:");
        System.out.print("LibrarianName: ");
        String name  = scanner.nextLine();
        System.out.print("password: ");
        String password = scanner.nextLine();

        if(managementSystemController.logInLibrarian(new Librarian(name, password), connection)){
            Librarian librarian = managementSystemController.getLibrarian(new Librarian(name, password), connection);
            System.out.println("Welcome to Library");
            handleLibrarian(librarian, scanner);
        }else{
            System.out.println("bad Credential");
            authenticateLibrarian(scanner);
        }

    }



    private static void handleUser(Scanner scanner) {

        while (loggedIn){
            printUserFunctionality();
            String selectedOption = scanner.nextLine();

            switch (selectedOption){
                case "1":
                    userController.displayBook(connection);
                    break;
                case "2":
                    handleBookBorrowRequest(scanner);
                    break;
                case "3":
                    userController.displayBorrowedBook(user.getUserId(), connection);
                    break;
                case "4":
                    userController.displayDeadlineCrossedBook(user.getUserId(), connection);
                    break;
                case "5":
                    searchBookByPublications(scanner);
                    break;
                case "6":
                    fileComplain(scanner);
                    break;
                case "7":
                    userController.seeAllComplaint(user, connection);
                    break;
                case "8":
                    submitFeedback(scanner);
                    break;
                case "9":
                    System.out.println("Come Again...");
                    System.out.println("Thank You!");
                    loggedIn = false;
                    break;
            }
        }
    }
    private static void handleLibrarian(Librarian librarian, Scanner scanner) {

        while (loggedIn){
            printLibrarianFunctionality();
            String selectedOption = scanner.nextLine();

            switch (selectedOption){
                case "1":
                    librarianController.displayBooks();
                    break;
                case "2":
                    addBook(scanner);
                    break;
                case "3":
                    updateBook(scanner);
                    break;
                case "4":
                    deleteBook(scanner);
                    break;
                case "5":
                    librarianController.displayAllUsers(connection);
                    break;
                case "6":
                    removeUser(scanner);
                    break;
                case "7":
                    librarianController.displayAllComplaint();
                    break;
                case "8":
                    getAllFeedbackByBookName(scanner);
                    break;
                case "9":
                    System.out.println("Come Again...");
                    System.out.println("Thank You!");
                    loggedIn = false;
                    break;
            }
        }
    }



    private static void submitFeedback(Scanner scanner) {
        System.out.println();
        System.out.print("Please enter the Book Id for which you want to give feedback: ");

        String bookId = scanner.nextLine();

        System.out.println("Enter the feedback:");
        String feedbackMessage = scanner.nextLine();

        Feedback feedback = new Feedback(user, bookId, feedbackMessage, LocalDate.now());
        userController.submitFeedback(feedback, connection);

    }
    private static void fileComplain(Scanner scanner) {
        System.out.println("Please enter the complain you want to file");
        String complaintMessage = scanner.nextLine();

        Complaint complaint = new Complaint(user, complaintMessage, LocalDate.now());

        userController.fileComplaint(complaint, connection);
    }
    private static void searchBookByPublications(Scanner scanner) {
        System.out.print("Please enter the publication: ");
        String publication = scanner.nextLine();

        userController.searchBookByPublications(publication, connection);
    }
    private static void handleBookBorrowRequest(Scanner scanner) {
        System.out.print("Please select the book Id: ");
        String selectedBookId = scanner.nextLine();

        userController.borrowBook(user.getUserId(), selectedBookId, connection);
    }
    private static void getAllFeedbackByBookName(Scanner scanner) {
        System.out.print("Enter the Book Id: ");
        String bookId = scanner.nextLine();
        librarianController.getAllFeedbacksByBookName(bookId, connection);
    }
    private static void removeUser(Scanner scanner) {
        System.out.print("Please enter the userId: ");
        String userId = scanner.nextLine();

        User userToRemove = managementSystemController.getUserById(userId);

        librarianController.removeUser(userToRemove, connection);
    }
    private static void deleteBook(Scanner scanner) {
        System.out.print("Please enter the Book Id you want to delete: ");
        String bookId = scanner.nextLine();

        librarianController.deleteBookById(bookId, connection);
    }
    private static void updateBook(Scanner scanner) {

    }
    private static void addBook(Scanner scanner) {

        System.out.println("Please enter the book details: ");
        System.out.print("Book Id: ");
        String bookId = scanner.nextLine();
        System.out.print("Book Name: ");
        String bookName = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Publications: ");
        String publications = scanner.nextLine();
        System.out.print("Category: ");
        String category = scanner.nextLine();

        Book book = new Book(bookName, bookId, author, publications, true, category, null);
        librarianController.addBook(book, connection);
    }



    private static void printLibrarianFunctionality() {
        System.out.println();
        System.out.println("Select the functionality which you want to use:");
        System.out.println("1. Display all Books");
        System.out.println("2. Add Book");
        System.out.println("3. Update Book");
        System.out.println("4: Delete Book");
        System.out.println("5: Display all Users");
        System.out.println("6: Remove User");
        System.out.println("7: Display all Complaint");
        System.out.println("8: Get All Feedback By Book Name");
        System.out.println("9: LogOut");
        System.out.println();
    }
    private static void printUserFunctionality() {
        System.out.println();
        System.out.println("Select the functionality which you want to use:");
        System.out.println("1. Display all Books");
        System.out.println("2. Borrow Book");
        System.out.println("3. Get all list Of Borrowed Books");
        System.out.println("4: Get all list of Borrowed Books whose Deadline exceeds");
        System.out.println("5: Search Book by Publications");
        System.out.println("6: File Complain");
        System.out.println("7: See list of all filed Complaints");
        System.out.println("8: Submit Feedback");
        System.out.println("9: LogOut");
        System.out.println();
    }

}
