package com.example.apphandling.controller;

import com.example.apphandling.controller.model.BookModel;
import com.example.apphandling.controller.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
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
    public List<BookModel> getFavorites() {
        UserModel userModel = (UserModel) httpSession.getAttribute("currentUser");
        List<BookModel> bookList = new ArrayList<>(userRepository.findByusername
                (userModel.getUserName()).getBooks());
        return bookList;
    }

    @PostMapping("/addtoFav")
    public void addtoFavorites(@RequestBody BookModel bookModel) {
        UserModel currentUser = (UserModel) httpSession.getAttribute("currentUser");
        UserModel userModel = userRepository.findByusername(currentUser.getUserName());
        Set<BookModel> Books = userModel.getBooks();
        Books.add(bookModel);
    }

    @PostMapping("/removeFav")
    public void removefromFavorites(@RequestBody BookModel bookModel) {
        UserModel currentUser = (UserModel) httpSession.getAttribute("currentUser");
        UserModel userModel = userRepository.findByusername(currentUser.getUserName());
        Set<BookModel> Books = userModel.getBooks();
        Books.remove(bookModel);
    }

    @PostMapping("/onAdd")
    public Boolean isBookinFavorites(@RequestBody BookModel bookModel) {
        UserModel currentUser = (UserModel) httpSession.getAttribute("currentUser");
        UserModel userModel = userRepository.findByusername(currentUser.getUserName());
        Set<BookModel> Books = userModel.getBooks();
        if (Books.contains(bookModel)) {
            return true;
        }
        return false;
    }
    @PostMapping("/onLogout")
    public void logout(){
        this.httpSession.removeAttribute("currentUser");
    }
}
