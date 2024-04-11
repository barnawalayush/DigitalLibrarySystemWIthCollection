package org.example.MiddleWare.Services;

import org.example.entity.*;

import java.sql.Connection;
import java.util.List;

public interface UserServices {

    void displayBooks(Connection connection);

    void displayBorrowedBooks(String userId, Connection connection);

    void displayDeadlineCrossedBook(String userId, Connection connection);

    void BorrowBook(String userId, String bookId, Connection connection);

    void RenewBook(User user, ReservedBook book);

    void returnBook(User user, ReservedBook book);

    void submitFeedback(Feedback feedback, Connection connection);

    void fileComplaint(Complaint complaint, Connection connection);
    void searchBookByPublications(String publication, Connection connection);
    void seeAllComplaint(User user, Connection connection);

}
