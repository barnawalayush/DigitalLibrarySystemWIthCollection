package org.example.MiddleWare.Services.servicesImplementation;

import org.example.MiddleWare.Services.UserServices;
import org.example.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class UserServicesImp implements UserServices {

    public UserServicesImp(){}

    @Override
    public void displayBooks(Connection connection) {
        System.out.println("### List of ALl Books ###");
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
    public void displayBorrowedBooks(String userId, Connection connection) {
        System.out.println("### List of ALl Books ###");
        System.out.println();

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM reservedbook as r LEFT JOIN book as b " +
                            "ON b.book_id = r.book_id ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString(6)+ " " + resultSet.getString(7)
                        + " " + resultSet.getString(3)
                                + " " + resultSet.getString(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void displayDeadlineCrossedBook(String userId, Connection connection) {
        System.out.println("### List of ALl Books ###");
        System.out.println();

        String currentDate = String.valueOf(LocalDate.now());
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM reservedbook WHERE deadline<?");
            preparedStatement.setString(1, currentDate);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2)
                + " " + resultSet.getString(3) + " " + resultSet.getString(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void BorrowBook(String userId, String bookId, Connection connection) {
        LocalDate currentDate = LocalDate.now();
        LocalDate deadline = currentDate.plusDays(3);

        try {

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO reservedbook VALUES(?,?,?,?)");
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, bookId);
            preparedStatement.setString(3, String.valueOf(currentDate));
            preparedStatement.setString(4, String.valueOf(deadline));
            preparedStatement.executeUpdate();

            String sqlQuery = "UPDATE book SET availabe = false WHERE book_id = " + "'" + bookId + "'";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void RenewBook(User user, ReservedBook book) {

    }

    @Override
    public void returnBook(User user, ReservedBook book) {

    }

    @Override
    public void submitFeedback(Feedback feedback, Connection connection) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO feedback VALUES" +
                    "(?,?,?,?)");
            preparedStatement.setString(1, feedback.getUser().getUserId());
            preparedStatement.setString(2, feedback.getBookId());
            preparedStatement.setString(3, feedback.getMessage());
            preparedStatement.setString(4, String.valueOf(LocalDate.now()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void fileComplaint(Complaint complaint, Connection connection) {

        String currentDate = String.valueOf(LocalDate.now());
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO complaint VALUES(?,?,?)");
            preparedStatement.setString(1, complaint.getUser().getUserId());
            preparedStatement.setString(2, complaint.getMessage());
            preparedStatement.setString(3, currentDate);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void searchBookByPublications(String publication, Connection connection) {
        System.out.println();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM book where publication=?");
            preparedStatement.setString(1, publication);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2)
                             + " " + resultSet.getString(3) + " " + resultSet.getString(4)
                             + " " + resultSet.getString(5) + " " + resultSet.getString(6));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void seeAllComplaint(User user, Connection connection) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM complaint WHERE complainer_id=?");
            preparedStatement.setString(1, user.getUserId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2)
                + " " + resultSet.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
