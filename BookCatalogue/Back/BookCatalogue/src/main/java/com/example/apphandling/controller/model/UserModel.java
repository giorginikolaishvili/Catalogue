package com.example.apphandling.controller.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.util.Set;

@Data
@Entity
@Table(name = "user", schema = "bookcatalogue")

public class UserModel {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int userid;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_username")
    private String userName;
    @Column(name = "user_password")
    private String password;

    private Set<BookModel> Books;

    public Set<BookModel> getBooks() {
        return Books;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBooks(Set<BookModel> books) {
        this.Books = books;
    }

    public UserModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserModel() {
    }
}
