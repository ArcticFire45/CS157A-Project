
package com.example.springboot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertSaleItemServiceImplementation {

    @Autowired
    Connection connection;

    public InsertSaleItemServiceImplementation() throws SQLException {
        connection = DBUtil.getConnection();
    }

    public InsertSaleItem insertSaleItem(InsertSaleItem saleItem) throws SQLException {
        try {
            // Start transaction
            connection.setAutoCommit(false);

            // Insert sale item
            String insertSaleItemQuery = "INSERT INTO SaleItem (SaleID, PostID) VALUES (?, ?)";
            PreparedStatement insertSaleItemStmt = connection.prepareStatement(insertSaleItemQuery,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            insertSaleItemStmt.setInt(1, saleItem.getSaleID());
            insertSaleItemStmt.setInt(2, saleItem.getPostID());
            insertSaleItemStmt.executeUpdate();

            // Get generated sale item ID
            ResultSet generatedKeys = insertSaleItemStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int saleItemID = generatedKeys.getInt(1);

                // Insert into PokemonSale or ItemSale based on itemType
                String insertItemSaleQuery = "";
                if (saleItem.getItemType().equalsIgnoreCase("pokemon")) {
                    insertItemSaleQuery = "INSERT INTO PokemonSale (SaleID, PokemonID) VALUES (?, ?)";
                } else if (saleItem.getItemType().equalsIgnoreCase("item")) {
                    insertItemSaleQuery = "INSERT INTO ItemSale (SaleID, ItemID) VALUES (?, ?)";
                } else {
                    throw new SQLException("Invalid item type.");
                }

                PreparedStatement insertItemSaleStmt = connection.prepareStatement(insertItemSaleQuery);
                insertItemSaleStmt.setInt(1, saleItem.getSaleID());
                insertItemSaleStmt.setInt(2, saleItem.getItemId());
                insertItemSaleStmt.executeUpdate();

                // Commit transaction
                connection.commit();

                // Return the sale item with ID
                return new InsertSaleItem(saleItemID, saleItem.getPostID(), saleItem.getItemType(), saleItem.getItemId());
            } else {
                // Rollback transaction if no ID was generated
                connection.rollback();
                throw new SQLException("Failed to get generated sale item ID.");
            }
        } catch (SQLException e) {
            // Rollback transaction in case of exception
            connection.rollback();
            throw e;
        } finally {
            // Reset auto-commit
            connection.setAutoCommit(true);
        }
    }
}