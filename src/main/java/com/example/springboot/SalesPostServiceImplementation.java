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