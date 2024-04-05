package org.example.MiddleWare.Controller;

import org.example.MiddleWare.Services.servicesImplementation.LibrarianServicesImpl;
import org.example.entity.Book;
import org.example.entity.User;

public class LibrarianController {

    LibrarianServicesImpl librarianServices;

    public LibrarianController(){
        librarianServices = new LibrarianServicesImpl();
    }

    public void displayBooks(){
        librarianServices.displayBook();
    }

    public void displayAllUsers(){
        librarianServices.displayAllUsers();
    }

    public Boolean approveBookBorrowedRequest(User user, Book book){
        return librarianServices.approveBookBorrowRequest(user, book);
    }

    public void addBook(Book book){
        librarianServices.addBook(book);
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

    public void removeUser(User user){
        librarianServices.removeUser(user);
    }

    public void displayAllComplaint(){
        librarianServices.displayAllComplaint();
    }

    public void deleteBookById(String bookId){
        librarianServices.deleteBookById(bookId);
    }

    public void getAllFeedbacksByBookName(String bookId){
        librarianServices.getAllFeedbacksByBookName(bookId);
    }

}
