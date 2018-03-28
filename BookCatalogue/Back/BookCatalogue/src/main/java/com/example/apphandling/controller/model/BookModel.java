package com.example.apphandling.controller.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "book", schema = "book_database")
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private int bookid;
    @Column(name = "book_name")
    private String name;
    @Column(name = "book_author")
    private String author;
    @Column(name = "book_year")
    private String year;

}