package com.rishit.todo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Document
@Data
public class Todo {

    //primary key
    @Id
    private ObjectId id;
    private String title;
    private String description;
    private LocalDate date;

}
