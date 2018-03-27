package com.example.apphandling.controller;

import com.example.apphandling.controller.model.UserModel;
import com.example.apphandling.controller.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpSession httpSession;

    @PostMapping("/postUser")
    public Boolean login(@RequestBody UserModel userModel) {
            UserModel user= this.userRepository.findByusername(userModel.getUserName());
            if(user !=null && userModel.getPassword().equals(user.getPassword())){
                this.httpSession.setAttribute("currentUser",user);
                return true;
            }
            return null;
        }
    }

