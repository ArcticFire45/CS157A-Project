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
            PreparedStatement stmt = connection.prepareStatement("SELECT poke_name FROM pokemon WHERE pokemon_id=1");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getString(1);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return "";
    }
    public List<Pokemon> getPokemonData()
    {
        try
        {
<<<<<<< HEAD
            pokemonList = new ArrayList();
=======
            pokemonList = new ArrayList<Pokemon>();
>>>>>>> 9aa75bea1a7bc0bf17ace55e510dedec7202f0b1
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM pokemon");
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

}
