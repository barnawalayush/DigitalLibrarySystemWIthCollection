package org.example.MiddleWare.Services.servicesImplementation;

import org.example.MiddleWare.Services.UserServices;
import org.example.database.LibraryDatabase;
import org.example.entity.*;

import java.time.LocalDate;
import java.util.Map;

import static org.example.database.LibraryDatabase.bookList;

public class UserServicesImp implements UserServices {

    public UserServicesImp(){}

    @Override
    public void displayBooks() {
        System.out.println("### List of ALl Books ###");
        System.out.println();
        for (Map.Entry<String, Book> entry : bookList.entrySet()) {
            String bookId = entry.getKey();
            Book book = entry.getValue();
            System.out.println(book.getBookId() + " " + book.getBookName() + " " + book.getAuthor()
                    + " " + book.getCategory());
        }
    }

    @Override
    public void displayBorrowedBooks(User user) {
        System.out.println("### List of ALl Books ###");
        System.out.println();
        LibraryDatabase.reservedBookList.forEach(book -> {
            if(book.getUser().getUserId().equals(user.getUserId())){
                System.out.println(book.getBook().getBookName() + " " + book.getBorrowedAt()
                        + " " + book.getDeadline());
            }
        });
    }

    @Override
    public void displayDeadlineCrossedBook(User user) {
        System.out.println("### List of ALl Books ###");
        System.out.println();
        LibraryDatabase.reservedBookList.forEach(book -> {
            if(book.getUser().getUserId().equals(user.getUserId())
                    && (book.getDeadline().compareTo(LocalDate.now()) > 0)){
                System.out.println(book.getBook().getBookName() + " " + book.getBorrowedAt()
                        + " " + book.getDeadline());
            }
        });
    }

    @Override
    public void BorrowBook(User user, Book book) {
        LocalDate currentDate = LocalDate.now();
        ReservedBook reservedBook = new ReservedBook(user, book, currentDate, currentDate.plusDays(1));

        Book bookToBorrow = bookList.get(book.getBookId());
        bookToBorrow.setAvailability(false);
        bookToBorrow.setUser(user);

        LibraryDatabase.reservedBookList.add(reservedBook);
    }

    @Override
    public void RenewBook(User user, ReservedBook book) {

    }

    @Override
    public void returnBook(User user, ReservedBook book) {

    }

    @Override
    public void submitFeedback(Feedback feedback) {
        LibraryDatabase.feedbackList.add(feedback);
    }

    @Override
    public void fileComplaint(Complaint complaint) {
        LibraryDatabase.complaintList.add(complaint);
    }

    @Override
    public void searchBookByPublications(String publication) {
        System.out.println();
        for (Map.Entry<String, Book> entry : bookList.entrySet()) {
            String bookId = entry.getKey();
            Book book = entry.getValue();
            if(book.getPublication().equalsIgnoreCase(publication)){
                System.out.println(book.getBookId() + " " + book.getBookName()
                        + " " + book.getPublication());
            }
        }
    }

    @Override
    public void seeAllComplaint(User user) {
        LibraryDatabase.complaintList.stream()
                .filter(complaint -> complaint.getUser().getUserId().equals(user.getUserId()))
                .forEach(complaint -> System.out.println(complaint.getMessage()
                        + "\n" + complaint.getGeneratedAt() + "\n"));
    }
}
