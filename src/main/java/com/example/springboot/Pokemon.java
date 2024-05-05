package com.example.springboot;

public class Pokemon {
    private Integer poke_id;
    private Integer stockPrice;
    private String poke_name;
    private String type1;
    private String type2;
    private String gifUrl;
    private String imageUrl;
    private String pokemonDescription;
    // USER TABLE
    // U_ID, Name, Age, favorite_pokemon
    // 1, Tyler, 22, poke_id=1

    public Pokemon(Integer poke_id, Integer stockPrice, String poke_name, String type1, String type2, String gifUrl,
            String imageUrl,
            String pokemonDescription) {
        this.poke_id = poke_id;
        this.stockPrice = stockPrice;
        this.poke_name = poke_name;
        this.type1 = type1;
        this.type2 = type2;
        this.gifUrl = gifUrl;
        this.imageUrl = imageUrl;
        this.pokemonDescription = pokemonDescription;
    }

    @Override
    public String toString() {
        return "Pokemon [poke_id=" + poke_id + ", stockPrice=" + stockPrice + ", poke_name=" + poke_name + ", type1="
                + type1 + ", type2=" + type2
                + ", gifUrl=" + gifUrl + ", imageUrl=" + imageUrl + ", pokemonDescription=" + pokemonDescription + "]";
    }

    public Integer getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(Integer stockPrice) {
        this.stockPrice = stockPrice;
    }

    public String gettype1() {
        return type1;
    }

    public void settype1(String type1) {
        this.type1 = type1;
    }

    public String gettype2() {
        return type2;
    }

    public void settype2(String type2) {
        this.type2 = type2;
    }

    public String getgifUrl() {
        return gifUrl;
    }

    public void setgifUrl(String gifUrl) {
        this.gifUrl = gifUrl;
    }

    public String getimageUrl() {
        return imageUrl;
    }

    public void setimageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getpokemonDescription() {
        return pokemonDescription;
    }

    public void setpokemonDescription(String pokemonDescription) {
        this.pokemonDescription = pokemonDescription;
    }

    public Integer getPoke_id() {
        return poke_id;
    }

    public void setPoke_id(Integer poke_id) {
        this.poke_id = poke_id;
    }

    public String getPoke_name() {
        return poke_name;
    }

    public void setPoke_name(String poke_name) {
        this.poke_name = poke_name;
    }
}
