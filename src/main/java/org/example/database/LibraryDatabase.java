package org.example.database;

import org.example.entity.*;

import java.util.*;

public class LibraryDatabase {

    public static Map<String, User> userList;
    public static Map<String, Book> bookList;
    public static List<Librarian> librarianList;
    public static List<Complaint> complaintList;
    public static List<ReservedBook> reservedBookList;
    public static List<Feedback> feedbackList;

    public static void generateDatabase(){

        userList = new HashMap<>();
        bookList = new HashMap<>();
        librarianList = new ArrayList<>();
        complaintList = new ArrayList<>();
        reservedBookList = new ArrayList<>();
        feedbackList = new ArrayList<>();

        userList.put("1", new User("Sherlock", "1", "serlock"));
        userList.put("2", new User("John", "2", "john"));
        userList.put("3", new User("Jessica", "3", "jessica"));
        userList.put("4", new User("Antonio", "4", "antonio"));
        userList.put("5", new User("Lorenzo", "5", "lorenzo"));
        userList.put("6", new User("Belmont", "6", "belmont"));

        bookList.put("1", new Book("Java Core", "1", "Cay S. Horstmann", "Pearson", true, "Software", null));
        bookList.put("2", new Book("Python Backend", "2", "Gary Cornell", "Sun Microsystems", true, "Devops", null));
        bookList.put("3", new Book("Clean Code", "3", "Robert Martin", "Sage", true, "Software", null));
        bookList.put("4", new Book("Refactoring", "4", "Cay S. Horstmann", "Emerald", true, "CSE", null));
        bookList.put("5", new Book("Merchant Of Venice", "5", "William Shakespeare", "Pearson", true, "Novel", null));

        librarianList.add(new Librarian("1", "Nerissa", "nerissa"));

    }
}
