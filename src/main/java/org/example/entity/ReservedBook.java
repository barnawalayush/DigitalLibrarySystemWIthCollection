package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ReservedBook {

    private Book book;
    private User user;
    private LocalDate borrowedAt;
    private LocalDate deadline;

    public ReservedBook(User user, Book book, LocalDate borrowedAt, LocalDate deadline) {
        this.user = user;
        this.book = book;
        this.borrowedAt = borrowedAt;
        this.deadline = deadline;
    }


}
