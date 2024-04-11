package org.example.MiddleWare.Services;

import org.example.entity.Book;
import org.example.entity.Librarian;
import org.example.entity.User;

import java.sql.Connection;

public interface ManagementSystem {

    Boolean logInUser(User user, Connection connection);

    Boolean logInLibrarian(Librarian librarian, Connection connection);

    void logOut(User user);

    void registerNewUser(User user);

    User getUser(User user, Connection connection);

    Librarian getLibrarian(Librarian librarian, Connection connection);

    Book getBookById(String bookId);

    User getUserById(String userId);

}
