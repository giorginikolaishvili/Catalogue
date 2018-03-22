package com.example.apphandling;

import model.BookModel;
import org.springframework.boot.autoconfigure.session.JdbcSessionDataSourceInitializer;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.awt.print.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Order(Ordered.HIGHEST_PRECEDENCE)
@RequestMapping("/api")
@RestController
public class BookController extends Controller {
    BookModel bookModel = null;

    @GetMapping("/getBook")
    public List<BookModel> get() {
        return generateJsonforBooks(bookModel);
    }

    public List<BookModel> generateJsonforBooks(BookModel bookModel) {
        Connection connection = ConnecttoDatabase();
        List<BookModel> jsonList = new ArrayList<>();
        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM book");
            while (resultSet.next()) {
                jsonList.add(new BookModel(resultSet.getInt(4), resultSet.getString(1),
                        resultSet.getString(2), resultSet.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jsonList;
    }
}
