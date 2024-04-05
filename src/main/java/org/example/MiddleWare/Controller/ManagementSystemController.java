package org.example.MiddleWare.Services.Controller;

import org.example.MiddleWare.Services.ManagementSystem;
import org.example.MiddleWare.Services.servicesImplementation.ManagementSystemImpl;
import org.example.entity.Book;
import org.example.entity.Librarian;
import org.example.entity.User;

public class ManagementSystemController {

    ManagementSystemImpl managementSystem;

    public ManagementSystemController(){
        managementSystem = new ManagementSystemImpl();
    }

    public Boolean logInUser(User user){
        return managementSystem.logInUser(user);
    }
    public Boolean logInLibrarian(Librarian librarian){
        return managementSystem.logInLibrarian(librarian);
    }

    public User getUser(User user){
        return managementSystem.getUser(user);
    }

    public Librarian getLibrarian(Librarian librarian){
        return managementSystem.getLibrarian(librarian);
    }

    public Book getBookById(String bookId){
        return managementSystem.getBookById(bookId);
    }

    public User getUserById(String userId){
        return managementSystem.getUserById(userId);
    }
}
