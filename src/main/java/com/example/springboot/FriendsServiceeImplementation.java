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
//creating implementation for Friends
public class FriendsServiceeImplementation {
    @Autowired
    static List<Friends> friendList = new ArrayList<Friends>();

    Connection connection;

    //constructor method for initializing a connection to the database
    public FriendsServiceeImplementation() throws SQLException {
        connection = DBUtil.getConnection();
    }

    //adds a friendship relation between two users to the database. 
    //inserts a new record into the Friends table with the provided usernames and returns the number of rows affected by the SQL INSERT statement.
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

    //This method removes a friendship relation between two users from the database. 
    //Deletes records from the Friends table where either (Username1 = username1 AND Username2 = username2) or (Username1 = username2 AND Username2 = username1). 
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

    //This method checks if there exists a friendship relation between two users in the database. 
    //executes a SQL SELECT statement to check if there is at least one record in the Friends table matching either (Username1 = username1 AND Username2 = username2) or (Username1 = username2 AND Username2 = username1). 
    //returns true if such a friendship relation exists, otherwise false.
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
