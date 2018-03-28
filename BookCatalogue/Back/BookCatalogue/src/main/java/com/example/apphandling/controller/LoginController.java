package com.example.apphandling.controller;

import com.example.apphandling.controller.model.UserModel;
import com.example.apphandling.controller.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
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
    public UserModel login(@RequestBody final UserModel userModel) {
        System.out.println(userModel.getUserName() + "  " + userModel.getPassword());
        UserModel currentUser = this.userRepository.findByuserNameAndPassword(
                userModel.getUserName(), userModel.getPassword()
        );
        System.out.println(currentUser.getUserName() + "       " + currentUser.getPassword());
        boolean b = false;
        if (currentUser.getUserName() != "") {
            b = true;
            this.httpSession.setAttribute("currentUser", currentUser);
            System.out.println(httpSession.getAttribute("currentUser"));
            System.out.println("in if " + b);
            return userModel;

        }
        System.out.println("in else " + b);
        return null;
    }
}


