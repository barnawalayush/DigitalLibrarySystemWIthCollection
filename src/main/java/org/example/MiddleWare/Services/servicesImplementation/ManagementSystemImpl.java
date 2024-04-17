package org.example.MiddleWare.Services.servicesImplementation;

import org.example.MiddleWare.Services.ManagementSystem;
import org.example.database.LibraryDatabase;
import org.example.entity.Book;
import org.example.entity.Librarian;
import org.example.entity.User;

import java.util.Map;

import static org.example.database.LibraryDatabase.bookList;
import static org.example.database.LibraryDatabase.userList;

public class ManagementSystemImpl implements ManagementSystem {

    public ManagementSystemImpl(){
    }

    @Override
    public Boolean logInUser(User user) {
        for (Map.Entry<String, User> entry : userList.entrySet()) {
            String userId = entry.getKey();
            User eachUser = entry.getValue();
            if(eachUser.getName().equals(user.getName()) && eachUser.getPassword().equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean logInLibrarian(Librarian librarian) {
        for(Librarian eachLibrarian: LibraryDatabase.librarianList){
            if(eachLibrarian.getName().equals(librarian.getName()) && eachLibrarian.getPassword().equals(librarian.getPassword())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void logOut(User user) {

    }

    @Override
    public void registerNewUser(User user) {

    }

    @Override
    public User getUser(User user) {
        for (Map.Entry<String, User> entry : userList.entrySet()) {
            String userId = entry.getKey();
            User eachUser = entry.getValue();
            if(eachUser.getName().equals(user.getName()) && eachUser.getPassword().equals(user.getPassword())){
                return eachUser;
            }
        }
        return null;
    }

    @Override
    public Librarian getLibrarian(Librarian librarian) {
        return LibraryDatabase.librarianList.stream().filter(eachLibrarian ->
                eachLibrarian.getName().equals(librarian.getName())
                        && eachLibrarian.getPassword().equals(librarian.getPassword())).findFirst().get();
    }

    @Override
    public Book getBookById(String bookId) {
        return bookList.get(bookId);
    }

    @Override
    public User getUserById(String userId) {
        return userList.get(userId);
    }


}
