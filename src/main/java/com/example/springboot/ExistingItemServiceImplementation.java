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

    Connection connection;

    public ExistingItemServiceImplementation() throws SQLException {
        connection = DBUtil.getConnection();
    }

    // private Integer item_id;
    // private String username;
    // private Integer item_template_id;

    public ExistingItem getItem(String item_id)
    {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("SELECT * FROM items WHERE itemID=" + item_id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            ExistingItem item = new ExistingItem(rs.getInt(1), rs.getString(2), rs.getInt(3));
            return item;
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }   

    public List<ExistingItem> getUserItems(String username)
    {
        existingItemsList = new ArrayList<ExistingItem>();  
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("SELECT * FROM items WHERE username=" + username);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                ExistingItem item = new ExistingItem(rs.getInt(1), rs.getString(2), rs.getInt(3));
                existingItemsList.add(item);                    
            }
            return existingItemsList;
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }   

    public List<ExistingItem> getExistingItems(String username, String item_template_id)
    {
        existingItemsList = new ArrayList<ExistingItem>();  
        try {
            String query_str = "SELECT * FROM items WHERE ItemTemplateID=" + item_template_id + " AND username=" + username;
            PreparedStatement stmt = connection
                    .prepareStatement(query_str);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                ExistingItem item = new ExistingItem(rs.getInt(1), rs.getString(2), rs.getInt(3));
                existingItemsList.add(item);                    
            }
            return existingItemsList;
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }   


    public List<ExistingItem> getExistingTemplateItems(String item_template_id)
    {
        existingItemsList = new ArrayList<ExistingItem>();  
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("SELECT * FROM items WHERE ItemTemplateID=" + item_template_id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                ExistingItem item = new ExistingItem(rs.getInt(1), rs.getString(2), rs.getInt(3));
                existingItemsList.add(item);                    
            }
            return existingItemsList;
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }   






    // public List<Pokemon> getPokemonData() {
    //     try {
    //         existingItemsList = new ArrayList<Pokemon>();
    //         PreparedStatement stmt = connection.prepareStatement("SELECT * FROM pokemontemplate");
    //         ResultSet rs = stmt.executeQuery();
    //         while (rs.next()) {
    //             Pokemon poke = new Pokemon(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
    //                     rs.getString(5),
    //                     rs.getString(6), rs.getString(7), rs.getString(8));
    //             existingItemsList.add(poke);
    //             // Pokemon poke_test = new Pokemon(1, "test");
    //             // pokemonList.add(poke_test);
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }

    //     return existingItemsList;
    // }

    // public List<Pokemon> searchPokemonByName(String name) {
    //     try {
    //         existingItemsList = new ArrayList<ExistingItem>();
    //         PreparedStatement stmt = connection.prepareStatement("SELECT * FROM pokemontemplate WHERE PokeName LIKE ?");
    //         stmt.setString(1, "%" + name + "%");
    //         ResultSet rs = stmt.executeQuery();
    //         while (rs.next()) {
    //             Pokemon poke = new Pokemon(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
    //                     rs.getString(5),
    //                     rs.getString(6), rs.getString(7), rs.getString(8));
    //             existingItemsList.add(poke);
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }

    //     return existingItemsList;
    // }
}
