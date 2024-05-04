package com.example.springboot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation {

    @Autowired
    static List<User> userList = new ArrayList<User>();

    Connection connection;

    public UserServiceImplementation() throws SQLException {
        connection = DBUtil.getConnection();
    }

    public void addUser(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        int money = user.getMoney();

        String insertQuery = "INSERT INTO Users Values('"+username+"','"+password+"',"+money+");";

        try {
            PreparedStatement stmt = connection
                    .prepareStatement(insertQuery);
            stmt.executeUpdate();
            System.out.println("User added successfully!");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean loginUser(String username, String password) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT User_Password FROM Users WHERE Username = '"+username+"'");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String db_password = rs.getString("User_Password");
                return db_password.equals(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUserFrom(String username) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Users WHERE Username = '"+username+"'");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                return new User(rs.getString(1), rs.getString(2), rs.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
