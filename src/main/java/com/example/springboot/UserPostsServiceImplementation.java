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
public class UserPostsServiceImplementation {

    @Autowired
    static List<UserPosts> userPostsList = new ArrayList<UserPosts>();

    Connection connection;

    public UserPostsServiceImplementation() throws SQLException {
        connection = DBUtil.getConnection();
    }

    public List<UserPosts> getAllUserPosts() {
        try {
            userPostsList = new ArrayList<>();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Posts");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                UserPosts post = new UserPosts(rs.getInt("PostID"), rs.getString("description"), rs.getString("image_url"));
                userPostsList.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return userPostsList;

        }

    public void createPokemonPost(UserPosts post) {
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO pokemon_posts (post_content, author) VALUES (?, ?)");
            stmt.setString(1, post.getDescription());
            stmt.setString(2, post.getImage_url());
            int rs = stmt.executeUpdate();

            if (rs > 0) {
                System.out.println("Pokemon post created successfully!");
            } else {
                System.out.println("Failed to create pokemon post.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePokemonPost(Integer postId) {
        try {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM pokemon_posts WHERE PostID = ?");
            stmt.setInt(1, postId);
            int rs = stmt.executeUpdate();

            if (rs > 0) {
                System.out.println("Pokemon post deleted successfully!");
            } else {
                System.out.println("Failed to delete pokemon post.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
    
    
