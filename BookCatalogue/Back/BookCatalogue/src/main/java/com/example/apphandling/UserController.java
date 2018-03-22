package com.example.apphandling;

import model.BookModel;
import model.ResultModel;
import model.UserModel;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Order(Ordered.HIGHEST_PRECEDENCE)
@RequestMapping("/api")
@RestController
public class UserController extends Controller {
    UserModel userModel1 = null;
    ResultModel resultModel = null;

    @PostMapping("/postUser")
    public ResultModel post(@RequestBody UserModel userModel) {
        this.setUsername(userModel.getUserName());
        System.out.println(this.getUsername());
        ConnecttoDatabase();
        userModel1 = userModel;
        resultModel = authentication();
        return resultModel;
    }

    public ResultModel authentication() {
        Connection connection = ConnecttoDatabase();
        ResultModel Result = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
            while (resultSet.next()) {
                if (resultSet.getString(3).equals(userModel1.getUserName()) &&
                        resultSet.getString(4).equals(userModel1.getPassword())) {
                    Result = new ResultModel("Welcome " + resultSet.getString(3) + " !");
                } else {
                    Result = new ResultModel("Invalid Username or Password");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result;
    }
}