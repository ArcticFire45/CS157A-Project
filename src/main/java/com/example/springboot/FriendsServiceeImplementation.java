package com.example.springboot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendsServiceeImplementation {
    @Autowired
    static List<Friends> friendList = new ArrayList<Friends>();

    Connection connection;

    public FriendsServiceeImplementation() throws SQLException {
        connection = DBUtil.getConnection();
    }

    public int addFriend(String username1, String username2) {
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO Friends (Username1, Username2) VALUES (?, ?)");
            stmt.setString(1, username1);
            stmt.setString(2, username2);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
