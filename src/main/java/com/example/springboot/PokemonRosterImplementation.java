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
public class PokemonRosterImplementation {
    @Autowired
    static List<PokemonRoster> pokemonRoster = new ArrayList<PokemonRoster>();

    Connection connection;

    public PokemonRosterImplementation() throws SQLException {
        connection = DBUtil.getConnection();
    }

    public PokemonRoster getRoster(String username){
        List<Integer> pokemons = new ArrayList<>();
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("SELECT PokemonID1, PokemonID2, PokemonID3, PokemonID4, PokemonID5, PokemonID6 FROM PokemonTeam WHERE Username =" + username);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                pokemons.add(rs.getInt("PokemonID1"));
                pokemons.add(rs.getInt("PokemonID2"));
                pokemons.add(rs.getInt("PokemonID3"));
                pokemons.add(rs.getInt("PokemonID4"));
                pokemons.add(rs.getInt("PokemonID5"));
                pokemons.add(rs.getInt("PokemonID6"));

                PokemonRoster poke = new PokemonRoster(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
                return poke;
            }
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
