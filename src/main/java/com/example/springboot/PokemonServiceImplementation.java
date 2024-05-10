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

    public PokemonServiceImplementation() throws SQLException {
        connection = DBUtil.getConnection();
    }

    public String getPokemonName(String poke_id) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("SELECT poke_name FROM pokemonTemplate WHERE PokemonTemplateID=" + poke_id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public List<Pokemon> getPokemonData() {
        try {
            pokemonList = new ArrayList<Pokemon>();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM pokemontemplate");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Pokemon poke = new Pokemon(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
                        rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8));
                pokemonList.add(poke);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pokemonList;
    }

    public List<Pokemon> searchPokemonByName(String name) {
        try {
            pokemonList = new ArrayList<Pokemon>();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM pokemontemplate WHERE PokeName LIKE ?");
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Pokemon poke = new Pokemon(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
                        rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8));
                pokemonList.add(poke);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pokemonList;
    }


    public Pokemon getPokemon(String poke_id) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("SELECT * FROM pokemontemplate WHERE PokeTemplateID=" + poke_id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            Pokemon pokemon_template =  new Pokemon(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
            rs.getString(5),
            rs.getString(6), rs.getString(7), rs.getString(8));

            return pokemon_template;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
