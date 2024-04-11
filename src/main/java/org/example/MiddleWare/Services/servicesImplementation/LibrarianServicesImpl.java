package org.example.MiddleWare.Services.servicesImplementation;

import org.example.MiddleWare.Services.LibrarianServices;
import org.example.entity.Book;
import org.example.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibrarianServicesImpl implements LibrarianServices {

    public LibrarianServicesImpl(){}

    @Override
    public void addBook(Book book, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO book VALUES(?,?,?,?,?,?)");
            preparedStatement.setString(1, book.getBookId());
            preparedStatement.setString(2, book.getBookName());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setString(4, book.getPublication());
            preparedStatement.setBoolean(5, book.getAvailability());
            preparedStatement.setString(6, book.getCategory());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateBook(Book oldBook, Book newBook) {
    }

    @Override
    public void deleteBookById(String bookId, Connection connection) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM book WHERE book_id=?");
            preparedStatement.setString(1, bookId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void displayBook(Connection connection) {
        System.out.println();
        System.out.println("### List of All Books ###");
        System.out.println();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM book");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2)
                        + " " + resultSet.getString(3) + " " + resultSet.getString(4)
                        + " " + resultSet.getString(5)+ " " + resultSet.getString(6));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getAllFeedback() {

    }

    @Override
    public void getALlComplaintByUserId(User user) {

    }

    @Override
    public void removeUser(String userId, Connection connection) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM \"user\" WHERE user_id=?");
            preparedStatement.setString(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void displayAllUsers(Connection connection) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM \"user\" ORDER BY user_id");
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(1)+" "+rs.getString(2) + " " + rs.getString(3));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

        @Override
    public void displayAllComplaint() {
    }

    @Override
    public void getAllFeedbacksByBookName(String bookId, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM feedback where book_id=?");
            preparedStatement.setString(1, bookId);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(1)+" "+rs.getString(2) + " "
                        + rs.getString(3) + " " + rs.getString(4));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
