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
public class Complaint {

    private User user;
    private String message;
    private LocalDate generatedAt;
}
