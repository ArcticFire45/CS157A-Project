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
public class ItemSalesServiceImplementation {

    @Autowired
    static List<ItemSales> itemSalesList = new ArrayList<ItemSales>();
    Connection connection;

    public ItemSalesServiceImplementation() throws SQLException {
        connection = DBUtil.getConnection();
    }



    
    public ItemSales getItemSale(String sale_id)
    {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("SELECT * FROM ItemSales WHERE SalesID=" + sale_id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            ItemSales item_sale = new ItemSales(rs.getInt(1), rs.getInt(2));
            return item_sale;
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }   

    public List<ItemSales> getUserItemSales(String item_id)
    {
        itemSalesList = new ArrayList<ItemSales>();  
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("SELECT * FROM ItemSales WHERE itemID=" + item_id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                ItemSales item = new ItemSales(rs.getInt(1), rs.getInt(3));
                itemSalesList.add(item);                    
            }
            return itemSalesList;
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }   


    
    public Boolean addItemSale(String sales_id, String item_id)
    {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("INSERT INTO ItemSales (SalesID, ItemID) VALUES ('" + sales_id + "', " + item_id + ")");
            stmt.executeQuery();
            return true;    
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return false;
    } 
    
    
    public Boolean deleteItemSales(String sales_id)
    {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("DELETE FROM Sales WHERE salesID=" + sales_id);
            stmt.executeQuery();
            return true;    
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return false;
    }   


    public Boolean buyStockItem(Sales sales, Integer item_template_id)
    {
        try {
            System.err.println(item_template_id);
            String str_item_template_id = String.valueOf(item_template_id);
            System.out.println();
            System.out.println(str_item_template_id);
            String query = "";

            connection.setAutoCommit(false);
            query = "UPDATE users SET money=money-" + String.valueOf(sales.getPrice()) + " WHERE username='" + sales.getPurchaser() + "'; ";
            connection.prepareStatement(query).executeUpdate();
            query = "INSERT INTO items (Username, ItemTemplateID) VALUES ('" + sales.getPurchaser() + "', " + str_item_template_id + "); ";
            connection.prepareStatement(query).executeUpdate();
            query = "INSERT INTO sales (Purchaser, Price) VALUES ('" + sales.getPurchaser() + "', " + String.valueOf(sales.getPrice()) + "); ";
            connection.prepareStatement(query).executeUpdate();
            query = "INSERT INTO itemSales (salesID, itemID) SELECT MAX(s.salesID), MAX(i.itemID) FROM sales s, items i; ";
            connection.prepareStatement(query).executeUpdate();
            
            connection.commit();
            return true;    

        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return false;
    }   

    public Boolean buySellerItem(Sales sales, Integer item_id)
    {
        try {
            String str_item_id = String.valueOf(item_id);            
            String query = "";
            
            connection.setAutoCommit(false);

            query = "UPDATE users SET money=money-" + String.valueOf(sales.getPrice()) + " WHERE username='" + sales.getPurchaser() + "'; ";
            connection.prepareStatement(query).executeUpdate();
            query = "UPDATE users SET money=money+" + String.valueOf(sales.getPrice()) + " WHERE username='" + sales.getSeller() + "'; ";
            connection.prepareStatement(query).executeUpdate();
            query = "UPDATE items SET Username='" + sales.getPurchaser() + "' WHERE itemID=" + str_item_id + "; ";
            connection.prepareStatement(query).executeUpdate();
            query = "INSERT INTO sales (Seller, Purchaser, Price) VALUES ('" + sales.getSeller() + "', '" + sales.getPurchaser() + "', " + String.valueOf(sales.getPrice()) + "); "; 
            connection.prepareStatement(query).executeUpdate();
            query = "INSERT INTO itemSales (salesID, itemID) SELECT MAX(s.salesID)," + str_item_id + " FROM sales s; ";
            connection.prepareStatement(query).executeUpdate();
            
            connection.commit();
            return true;
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return false;
    }
    
    

}