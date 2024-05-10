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
public class SalesServiceImplementation {

    @Autowired
    static List<Sales> salesList = new ArrayList<Sales>();

    Connection connection;

    public SalesServiceImplementation() throws SQLException {
        connection = DBUtil.getConnection();
    }

    public List<Sales> getUserPurchases(String username) {
        ArrayList<Sales> purchaseList = new ArrayList<Sales>();
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("SELECT * FROM sales WHERE purchaser=\'" + username + "\'");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Sales purchase = new Sales(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4));
                purchaseList.add(purchase);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purchaseList;
    }

    public List<Sales> getUserSales(String username) {
        ArrayList<Sales> purchaseList = new ArrayList<Sales>();
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("SELECT * FROM sales WHERE seller=\'" + username + "\'");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Sales purchase = new Sales(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4));
                purchaseList.add(purchase);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purchaseList;
    }

    public boolean addSale(String seller, String purchaser, float price) {
        try {
            String query;
            if (purchaser == null) {
                query = "INSERT INTO sales VALUE (Seller, Price) VALUES ('" + seller + "', " + price;
            } else if (seller == null) {
                query = "INSERT INTO sales VALUE (Purchaser, Price) VALUES ('" + purchaser + "', " + price;
            } else {
                query = "INSERT INTO sales VALUE (Seller, Purchaser, Price) VALUES ('" + seller + "', '" + purchaser
                        + "', " + price;
            }
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<Sales> getUserTransactionHistory(String username) {
        ArrayList<Sales> transactionList = new ArrayList<Sales>();
        transactionList.addAll(getUserPurchases(username));
        transactionList.addAll(getUserSales(username));
        return transactionList;
    }
}
