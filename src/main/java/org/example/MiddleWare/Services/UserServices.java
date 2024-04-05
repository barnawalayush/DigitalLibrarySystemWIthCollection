package org.example.MiddleWare.Services;

import org.example.entity.*;

import java.util.List;

public interface UserServices {

    void displayBooks();

    void displayBorrowedBooks(User user);

    void displayDeadlineCrossedBook(User user);

    void BorrowBook(User user, Book book);

    void RenewBook(User user, ReservedBook book);

    void returnBook(User user, ReservedBook book);

    void submitFeedback(Feedback feedback);

    void fileComplaint(Complaint complaint);
    void searchBookByPublications(String publication);
    void seeAllComplaint(User user);

}
