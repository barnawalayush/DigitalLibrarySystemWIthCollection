package org.example.MiddleWare.Services;

import org.example.entity.Book;
import org.example.entity.Librarian;
import org.example.entity.User;

public interface ManagementSystem {

    Boolean logInUser(User user);

    Boolean logInLibrarian(Librarian librarian);

    void logOut(User user);

    void registerNewUser(User user);

    User getUser(User user);

    Librarian getLibrarian(Librarian librarian);

    Book getBookById(String bookId);

    User getUserById(String userId);

}
