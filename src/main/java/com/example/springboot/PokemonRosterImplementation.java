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

    @Autowired
    static List<Integer> pokemons = new ArrayList<Integer>();
    Connection connection;

    public PokemonRosterImplementation() throws SQLException {
        connection = DBUtil.getConnection();
    }

    public List<Integer> getRoster(String username) {
        pokemons = new ArrayList<Integer>();
        try {
            // Check if the username exists in the PokemonTeam table
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM PokemonTeam WHERE Username = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Username exists, fetch the Pokemon IDs
                for (int i = 1; i <= 6; i++) {
                    Integer poke = rs.getInt("PokemonID" + i);
                    if (poke != null && poke != 0) {
                        // Add the non-null and non-zero Pokemon IDs to the list
                        pokemons.add(poke);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pokemons;
    }

    public boolean addPokemonToRoster(String username, int pokemonID) {
        try {
            // Check if the username already exists in the PokemonTeam table
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM PokemonTeam WHERE Username = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Username exists, check if the PokemonID already exists in any of the columns
                for (int i = 1; i <= 6; i++) {
                    Integer poke = rs.getInt("PokemonID" + i);
                    if (poke != null && poke == pokemonID) {
                        // PokemonID already exists in the row, return false
                        return false;
                    }
                }

                // Check if there's space for the new PokemonID
                for (int i = 1; i <= 6; i++) {
                    Integer poke = rs.getInt("PokemonID" + i);
                    if (poke == null || poke == 0) {
                        // Found an empty slot, update it with the new PokemonID
                        stmt = connection
                                .prepareStatement("UPDATE PokemonTeam SET PokemonID" + i + " = ? WHERE Username = ?");
                        stmt.setInt(1, pokemonID);
                        stmt.setString(2, username);
                        int rowsUpdated = stmt.executeUpdate();
                        return rowsUpdated > 0; // Return true if the update was successful
                    }
                }
                // No empty slot found, return false
                return false;
            } else {
                // Username does not exist in the PokemonTeam table, add it
                stmt = connection.prepareStatement("INSERT INTO PokemonTeam (Username, PokemonID1) VALUES (?, ?)");
                stmt.setString(1, username);
                stmt.setInt(2, pokemonID);
                int rowsInserted = stmt.executeUpdate();
                return rowsInserted > 0; // Return true if a new row was inserted
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removePokemonFromRoster(String username, int pokemonID) {
        try {
            // Select the row corresponding to the given username
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT PokemonID1, PokemonID2, PokemonID3, PokemonID4, PokemonID5, PokemonID6 FROM PokemonTeam WHERE Username = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                for (int i = 1; i <= 6; i++) {
                    Integer poke = rs.getInt("PokemonID" + i);
                    // Check if the Pokemon ID matches the one provided and set it to NULL
                    if (poke != null && poke == pokemonID) {
                        stmt = connection.prepareStatement(
                                "UPDATE PokemonTeam SET PokemonID" + i + " = NULL WHERE Username = ?");
                        stmt.setString(1, username);
                        stmt.executeUpdate();
                        return true; // Return true if the Pokemon ID was removed successfully
                    }
                }
                // If the provided Pokemon ID was not found in the team, return false
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // If an exception occurs or the username is not found, return false
        return false;
    }

    public boolean clearRoster(String username) {

        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "UPDATE PokemonTeam SET PokemonID1 = NULL, PokemonID2 = NULL, PokemonID3 = NULL, PokemonID4 = NULL, PokemonID5 = NULL, PokemonID6 = NULL WHERE Username = "
                            + username);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
