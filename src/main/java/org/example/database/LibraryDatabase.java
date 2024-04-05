package org.example.database;

import org.example.entity.*;

import java.util.ArrayList;
import java.util.List;

public class LibraryDatabase {

    public static List<User> userList;
    public static List<Book> bookList;
    public static List<Librarian> librarianList;
    public static List<Complaint> complaintList;
    public static List<ReservedBook> reservedBookList;
    public static List<Feedback> feedbackList;

    public static void generateDatabase(){

        userList = new ArrayList<>();
        bookList = new ArrayList<>();
        librarianList = new ArrayList<>();
        complaintList = new ArrayList<>();
        reservedBookList = new ArrayList<>();
        feedbackList = new ArrayList<>();

        userList.add(new User("Sherlock", "1", "serlock"));
        userList.add(new User("John", "2", "john"));
        userList.add(new User("Jessica", "3", "jessica"));
        userList.add(new User("Antonio", "4", "antonio"));
        userList.add(new User("Lorenzo", "5", "lorenzo"));
        userList.add(new User("Belmont", "6", "belmont"));

        bookList.add(new Book("Java Core", "1", "Cay S. Horstmann", "Pearson", true, "Software", null));
        bookList.add(new Book("Python Backend", "2", "Gary Cornell", "Sun Microsystems", true, "Devops", null));
        bookList.add(new Book("Clean Code", "3", "Robert Martin", "Sage", true, "Software", null));
        bookList.add(new Book("Refactoring", "4", "Cay S. Horstmann", "Emerald", true, "CSE", null));
        bookList.add(new Book("Merchant Of Venice", "5", "William Shakespeare", "Pearson", true, "Novel", null));

        librarianList.add(new Librarian("1", "Nerissa", "nerissa"));

    }
}
