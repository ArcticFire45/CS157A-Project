package com.example.springboot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class PokemonRosterImplementation {
    @Autowired
    static List<PokemonRoster> pokemonRoster = new ArrayList<PokemonRoster>();

    Connection connection;

    public PokemonRosterImplementation() throws SQLException {
        connection = DBUtil.getConnection();
    }

    public List<Pokemon> getRoster(String username){
        List<Pokemon> pokemons = new ArrayList<>();
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("SELECT p.PokeID, p.StockPrice, p.PokeName, p.Type1, p.Type2, p.GifUrl, p.ImageUrl, p.PokemonDescription " +
                    "FROM PokemonTeam pt " +
                    "JOIN Pokemon p ON p.PokeID IN (pt.PokemonID1, pt.PokemonID2, pt.PokemonID3, pt.PokemonID4, pt.PokemonID5, pt.PokemonID6) " +
                    "WHERE pt.Username = " + username);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                pokemons.add(new Pokemon(
                rs.getInt("PokeID"),
                rs.getInt("StockPrice"),
                rs.getString("PokeName"),
                rs.getString("Type1"),
                rs.getString("Type2"),
                rs.getString("GifUrl"),
                rs.getString("ImageUrl"),
                rs.getString("PokemonDescription")
            ));
            }
            return pokemons;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addPokemonToRoster(String username, int pokemonID) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("SELECT PokemonID1, PokemonID2, PokemonID3, PokemonID4, PokemonID5, PokemonID6 FROM PokemonTeam WHERE Username = " + username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                for (int i = 1; i <= 6; i++) {
                    Integer poke = (Integer) rs.getObject("PokemonID" + i);
                    if (poke == null) {
                        try{
                            stmt = connection.prepareStatement("UPDATE PokemonTeam SET PokemonID" + i + " = " + pokemonID + "WHERE Username = " + username);
                            return true;
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return false; 
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; 
    }

    public boolean removePokemonFromRoster(String username, int pokemonID) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("SELECT PokemonID1, PokemonID2, PokemonID3, PokemonID4, PokemonID5, PokemonID6 FROM PokemonTeam WHERE Username = " + username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                for (int i = 1; i <= 6; i++) {
                    Integer poke = (Integer) rs.getObject("PokemonID" + i);
                    if (poke == null) {
                        try{
                            stmt = connection.prepareStatement("UPDATE PokemonTeam SET PokemonID" + i + " = NULL" + "WHERE Username = " + username);
                            stmt.executeUpdate();
                            return true;
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return false; 
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; 
    }

    public boolean clearRoster(String username) {

        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE PokemonTeam SET PokemonID1 = NULL, PokemonID2 = NULL, PokemonID3 = NULL, PokemonID4 = NULL, PokemonID5 = NULL, PokemonID6 = NULL WHERE Username = " + username);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
