package com.example.apphandling;

import model.BookModel;
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
public class FavoriteController extends Controller {
    BookModel bookModel = null;

    @GetMapping("/getFav")
    public List<BookModel> get() {
        return generateJsonforFavorites(bookModel);
    }

    public List<BookModel> generateJsonforFavorites(BookModel bookModel) {
        List<BookModel> jsonList = new ArrayList<>();
        Connection connection = ConnecttoDatabase();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM book WHERE book.book_id IN\n" +
                    "(SELECT favorite.book_id FROM favorite WHERE favorite.user_id IN\n" +
                    " (SELECT user_id FROM user WHERE user_username=\'" +
                    this.getUsername() + "\'))");
            while (resultSet.next()) {
                jsonList.add(new BookModel(resultSet.getInt(4), resultSet.getString(1),
                        resultSet.getString(2), resultSet.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jsonList;
    }

    @PostMapping("/addtoFavorites")
    public void posttoAdd(@RequestBody BookModel bookModel) {
        Connection connection = ConnecttoDatabase();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO favorite (book_id, user_id)" +
                    " VALUES ('" + bookModel.getBookid() + "'," +
                    "(SELECT user_id FROM user where user.user_username='" + this.getUsername() + "'))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/removeFav")
    public void posttoRemove(@RequestBody BookModel bookModel) {
        Connection connection = ConnecttoDatabase();
        try {
            Statement statement = connection.createStatement();
            int IdinDatabase = bookModel.getBookid() + 1;
            statement.executeUpdate("DELETE FROM favorite where book_id="
                    + bookModel.getBookid() + "" +
                    " AND user_id=" +
                    "(SELECT user_id FROM  user WHERE user.user_username='" + this.getUsername() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}