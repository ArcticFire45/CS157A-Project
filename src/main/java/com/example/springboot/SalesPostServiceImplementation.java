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
public class SalesPostServiceImplementation {

    @Autowired
    static List<SalesPost> salesPostsList = new ArrayList<>();

    Connection connection;

    public SalesPostServiceImplementation() throws SQLException {
        connection = DBUtil.getConnection();
    }

    public List<SalesPost> getAllSalesPosts() {
        try {
            salesPostsList = new ArrayList<>();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM SalesPosts");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                SalesPost salesPost = new SalesPost(rs.getInt("SalesID"), rs.getInt("PostID"));
                salesPostsList.add(salesPost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salesPostsList;
    }

    public void createSalesPost(SalesPost salesPost) {
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO SalesPosts (SalesID, PostID) VALUES (?, ?)");
            stmt.setInt(1, salesPost.getSalesID());
            stmt.setInt(2, salesPost.getPostID());
            int rs = stmt.executeUpdate();

            if (rs > 0) {
                System.out.println("Sales post created successfully!");
            } else {
                System.out.println("Failed to create sales post.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    // String query = "";
            
    // connection.setAutoCommit(false);

    // query = "UPDATE users SET money=money-" + String.valueOf(sales.getPrice()) + " WHERE username='" + sales.getPurchaser() + "'; ";
    // connection.prepareStatement(query).executeUpdate();
    // query = "UPDATE users SET money=money+" + String.valueOf(sales.getPrice()) + " WHERE username='" + sales.getSeller() + "'; ";
    // connection.prepareStatement(query).executeUpdate();
    // query = "UPDATE items SET Username='" + sales.getPurchaser() + "' WHERE itemID=" + str_item_id + "; ";
    // connection.prepareStatement(query).executeUpdate();
    // query = "INSERT INTO sales (Seller, Purchaser, Price) VALUES ('" + sales.getSeller() + "', '" + sales.getPurchaser() + "', " + String.valueOf(sales.getPrice()) + "); "; 
    // connection.prepareStatement(query).executeUpdate();
    // query = "INSERT INTO itemSales (salesID, itemID) SELECT MAX(s.salesID)," + str_item_id + " FROM sales s; ";
    // connection.prepareStatement(query).executeUpdate();
    
    // // connection.commit();
    // private Integer postID;
    // private String author;
    // private String postDesc;
    // private String imageURL;
    public Boolean createSalesPostPokemon(Posts post, Sales sale, Integer poke_id) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO UserPosts (Author, PostDescription, ImageURL) VALUES (?, ?, ?)");
            stmt.setString(1, post.getAuthor());
            stmt.setString(2, post.getPostDesc());
            stmt.setString(3, post.getImageURL());
            stmt.executeUpdate();
            stmt = connection.prepareStatement("INSERT INTO sales (Seller, Price) VALUES (?, ?)");
            stmt.setString(1, sale.getSeller());
            stmt.setFloat(2, sale.getPrice());
            stmt.executeUpdate();
            stmt = connection.prepareStatement("INSERT INTO pokemonsales (SalesID, PokemonID) SELECT MAX(s.SalesID), ? FROM sales s");
            stmt.setInt(1, poke_id);
            stmt.executeUpdate();
            stmt = connection.prepareStatement("INSERT INTO SalesPosts (PostID, SalesID) SELECT MAX(p.PostID), MAX(s.SalesID) FROM UserPosts p, sales s");
            stmt.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean createSalesPostItem(Posts post, Sales sale, Integer item_id) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO UserPosts (Author, PostDescription, ImageURL) VALUES (?, ?, ?)");
            stmt.setString(1, post.getAuthor());
            stmt.setString(2, post.getPostDesc());
            stmt.setString(3, post.getImageURL());
            stmt.executeUpdate();
            stmt = connection.prepareStatement("INSERT INTO sales (Seller, Price) VALUES (?, ?)");
            stmt.setString(1, sale.getSeller());
            stmt.setFloat(2, sale.getPrice());
            stmt.executeUpdate();
            stmt = connection.prepareStatement("INSERT INTO itemsales (SalesID, ItemID) SELECT MAX(s.SalesID), ? FROM sales s");
            stmt.setInt(1, item_id);
            stmt.executeUpdate();
            stmt = connection.prepareStatement("INSERT INTO SalesPosts (PostID, SalesID) SELECT MAX(p.PostID), MAX(s.SalesID) FROM UserPosts p, sales s");
            stmt.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }





    public void deleteSalesPost(Integer salesId) {
        try {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM SalesPosts WHERE SalesID = ?");
            stmt.setInt(1, salesId);
            int rs = stmt.executeUpdate();

            if (rs > 0) {
                System.out.println("Sales post deleted successfully!");
            } else {
                System.out.println("Failed to delete sales post.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}