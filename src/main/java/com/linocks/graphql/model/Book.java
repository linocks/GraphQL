package com.linocks.graphql.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String isbn;
    private String author;

    public Book(String title, String isbn, String author){
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

}
