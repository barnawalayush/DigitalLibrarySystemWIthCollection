package org.example.MiddleWare.Services.servicesImplementation;

import org.example.MiddleWare.Services.ManagementSystem;
import org.example.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagementSystemImpl implements ManagementSystem {

    public ManagementSystemImpl(){
    }

    @Override
    public Boolean logInUser(User user, Connection connection) {

        boolean hasUser = false;

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM \"user\" WHERE user_name=? AND user_password=?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                hasUser = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return hasUser;

//        for(User eachUser: LibraryDatabase.userList){
//            if(eachUser.getName().equals(user.getName()) && eachUser.getPassword().equals(user.getPassword())){
//                return true;
//            }
//        }
//        return false;
    }

    @Override
    public Boolean logInLibrarian(Librarian librarian, Connection connection) {

        boolean hasLibrarian = false;

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM librarian " +
                            "WHERE librarian_name=? AND librarian_password=?");
            preparedStatement.setString(1, librarian.getName());
            preparedStatement.setString(2, librarian.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                hasLibrarian = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return hasLibrarian;

//        for(Librarian eachLibrarian: LibraryDatabase.librarianList){
//            if(eachLibrarian.getName().equals(librarian.getName()) && eachLibrarian.getPassword().equals(librarian.getPassword())){
//                return true;
//            }
//        }
//        return false;
    }

    @Override
    public void logOut(User user) {

    }

    @Override
    public void registerNewUser(User user) {

    }

    @Override
    public User getUser(User user, Connection connection) {

        User newUser = new User();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection
                    .prepareStatement("SELECT * FROM \"user\" WHERE user_name=? AND user_password=?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                newUser.setUserId(resultSet.getString(1));
                newUser.setName(resultSet.getString(2));
                newUser.setPassword(resultSet.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newUser;
//        return LibraryDatabase.userList.stream().filter(eachUser -> eachUser.getName().equals(user.getName())
//                && eachUser.getPassword().equals(user.getPassword())).findFirst().get();
    }

    @Override
    public Librarian getLibrarian(Librarian librarian, Connection connection) {

        Librarian newLibrarian = new Librarian();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection
                    .prepareStatement("SELECT * FROM librarian WHERE librarian_name=? AND librarian_password=?");
            preparedStatement.setString(1, librarian.getName());
            preparedStatement.setString(2, librarian.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                newLibrarian.setLibrarianId(resultSet.getString(1));
                newLibrarian.setName(resultSet.getString(2));
                newLibrarian.setPassword(resultSet.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newLibrarian;

//        return LibraryDatabase.librarianList.stream().filter(eachLibrarian ->
//                eachLibrarian.getName().equals(librarian.getName())
//                        && eachLibrarian.getPassword().equals(librarian.getPassword())).findFirst().get();
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
