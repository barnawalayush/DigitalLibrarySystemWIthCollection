package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Book {

    private String bookName;
    private String bookId;
    private String author;
    private String publication;
    private Boolean availability;
    private String category;
    private User user;

}
