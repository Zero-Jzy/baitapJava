package model;

import entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserModel {

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/javafx?user=root&password=");
        } catch (SQLException e) {
            System.out.println("SQLException " + e.getMessage());

        } catch (ClassNotFoundException e) {
            System.err.println("Errors: " + e.getMessage());
        }
    }

    public boolean register(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into User (name, username, password, email, phone) values (?,?,?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.execute();

            return true;
        } catch (SQLException e) {
            System.err.println("Errors: " + e.getMessage());
            return false;
        }
    }
}
