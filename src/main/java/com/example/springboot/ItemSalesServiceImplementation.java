package com.example.springboot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// CREATE TABLE IF NOT EXISTS PokemonSales (
//     SalesID INT PRIMARY KEY auto_increment,
//     PokemonID INT NOT NULL,
//     FOREIGN KEY (SalesID) REFERENCES Sales(SalesID),
//     FOREIGN KEY (PokemonID) REFERENCES Pokemon(PokeID)
// );

// CREATE TABLE IF NOT EXISTS ItemSales (
//     SalesID INT PRIMARY KEY auto_increment,
//     ItemID INT NOT NULL,
//     FOREIGN KEY (SalesID) REFERENCES Sales(SalesID),
//     FOREIGN KEY (ItemID) REFERENCES Items(ItemID)
// );



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



    // if (sales.getPurchaser() == null) {
    //     query = query + "INSERT INTO sales (Seller, Price) VALUES ('" + sales.getSeller() + "', " + sales.getPrice() + ");";
    // } else if (sales.getSeller() == null) {
    //     query = query + "INSERT INTO sales (Purchaser, Price) VALUES ('" + sales.getPurchaser() + "', " + sales.getPrice() + ");";
    // } else {
    //     query = query + "INSERT INTO sales (Seller, Purchaser, Price) VALUES ('" + sales.getSeller() + "', '" +  sales.getPurchaser()+ "', " + sales.getPrice() + ");";
    // }

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

            // System.out.println();
            // System.out.println(query);
            // System.out.println();
            // query = "START TRANSACTION; ";
            // query = query + "UPDATE users SET money=money-10.10 WHERE username='User1';";
            // query = query + "INSERT INTO items (Username, ItemTemplateID) VALUES ('User1', 1); ";
            // query = query + "INSERT INTO sales (Purchaser, Price) VALUES ('User1', 10.10); ";
            // query = query + "INSERT INTO itemSales (salesID, itemID) SELECT MAX(s.salesID), MAX(i.itemID) FROM sales s, items i; ";
            // query = query + "COMMIT;";
            // PreparedStatement stmt = connection
            //     .prepareStatement(query);
            // stmt.executeBatch();
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
            // query = "START TRANSACTION; ";
            // query = query + "UPDATE users SET money=money-10.23 WHERE username='User1';";
            // query = query + "UPDATE users SET money=money+10.23 WHERE username='User2';";
            // query = query + "UPDATE items SET Username=User2 WHERE itemID=1); ";
            // query = query + "INSERT INTO sales (Purchaser, Price) VALUES ('User1', 10.23); ";
            // query = query + "INSERT INTO itemSales (salesID, itemID) SELECT MAX(s.salesID), 1 FROM sales s; ";
            // query = query + "COMMIT;";
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return false;
    }
    

    








    // public Boolean addItemSales(Sales sales, String item_id)
    // {
    //     try {
    //         String query = "START TRANSACTION; ";
    //         // String query = "";
    //         if (sales.getPurchaser() == null) {
    //             query = query + "INSERT INTO sales VALUE (Seller, Price) VALUES ('" + sales.getSeller() + "', " + sales.getPrice() + ";";
    //         } else if (sales.getSeller() == null) {
    //             query = query + "INSERT INTO sales VALUE (Purchaser, Price) VALUES ('" + sales.getPurchaser() + "', " + sales.getPrice() + ";";
    //         } else {
    //             query = query + "INSERT INTO sales VALUE (Seller, Purchaser, Price) VALUES ('" + sales.getSeller() + "', '" +  sales.getPurchaser()+ "', " + sales.getPrice() + ";";
    //         }
    //         query = query + " INSERT INTO itemSales (salesID, itemID) SELECT MAX(salesID), " + item_id + " FROM sales; ";
    //         query = query + " COMMIT;";            
    //         // INSERT INTO 
    //         // customers( customer_id, firstname, surname )
    //         // SELECT MAX( customer_id ) + 1, 'jim', 'sock' FROM customers;            
    //         PreparedStatement stmt = connection
    //             .prepareStatement(query);
    //         stmt.executeQuery();
    //         return true;    
    //     } catch (SQLException e) 
    //     {
    //         e.printStackTrace();
    //     }
    //     return false;
    // }   



    // MAKE A JAR FILE FOR APPLICATION


    

    // public List<ItemSales> getItemSales(String username, String item_template_id)
    // {
    //     itemSalesList = new ArrayList<ItemSales>();  
    //     try {
    //         String query_str = "SELECT * FROM items WHERE ItemTemplateID=" + item_template_id + " AND username='" + username + "'";
    //         PreparedStatement stmt = connection
    //                 .prepareStatement(query_str);
    //         ResultSet rs = stmt.executeQuery();
    //         while(rs.next())
    //         {
    //             ItemSales item = new ItemSales(rs.getInt(1), rs.getString(2), rs.getInt(3));
    //             itemSalesList.add(item);                    
    //         }
    //         return itemSalesList;
    //     } catch (SQLException e) 
    //     {
    //         e.printStackTrace();
    //     }
    //     return null;
    // }   

    

    // public List<ItemSales> getExistingTemplateItems(String item_template_id)
    // {
    //     itemSalesList = new ArrayList<ItemSales>();  
    //     try {
    //         PreparedStatement stmt = connection
    //                 .prepareStatement("SELECT * FROM items WHERE ItemTemplateID=" + item_template_id);
    //         ResultSet rs = stmt.executeQuery();
    //         while(rs.next())
    //         {
    //             ItemSales item = new ItemSales(rs.getInt(1), rs.getString(2), rs.getInt(3));
    //             itemSalesList.add(item);                    
    //         }
    //         return itemSalesList;
    //     } catch (SQLException e) 
    //     {
    //         e.printStackTrace();
    //     }
    //     return null;
    // }   


    // public Boolean changeOwnerUsername(String item_id, String new_username)
    // {
    //     try {
    //         // UPDATE Customers
    //         // SET ContactName = 'Alfred Schmidt', City = 'Frankfurt'
    //         // WHERE CustomerID = 1;
    //         ItemSales item = this.getItemSale(item_id);
    //         PreparedStatement stmt = connection
    //                 .prepareStatement("UPDATE Items SET itemID=" + item_id + ", username='"+new_username + "', ItemTemplateID="+item.getItem_template_id() + " WHERE itemID=" + item_id);
    //         stmt.executeQuery();

    //         return true;    
    //     } catch (SQLException e) 
    //     {
    //         e.printStackTrace();
    //     }
    //     return false;
    // }   




    

}