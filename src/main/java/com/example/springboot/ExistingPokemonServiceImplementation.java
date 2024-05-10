package com.example.springboot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.atn.SemanticContext.AND;
// import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//creating implementation for existing pokemon service
@Service
public class ExistingPokemonServiceImplementation {

    @Autowired
    static List<ExistingPokemon> existingPokeList = new ArrayList<ExistingPokemon>();

    @Autowired
    static List<Pokemon> pokemonList = new ArrayList<Pokemon>();

    Connection connection;

    //constructor method
    public ExistingPokemonServiceImplementation() throws SQLException {
        connection = DBUtil.getConnection();
    }



    //retrieves an existing pokemon from the database based on its unique poke_id and constructs an existing pokemon object 
    //representing the retrieved Pokémon and returns it
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

    //retrieves all pokemon belonging to a specific user from the database. 
    //constructs Pokemon objects for each retrieved Pokemon and adds them to a list, which is then returned.
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

    //retrieves all existing Pokemon of a specific template owned by a particular user. 
    //constructs ExistingPokemon objects for each retrieved Pokemon and adds them to a list, which is then returned.
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

    // This method retrieves all existing Pokémon of a specific template from the database. 
    // It constructs ExistingPokemon objects for each retrieved Pokémon and adds them to a list, which is then returned.
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

    //Adds a new existing Pokemon to the database for a specific user and template.
    //executes an SQL INSERT statement and returns true if the insertion is successful, otherwise false.
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

    //Deletes an existing Pokemon from the database based on its item_id. 
    //executes an SQL DELETE statement and returns true if the deletion is successful, otherwise false.
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

    //Changes the owner of a Pokemon specified by poke_id to a new username. 
    //Executes an SQL UPDATE statement and returns true if the update is successful, otherwise false.
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



// Retrieves all Pokemon belonging to a specific user (username) from the database that are available for sale (not already sold). 
// Constructs ExistingPokemon objects for each retrieved Pokemon and adds them to a list, which is then returned.
public List<ExistingPokemon> getUserSellablePokemon(String username) {
    existingPokeList = new ArrayList<ExistingPokemon>();
    try {
        String query = "SELECT * FROM pokemon p, pokemonTemplate pt WHERE p.username = '" + username + "' AND pt.PokeTemplateID = p.PokeTemplateID AND p.PokeID NOT IN (SELECT ps.pokemonID as PokeID FROM pokemonsales ps, sales s WHERE ps.SalesID = s.SalesID AND s.Purchaser = NULL);";
        PreparedStatement stmt = connection
                .prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            ExistingPokemon pokemon = new ExistingPokemon(rs.getInt(1), rs.getString(2), rs.getInt(3));
            existingPokeList.add(pokemon);
        }
        return existingPokeList;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

    

}
