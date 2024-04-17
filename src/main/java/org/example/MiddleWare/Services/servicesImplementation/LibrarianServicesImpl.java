package org.example.MiddleWare.Services.servicesImplementation;

import org.example.MiddleWare.Services.LibrarianServices;
import org.example.database.LibraryDatabase;
import org.example.entity.Book;
import org.example.entity.User;

import java.util.Iterator;
import java.util.Map;

import static org.example.database.LibraryDatabase.bookList;
import static org.example.database.LibraryDatabase.userList;

public class LibrarianServicesImpl implements LibrarianServices {

    public LibrarianServicesImpl(){}

    @Override
    public Boolean approveBookBorrowRequest(User user, Book book) {
        return book.getAvailability();
    }

    @Override
    public void addBook(Book book) {
        bookList.put(book.getBookId(), book);
    }

    @Override
    public void updateBook(Book oldBook, Book newBook) {
        for (Map.Entry<String, Book> entry : bookList.entrySet()) {
            String bookId = entry.getKey();
            Book book = entry.getValue();
            if(book.getBookId().equals(oldBook.getBookId())){
                book = newBook;
            }
        }
    }

    @Override
    public void deleteBookById(String bookId) {
        bookList.remove(bookId);
    }

    @Override
    public void displayBook() {
        System.out.println();
        System.out.println("### List of All Books ###");
        System.out.println();
        for (Map.Entry<String, Book> entry : bookList.entrySet()) {
            String bookId = entry.getKey();
            Book book = entry.getValue();
            System.out.println(book.getBookId() + " " + book.getBookName() + " " + book.getAuthor()
                    + " " + book.getCategory());
        }
    }

    @Override
    public void getAllFeedback() {

    }

    @Override
    public void getALlComplaintByUserId(User user) {

    }

    @Override
    public void removeUser(User user) {
        userList.remove(user.getUserId());
        System.out.println();
        System.out.println("User removed Successfully!");
    }

    @Override
    public void displayAllUsers() {
        for (Map.Entry<String, User> entry : userList.entrySet()) {
            String userId = entry.getKey();
            User eachUser = entry.getValue();
            System.out.println(eachUser.getUserId() + " " + eachUser.getName());
        }
    }

    @Override
    public void displayAllComplaint() {
        LibraryDatabase.complaintList.stream().forEach(complaint -> {
            System.out.println(complaint.getUser().getName() + "\n" + complaint.getMessage() + "\n" + complaint.getGeneratedAt());
        });
    }

    @Override
    public void getAllFeedbacksByBookName(String bookId) {
        LibraryDatabase.feedbackList
                .stream()
                .filter(feedback -> feedback.getBookId().equals(bookId))
                .forEach(feedback -> System.out.println(feedback.getMessage()));
    }
}
