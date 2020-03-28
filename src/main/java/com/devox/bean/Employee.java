package com.devox.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @MongoId
    private int id;
    private String firstName;
    private String lastName;
    private String email;
}

