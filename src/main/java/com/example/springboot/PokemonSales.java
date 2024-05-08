package com.example.springboot;



// CREATE TABLE IF NOT EXISTS PokemonSales (
//     SalesID INT PRIMARY KEY auto_increment,
//     PokemonID INT NOT NULL,
//     FOREIGN KEY (SalesID) REFERENCES Sales(SalesID),
//     FOREIGN KEY (PokemonID) REFERENCES Pokemon(PokeID)
// );

// CREATE TABLE IF NOT EXISTS ItemSales (
//     SalesID INT PRIMARY KEY auto_increment,
//     ItemID INT NOT NULL,
//     FOREIGN KEY (SalesID) REFERENCES Sales(SalesID),
//     FOREIGN KEY (ItemID) REFERENCES Items(ItemID)
// );


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
