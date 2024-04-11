package org.example.MiddleWare.Controller;

import org.example.MiddleWare.Services.ManagementSystem;
import org.example.MiddleWare.Services.servicesImplementation.ManagementSystemImpl;
import org.example.entity.Book;
import org.example.entity.Librarian;
import org.example.entity.User;

import java.sql.Connection;

public class ManagementSystemController {

    ManagementSystemImpl managementSystem;

    public ManagementSystemController(){
        managementSystem = new ManagementSystemImpl();
    }

    public Boolean logInUser(User user, Connection connection){
        return managementSystem.logInUser(user, connection);
    }
    public Boolean logInLibrarian(Librarian librarian, Connection connection){
        return managementSystem.logInLibrarian(librarian, connection);
    }

    public User getUser(User user, Connection connection){
        return managementSystem.getUser(user, connection);
    }

    public Librarian getLibrarian(Librarian librarian, Connection connection){
        return managementSystem.getLibrarian(librarian, connection);
    }

    public void registerNewUser(User user, Connection connection){
        managementSystem.registerNewUser(user, connection);
    }

}
