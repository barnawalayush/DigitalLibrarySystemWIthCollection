package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Librarian {

    private String LibrarianId;
    private String name;
    private String password;


    public Librarian(String name, String password) {
        this.password = password;
        this.name = name;
    }
}
