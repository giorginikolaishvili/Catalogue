package com.example.apphandling.controller.repository;

import com.example.apphandling.controller.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookModel,Integer> {
}
