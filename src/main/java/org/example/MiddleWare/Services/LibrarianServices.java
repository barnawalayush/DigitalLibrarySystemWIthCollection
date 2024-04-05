package org.example.MiddleWare.Services;

import org.example.entity.Book;
import org.example.entity.User;

public interface LibrarianServices {

    Boolean approveBookBorrowRequest(User user, Book book);
    void addBook(Book book);
    void updateBook(Book oldBook, Book newBook);
    void deleteBookById(String bookId);
    void displayBook();
    void getAllFeedback();
    void getALlComplaintByUserId(User user);
    void removeUser(User user);
    void displayAllUsers();
    void displayAllComplaint();
    void getAllFeedbacksByBookName(String bookId);

}
