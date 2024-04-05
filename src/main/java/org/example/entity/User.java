package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User {

    private String name;
    private String userId;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
