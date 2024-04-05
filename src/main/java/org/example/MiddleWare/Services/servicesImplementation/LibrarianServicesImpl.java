package org.example.MiddleWare.Services.servicesImplementation;

import org.example.MiddleWare.Services.LibrarianServices;
import org.example.database.LibraryDatabase;
import org.example.entity.Book;
import org.example.entity.User;

import java.util.Iterator;

public class LibrarianServicesImpl implements LibrarianServices {

    public LibrarianServicesImpl(){}

    @Override
    public Boolean approveBookBorrowRequest(User user, Book book) {
        return book.getAvailability();
    }

    @Override
    public void addBook(Book book) {
        LibraryDatabase.bookList.add(book);
    }

    @Override
    public void updateBook(Book oldBook, Book newBook) {
        LibraryDatabase.bookList.forEach(book -> {
            if(book.getBookId().equals(oldBook.getBookId())){
                book = newBook;
            }
        });
    }

    @Override
    public void deleteBookById(String bookId) {
//        LibraryDatabase.bookList.forEach(eachBook -> {
//            if(eachBook.getBookId().equals(bookId)){
//                LibraryDatabase.bookList.remove(eachBook);
//            }
//        });
        Iterator<Book> bookIterator = LibraryDatabase.bookList.iterator();
        while (bookIterator.hasNext()){
            Book book = bookIterator.next();
            if(book.getBookId().equals(bookId)){
                bookIterator.remove();
                System.out.println("Book removed Successfully");
                return;
            }
        }
    }

    @Override
    public void displayBook() {
        System.out.println();
        System.out.println("### List of All Books ###");
        System.out.println();
        LibraryDatabase.bookList.forEach(book -> {
            System.out.println(book.getBookId() + " " + book.getBookName() + " " + book.getAuthor()
                    + " " + book.getCategory());
        });
    }

    @Override
    public void getAllFeedback() {

    }

    @Override
    public void getALlComplaintByUserId(User user) {

    }

    @Override
    public void removeUser(User user) {
        Iterator<User> userIterator = LibraryDatabase.userList.iterator();
        while (userIterator.hasNext()){
            User eachUser = userIterator.next();
            if(eachUser.getUserId().equals(user.getUserId())){
                userIterator.remove();
                System.out.println();
                System.out.println("User removed Successfully!");
                return;
            }
        }
    }

    @Override
    public void displayAllUsers() {
        LibraryDatabase.userList.forEach(user -> {
            System.out.println(user.getUserId() + " " + user.getName());
        });
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
