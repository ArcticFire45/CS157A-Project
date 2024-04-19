package com.example.springboot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.Pokemon;
import com.example.springboot.DBUtil;


@Service
public class PokemonServiceImplementation {
    
    @Autowired
    static List<Pokemon> pokemonList = new ArrayList();

    Connection connection;

    public PokemonServiceImplementation() throws SQLException
    {
        connection = DBUtil.getConnection();
    }

    public List<Pokemon> getPokemonData()
    {
        try
        {
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
