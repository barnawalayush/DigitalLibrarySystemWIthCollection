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
    public Boolean approveBookBorrowRequest(User user, Book book) {
        return book.getAvailability();
    }

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
//        LibraryDatabase.bookList.add(book);
    }

    @Override
    public void updateBook(Book oldBook, Book newBook) {
        LibraryDatabase.bookList.forEach(book -> {
            if(book.getBookId().equals(oldBook.getBookId())){
                book = newBook;
            }
        });
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

//        Iterator<Book> bookIterator = LibraryDatabase.bookList.iterator();
//        while (bookIterator.hasNext()){
//            Book book = bookIterator.next();
//            if(book.getBookId().equals(bookId)){
//                bookIterator.remove();
//                System.out.println("Book removed Successfully");
//                return;
//            }
//        }
    }

    @Override
    public void displayBook() {
        System.out.println();
        System.out.println("### List of All Books ###");
        System.out.println();
        LibraryDatabase.bookList.forEach(book -> {
            System.out.println(book.getBookId() + " " + book.getBookName() + " " + book.getAuthor()
                    + " " + book.getCategory());
        });
    }

    @Override
    public void getAllFeedback() {

    }

    @Override
    public void getALlComplaintByUserId(User user) {

    }

    @Override
    public void removeUser(User user, Connection connection) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM \"user\" WHERE user_id=?");
            preparedStatement.setString(1, user.getUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        Iterator<User> userIterator = LibraryDatabase.userList.iterator();
//        while (userIterator.hasNext()){
//            User eachUser = userIterator.next();
//            if(eachUser.getUserId().equals(user.getUserId())){
//                userIterator.remove();
//                System.out.println();
//                System.out.println("User removed Successfully!");
//                return;
//            }
//        }
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
        LibraryDatabase.complaintList.stream().forEach(complaint -> {
            System.out.println(complaint.getUser().getName() + "\n" + complaint.getMessage() + "\n" + complaint.getGeneratedAt());
        });
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


//        LibraryDatabase.feedbackList
//                .stream()
//                .filter(feedback -> feedback.getBookId().equals(bookId))
//                .forEach(feedback -> System.out.println(feedback.getMessage()));
    }
}
