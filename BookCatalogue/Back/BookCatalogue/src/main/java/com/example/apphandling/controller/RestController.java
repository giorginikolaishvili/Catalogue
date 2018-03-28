package com.example.apphandling.controller;

import com.example.apphandling.controller.model.BookModel;
import com.example.apphandling.controller.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.example.apphandling.controller.repository.BookRepository;
import com.example.apphandling.controller.repository.UserRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Order(Ordered.HIGHEST_PRECEDENCE)
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/getBook")
    public List<BookModel> getBooks() {
        return this.bookRepository.findAll();
    }

    @GetMapping("/getFav")
    public void getFavorites() {
        System.out.println(this.httpSession.getAttribute("currentUser"));
        UserModel userModel = (UserModel) this.httpSession.getAttribute("currentUser");
       // System.out.println(userModel.getUserName());
       // List<BookModel> bookList = new ArrayList<>(this.userRepository.findByuserNameAndPassword
      //          (userModel.getUserName(), userModel.getPassword()).getBooks());
      //  System.out.println(bookList);
       // return bookList;
    }

    @PostMapping("/addtoFav")
    public void addtoFavorites(@RequestBody BookModel bookModel) {
        UserModel currentUser = (UserModel) httpSession.getAttribute("currentUser");
        UserModel userModel = userRepository.findByuserNameAndPassword
                (currentUser.getUserName(), currentUser.getPassword());
         userModel.getBooks().add(bookModel);
    }

    @PostMapping("/removeFav")
    public void removefromFavorites(@RequestBody BookModel bookModel) {
        UserModel currentUser = (UserModel) httpSession.getAttribute("currentUser");
        UserModel userModel = userRepository.findByuserNameAndPassword
                (currentUser.getUserName(), currentUser.getPassword());
        userModel.getBooks().remove(bookModel);
    }

    @PostMapping("/onAdd")
    public Boolean isBookinFavorites(@RequestBody BookModel bookModel) {
        UserModel currentUser = (UserModel) httpSession.getAttribute("currentUser");
        UserModel userModel = userRepository.findByuserNameAndPassword
                (currentUser.getUserName(), currentUser.getPassword());
        Set<BookModel> Books = userModel.getBooks();
        if (Books.contains(bookModel)) {
            return true;
        }
        return false;
    }

    @PostMapping("/onLogout")
    public void logout() {
        this.httpSession.removeAttribute("currentUser");
    }
}
