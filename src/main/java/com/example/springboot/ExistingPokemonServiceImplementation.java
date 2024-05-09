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

// CREATE TABLE IF NOT EXISTS Pokemon (
//     PokeID INT PRIMARY KEY auto_increment, -- The pokemon identity
//     Username varchar(30), -- Pokemon owner
//     PokeTemplateID INT NOT NULL, -- Pokemon type
//     FOREIGN KEY (Username) REFERENCES Users(Username),
//     FOREIGN KEY (PokeTemplateID) REFERENCES PokemonTemplate(PokeTemplateID)
// );
@Service
public class ExistingPokemonServiceImplementation {

    @Autowired
    static List<ExistingPokemon> existingPokeList = new ArrayList<ExistingPokemon>();

    @Autowired
    static List<Pokemon> pokemonList = new ArrayList<Pokemon>();

    Connection connection;

    public ExistingPokemonServiceImplementation() throws SQLException {
        connection = DBUtil.getConnection();
    }

    // CREATE TABLE IF NOT EXISTS Pokemon (
    // PokeID INT PRIMARY KEY auto_increment, -- The pokemon identity
    // Username varchar(30), -- Pokemon owner
    // PokeTemplateID INT NOT NULL, -- Pokemon type
    // FOREIGN KEY (Username) REFERENCES Users(Username),
    // FOREIGN KEY (PokeTemplateID) REFERENCES PokemonTemplate(PokeTemplateID)
    // );

    public ExistingPokemon getPokemon(String poke_id) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("SELECT * FROM Pokemon WHERE pokeID=" + poke_id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            ExistingPokemon item = new ExistingPokemon(rs.getInt(1), rs.getString(2), rs.getInt(3));
            return item;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Pokemon> getUserPokemon(String username) {
        pokemonList = new ArrayList<Pokemon>();
        try {
            PreparedStatement stmt = connection
                    .prepareStatement(
                            "SELECT p.PokeID, p.Username, p.PokeTemplateID, pt.StockPrice, pt.PokeName, pt.Type1, pt.Type2, pt.GifURL, pt.ImageURL, pt.PokemonDescription "
                                    +
                                    "FROM Pokemon p " +
                                    "JOIN PokemonTemplate pt ON p.PokeTemplateID = pt.PokeTemplateID " +
                                    "WHERE p.Username = ?");
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Pokemon item = new Pokemon(rs.getInt("PokeTemplateID"),
                        rs.getInt("PokeID"),
                        rs.getInt("StockPrice"),
                        rs.getString("PokeName"),
                        rs.getString("Type1"),
                        rs.getString("Type2"),
                        rs.getString("GifURL"),
                        rs.getString("ImageURL"),
                        rs.getString("PokemonDescription"));
                pokemonList.add(item);
            }
            return pokemonList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ExistingPokemon> getExistingPokemons(String username, String item_template_id) {
        existingPokeList = new ArrayList<ExistingPokemon>();
        try {
            String query_str = "SELECT * FROM Pokemon WHERE PokeTemplateID=" + item_template_id + " AND username='"
                    + username + "'";
            PreparedStatement stmt = connection
                    .prepareStatement(query_str);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ExistingPokemon item = new ExistingPokemon(rs.getInt(1), rs.getString(2), rs.getInt(3));
                existingPokeList.add(item);
            }
            return existingPokeList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ExistingPokemon> getExistingTemplatePokemon(String item_template_id) {
        existingPokeList = new ArrayList<ExistingPokemon>();
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("SELECT * FROM Pokemon WHERE PokeTemplateID=" + item_template_id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ExistingPokemon item = new ExistingPokemon(rs.getInt(1), rs.getString(2), rs.getInt(3));
                existingPokeList.add(item);
            }
            return existingPokeList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean addExistingPokemon(String username, String item_template_id) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("INSERT INTO Pokemon (username, PokeTemplateID) VALUES ('" + username + "', "
                            + item_template_id + ")");
            stmt.executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean deleteExistingPokemon(String item_id) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("DELETE FROM Pokemon WHERE PokeID=" + item_id);
            stmt.executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean changeOwnerUsername(String poke_id, String new_username) {
        try {
            // UPDATE Customers
            // SET ContactName = 'Alfred Schmidt', City = 'Frankfurt'
            // WHERE CustomerID = 1;
            ExistingPokemon pokemon = this.getPokemon(poke_id);
            PreparedStatement stmt = connection
                    .prepareStatement("UPDATE Items SET pokeID=" + poke_id + ", username='" + new_username
                            + "', PokeTemplateID=" + pokemon.getPoke_template_id() + " WHERE PokeID=" + poke_id);
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
