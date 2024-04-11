package org.example.MiddleWare.Services;

import org.example.entity.Book;
import org.example.entity.Complaint;
import org.example.entity.User;

import java.sql.Connection;

public interface LibrarianServices {

    Boolean approveBookBorrowRequest(User user, Book book);
    void addBook(Book book, Connection connection);
    void updateBook(Book oldBook, Book newBook);
    void deleteBookById(String bookId, Connection connection);
    void displayBook();
    void getAllFeedback();
    void getALlComplaintByUserId(User user);
    void removeUser(User user, Connection connection);
    void displayAllUsers(Connection connection);
    void displayAllComplaint();
    void getAllFeedbacksByBookName(String bookId, Connection connection);

}
