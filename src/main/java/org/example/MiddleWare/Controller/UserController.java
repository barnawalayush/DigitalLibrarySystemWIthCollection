package org.example.MiddleWare.Controller;

import org.example.MiddleWare.Services.servicesImplementation.UserServicesImp;
import org.example.entity.*;

public class UserController {

    private UserServicesImp userServicesImp;

    public UserController(){
        userServicesImp = new UserServicesImp();
    }

    public void displayBook(){
        userServicesImp.displayBooks();
    }

    public void displayBorrowedBook(User user){
        userServicesImp.displayBorrowedBooks(user);
    }

    public void displayDeadlineCrossedBook(User user){
        userServicesImp.displayDeadlineCrossedBook(user);
    }

    public void borrowBook(User user, Book book){
        userServicesImp.BorrowBook(user, book);
    }

    public void RenewBook(User user, ReservedBook book){
        userServicesImp.RenewBook(user, book);
    }

    public void returnBook(User user, ReservedBook book) {
        userServicesImp.returnBook(user, book);
    }

    public void submitFeedback(Feedback feedback) {
        userServicesImp.submitFeedback(feedback);
    }

    public void fileComplaint(Complaint complaint) {
        userServicesImp.fileComplaint(complaint);
    }

    public void searchBookByPublications(String publication){
        userServicesImp.searchBookByPublications(publication);
    }

    public void seeAllComplaint(User user){
        userServicesImp.seeAllComplaint(user);
    }
}
