package com.example.springboot;


public class PokemonSales {


    private Integer pokemon_sales_id;
    private Integer pokemon_id;
    
    public PokemonSales(Integer pokemon_sales_id, Integer pokemon_id) {
        this.pokemon_sales_id = pokemon_sales_id;
        this.pokemon_id = pokemon_id;
    }
    public Integer getPokemon_sales_id() {
        return pokemon_sales_id;
    }
    public void setPokemon_sales_id(Integer pokemon_sales_id) {
        this.pokemon_sales_id = pokemon_sales_id;
    }
    public Integer getPokemon_id() {
        return pokemon_id;
    }
    public void setPokemon_id(Integer pokemon_id) {
        this.pokemon_id = pokemon_id;
    }
    @Override
    public String toString() {
        return "PokemonSales [pokemon_sales_id=" + pokemon_sales_id + ", pokemon_id=" + pokemon_id + "]";
    }

}
