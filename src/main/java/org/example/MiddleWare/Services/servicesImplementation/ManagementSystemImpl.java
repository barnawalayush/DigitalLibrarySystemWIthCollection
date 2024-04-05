package org.example.MiddleWare.Services.servicesImplementation;

import org.example.MiddleWare.Services.ManagementSystem;
import org.example.database.LibraryDatabase;
import org.example.entity.Book;
import org.example.entity.Librarian;
import org.example.entity.User;

public class ManagementSystemImpl implements ManagementSystem {

    public ManagementSystemImpl(){
    }

    @Override
    public Boolean logInUser(User user) {
        for(User eachUser: LibraryDatabase.userList){
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
        return LibraryDatabase.userList.stream().filter(eachUser -> eachUser.getName().equals(user.getName())
                && eachUser.getPassword().equals(user.getPassword())).findFirst().get();
    }

    @Override
    public Librarian getLibrarian(Librarian librarian) {
        return LibraryDatabase.librarianList.stream().filter(eachLibrarian ->
                eachLibrarian.getName().equals(librarian.getName())
                        && eachLibrarian.getPassword().equals(librarian.getPassword())).findFirst().get();
    }

    @Override
    public Book getBookById(String bookId) {
        return LibraryDatabase.bookList.stream().filter(book -> book.getBookId().equals(bookId)).findFirst().get();
    }

    @Override
    public User getUserById(String userId) {
        return LibraryDatabase.userList.stream()
                .filter(eachUser -> eachUser.getUserId().equals(userId))
                .findFirst()
                .get();
    }


}
