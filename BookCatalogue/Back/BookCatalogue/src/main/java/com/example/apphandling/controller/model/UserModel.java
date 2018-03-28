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
    @Column(name = "user_lastname")
    private String lastName;
    @Column(name = "user_username")
    private String userName;
    @Column(name = "user_password")
    private String password;
    @ManyToMany
    @JoinTable(
            name = "user_book",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )

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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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


}
