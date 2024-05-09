package com.example.springboot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.example.springboot.ItemServiceImplementation;

@Service
public class ExistingItemServiceImplementation {

    @Autowired
    static List<ExistingItem> existingItemsList = new ArrayList<ExistingItem>();

    @Autowired
    static List<Items> itemsList = new ArrayList<Items>();

    Connection connection;

    public ExistingItemServiceImplementation() throws SQLException {
        connection = DBUtil.getConnection();
    }

    // private Integer item_id;
    // private String username;
    // private Integer item_template_id;

    // getItem
    // getUserItems
    // getExistingItems
    // getExistingTemplateItems

    public ExistingItem getItem(String item_id) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("SELECT * FROM items WHERE itemID=" + item_id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            ExistingItem item = new ExistingItem(rs.getInt(1), rs.getString(2), rs.getInt(3));
            return item;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Items> getUserItems(String username) {
        itemsList = new ArrayList<Items>();
        try {
            PreparedStatement stmt = connection
                    .prepareStatement(
                            "SELECT i.*, it.ItemName, it.StockPrice, it.ItemDescription, it.MoneyClickerMultiplier, it.ImageURL "
                                    +
                                    "FROM Items i " +
                                    "JOIN ItemTemplate it ON i.ItemTemplateID = it.ItemTemplateID " +
                                    "WHERE i.Username = ?");
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Items item = new Items(rs.getInt("ItemID"), rs.getString("ItemName"), rs.getFloat("StockPrice"),
                        rs.getString("ItemDescription"), rs.getFloat("MoneyClickerMultiplier"),
                        rs.getString("ImageURL"));
                itemsList.add(item);
            }
            return itemsList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ExistingItem> getExistingItems(String username, String item_template_id) {
        existingItemsList = new ArrayList<ExistingItem>();
        try {
            String query_str = "SELECT * FROM items WHERE ItemTemplateID=" + item_template_id + " AND username='"
                    + username + "'";
            PreparedStatement stmt = connection
                    .prepareStatement(query_str);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ExistingItem item = new ExistingItem(rs.getInt(1), rs.getString(2), rs.getInt(3));
                existingItemsList.add(item);
            }
            return existingItemsList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ExistingItem> getExistingTemplateItems(String item_template_id) {
        existingItemsList = new ArrayList<ExistingItem>();
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("SELECT * FROM items WHERE ItemTemplateID=" + item_template_id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ExistingItem item = new ExistingItem(rs.getInt(1), rs.getString(2), rs.getInt(3));
                existingItemsList.add(item);
            }
            return existingItemsList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean addExistingItem(String username, String item_template_id) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("INSERT INTO Items (username, ItemTemplateID) VALUES ('" + username + "', "
                            + item_template_id + ")");
            stmt.executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean deleteExistingItem(String item_id) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("DELETE FROM Items WHERE itemID=" + item_id);
            stmt.executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean changeOwnerUsername(String item_id, String new_username) {
        try {
            // UPDATE Customers
            // SET ContactName = 'Alfred Schmidt', City = 'Frankfurt'
            // WHERE CustomerID = 1;
            ExistingItem item = this.getItem(item_id);
            PreparedStatement stmt = connection
                    .prepareStatement("UPDATE Items SET itemID=" + item_id + ", username='" + new_username
                            + "', ItemTemplateID=" + item.getItem_template_id() + " WHERE itemID=" + item_id);
            stmt.executeQuery();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // @PostMapping("/changeItemOwner")
    // public Boolean getExistingTemplateItems(@RequestBody String item_id, String
    // new_username) {
    // try {
    // return this.existingItemsService.changeOwnerUsername(item_id, new_username);
    // } catch (Exception e) {
    // return false;
    // }

    // public List<Pokemon> getPokemonData() {
    // try {
    // existingItemsList = new ArrayList<Pokemon>();
    // PreparedStatement stmt = connection.prepareStatement("SELECT * FROM
    // pokemontemplate");
    // ResultSet rs = stmt.executeQuery();
    // while (rs.next()) {
    // Pokemon poke = new Pokemon(rs.getInt(1), rs.getInt(2), rs.getString(3),
    // rs.getString(4),
    // rs.getString(5),
    // rs.getString(6), rs.getString(7), rs.getString(8));
    // existingItemsList.add(poke);
    // // Pokemon poke_test = new Pokemon(1, "test");
    // // pokemonList.add(poke_test);
    // }
    // } catch (SQLException e) {
    // e.printStackTrace();
    // }

    // return existingItemsList;
    // }

    // public List<Pokemon> searchPokemonByName(String name) {
    // try {
    // existingItemsList = new ArrayList<ExistingItem>();
    // PreparedStatement stmt = connection.prepareStatement("SELECT * FROM
    // pokemontemplate WHERE PokeName LIKE ?");
    // stmt.setString(1, "%" + name + "%");
    // ResultSet rs = stmt.executeQuery();
    // while (rs.next()) {
    // Pokemon poke = new Pokemon(rs.getInt(1), rs.getInt(2), rs.getString(3),
    // rs.getString(4),
    // rs.getString(5),
    // rs.getString(6), rs.getString(7), rs.getString(8));
    // existingItemsList.add(poke);
    // }
    // } catch (SQLException e) {
    // e.printStackTrace();
    // }

    // return existingItemsList;
    // }
}
