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
<<<<<<< HEAD:src/main/java/com/example/springboot/UserPostsServiceImplementation.java
            userPostsList = new ArrayList<>();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Posts");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                UserPosts post = new UserPosts(rs.getInt("PostID"), rs.getString("description"), rs.getString("image_url"));
                userPostsList.add(post);
=======
            PokemonPosts = new ArrayList<Posts>();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM UserPosts");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Posts post = new Posts(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                PokemonPosts.add(post);
>>>>>>> c5fe15c80e9d3c2cb19d4fc1fcfa2a597a24f16f:src/main/java/com/example/springboot/PostsServiceImplementation.java
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD:src/main/java/com/example/springboot/UserPostsServiceImplementation.java
            return userPostsList;
=======
        return PokemonPosts;
>>>>>>> c5fe15c80e9d3c2cb19d4fc1fcfa2a597a24f16f:src/main/java/com/example/springboot/PostsServiceImplementation.java

    }

    public void createPokemonPost(UserPosts post) {
        try {
<<<<<<< HEAD:src/main/java/com/example/springboot/UserPostsServiceImplementation.java
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO pokemon_posts (post_content, author) VALUES (?, ?)");
            stmt.setString(1, post.getDescription());
            stmt.setString(2, post.getImage_url());
=======
            PreparedStatement stmt = connection
                    .prepareStatement("INSERT INTO UserPosts (Author, PostDescription, ImageURL) VALUES (?, ?, ?)");
            stmt.setString(1, post.getAuthor());
            stmt.setString(2, post.getPostDesc());
            stmt.setString(3, post.getImageURL());
>>>>>>> c5fe15c80e9d3c2cb19d4fc1fcfa2a597a24f16f:src/main/java/com/example/springboot/PostsServiceImplementation.java
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

<<<<<<< HEAD:src/main/java/com/example/springboot/UserPostsServiceImplementation.java
    public void deletePokemonPost(Integer postId) {
        try {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM pokemon_posts WHERE PostID = ?");
            stmt.setInt(1, postId);
            int rs = stmt.executeUpdate();

            if (rs > 0) {
                System.out.println("Pokemon post deleted successfully!");
            } else {
                System.out.println("Failed to delete pokemon post.");
=======
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
>>>>>>> c5fe15c80e9d3c2cb19d4fc1fcfa2a597a24f16f:src/main/java/com/example/springboot/PostsServiceImplementation.java
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD:src/main/java/com/example/springboot/UserPostsServiceImplementation.java
        
    }
=======
    }

>>>>>>> c5fe15c80e9d3c2cb19d4fc1fcfa2a597a24f16f:src/main/java/com/example/springboot/PostsServiceImplementation.java
}
