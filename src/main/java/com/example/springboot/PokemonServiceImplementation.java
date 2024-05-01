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
public class PokemonServiceImplementation {
    
    @Autowired
    static List<Pokemon> pokemonList = new ArrayList<Pokemon>();

    Connection connection;

    public PokemonServiceImplementation() throws SQLException
    {
        connection = DBUtil.getConnection();
    }
    public String getPokemonName(String poke_id)
    {
        try
        {
            PreparedStatement stmt = connection.prepareStatement("SELECT poke_name FROM pokemon WHERE pokemon_id="+poke_id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getString(1);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return "";
    }
    public List<Pokemon> getPokemonData()
    {
        try
        {
            pokemonList = new ArrayList<Pokemon>();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM pokemontemplate");
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                Pokemon poke = new Pokemon(rs.getInt(1), rs.getString(2));
                pokemonList.add(poke);
                // Pokemon poke_test = new Pokemon(1, "test");
                // pokemonList.add(poke_test);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return pokemonList;
    }

    public void addUser(String username, String password){
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO Users (Username, User_Password) VALUES (?, ?)");
            stmt.setString(1, username);
            stmt.setString(2, password);

            int rs = stmt.executeUpdate();

            if (rs > 0) {
                System.out.println("User added successfully!");
            } else {
                System.out.println("Failed to add user.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean loginUser(String username, String password) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT User_Password FROM Users WHERE Username = ?");

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String db_password = rs.getString("User_password");
                return db_password.equals(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    
}
