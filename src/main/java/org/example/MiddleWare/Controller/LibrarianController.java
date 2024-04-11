package org.example.MiddleWare.Controller;

import org.example.MiddleWare.Services.servicesImplementation.LibrarianServicesImpl;
import org.example.entity.Book;
import org.example.entity.User;

import java.sql.Connection;
import java.util.ConcurrentModificationException;

public class LibrarianController {

    LibrarianServicesImpl librarianServices;

    public LibrarianController(){
        librarianServices = new LibrarianServicesImpl();
    }

    public void displayBooks(){
        librarianServices.displayBook();
    }

    public void displayAllUsers(Connection connection){
        librarianServices.displayAllUsers(connection);
    }

    public Boolean approveBookBorrowedRequest(User user, Book book){
        return librarianServices.approveBookBorrowRequest(user, book);
    }

    public void addBook(Book book, Connection connection){
        librarianServices.addBook(book, connection);
    }

    public void updateBook(Book oldBook, Book newBook){
        librarianServices.updateBook(oldBook, newBook);
    }

    public void getAllFeedback(){
        librarianServices.getAllFeedback();
    }

    public void getALlComplaintByUserId(User user) {
        librarianServices.getALlComplaintByUserId(user);
    }

    public void removeUser(User user, Connection connection){
        librarianServices.removeUser(user, connection);
    }

    public void displayAllComplaint(){
        librarianServices.displayAllComplaint();
    }

    public void deleteBookById(String bookId, Connection connection){
        librarianServices.deleteBookById(bookId, connection);
    }

    public void getAllFeedbacksByBookName(String bookId, Connection connection){
        librarianServices.getAllFeedbacksByBookName(bookId, connection);
    }

}
