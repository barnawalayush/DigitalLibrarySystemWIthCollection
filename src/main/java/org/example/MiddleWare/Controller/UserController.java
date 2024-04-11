package org.example.MiddleWare.Controller;

import org.example.MiddleWare.Services.servicesImplementation.UserServicesImp;
import org.example.entity.*;

import java.sql.Connection;

public class UserController {

    private UserServicesImp userServicesImp;

    public UserController(){
        userServicesImp = new UserServicesImp();
    }

    public void displayBook(Connection connection){
        userServicesImp.displayBooks(connection);
    }

    public void displayBorrowedBook(String userId, Connection connection){
        userServicesImp.displayBorrowedBooks(userId, connection);
    }

    public void displayDeadlineCrossedBook(String userId, Connection connection){
        userServicesImp.displayDeadlineCrossedBook(userId, connection);
    }

    public void borrowBook(String userId, String bookId, Connection connection){
        userServicesImp.BorrowBook(userId, bookId, connection);
    }

    public void RenewBook(User user, ReservedBook book){
        userServicesImp.RenewBook(user, book);
    }

    public void returnBook(User user, ReservedBook book) {
        userServicesImp.returnBook(user, book);
    }

    public void submitFeedback(Feedback feedback, Connection connection) {
        userServicesImp.submitFeedback(feedback, connection);
    }

    public void fileComplaint(Complaint complaint, Connection connection) {
        userServicesImp.fileComplaint(complaint, connection);
    }

    public void searchBookByPublications(String publication, Connection connection){
        userServicesImp.searchBookByPublications(publication, connection);
    }

    public void seeAllComplaint(User user, Connection connection){
        userServicesImp.seeAllComplaint(user, connection);
    }
}
