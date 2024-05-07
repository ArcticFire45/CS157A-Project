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
public class PostsServiceImplementation {

    @Autowired
    static List<Posts> PokemonPosts = new ArrayList<Posts>();

    Connection connection;

    public PostsServiceImplementation() throws SQLException {
        connection = DBUtil.getConnection();
    }

    public List<Posts> getAllPokemonPosts() {
        try {
            PokemonPosts = new ArrayList<Posts>();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM UserPosts");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Posts post = new Posts(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                PokemonPosts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return PokemonPosts;

    }

    public void createPokemonPost(Posts post) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("INSERT INTO UserPosts (Author, PostDescription, ImageURL) VALUES (?, ?, ?)");
            stmt.setString(1, post.getAuthor());
            stmt.setString(2, post.getPostDesc());
            stmt.setString(3, post.getImageURL());
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

    public void deletePost(int postId, String authorUsername) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "DELETE FROM UserPosts WHERE PostID = ? AND Author = ?;");
            stmt.setInt(1, postId);
            stmt.setString(2, authorUsername);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Post deleted successfully!");
            } else {
                System.out.println("Failed to delete post.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
    
    
