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
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Posts");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Posts post = new Posts(rs.getInt(1), rs.getString(2), rs.getString(3));
                PokemonPosts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return PokemonPosts;

        }

    public void createPokemonPost(Posts post) {
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO pokemon_posts (post_content, author) VALUES (?, ?)");
            stmt.setString(1, post.getPostContent());
            stmt.setString(2, post.getAuthor());
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

}
    
    
