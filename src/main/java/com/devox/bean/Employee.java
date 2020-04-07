package com.devox.bean;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Document(collection = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Employee {
    @MongoId
    private int id;
    private String firstName;
    private String lastName;
    private String email;

}

