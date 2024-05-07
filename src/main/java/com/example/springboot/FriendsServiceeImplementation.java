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
public class FriendsServiceeImplementation {
    @Autowired
    static List<Friends> friendList = new ArrayList<Friends>();

    Connection connection;

    public FriendsServiceeImplementation() throws SQLException {
        connection = DBUtil.getConnection();
    }

    public int addFriend(String username1, String username2) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("INSERT INTO Friends (Username1, Username2) VALUES (?, ?)");
            stmt.setString(1, username1);
            stmt.setString(2, username2);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void removeFriend(String username1, String username2) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement(
                            "DELETE FROM Friends WHERE (Username1 = ? AND Username2 = ?) OR (Username1 = ? AND Username2 = ?)");
            stmt.setString(1, username1);
            stmt.setString(2, username2);
            stmt.setString(3, username2);
            stmt.setString(4, username1);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkFriendship(String username1, String username2) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT EXISTS (SELECT 1 FROM Friends WHERE (Username1 = ? AND Username2 = ?) OR (Username1 = ? AND Username2 = ?))");
            stmt.setString(1, username1);
            stmt.setString(2, username2);
            stmt.setString(3, username2);
            stmt.setString(4, username1);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getBoolean(1);
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
