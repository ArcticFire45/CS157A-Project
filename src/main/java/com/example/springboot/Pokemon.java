package com.example.springboot;

public class Pokemon {


    
    @Override
    public String toString() {
        return "Pokemon [poke_id=" + poke_id + ", poke_name=" + poke_name + "]";
    }
    private Integer poke_id;
    private String poke_name;



    
    public Pokemon(Integer poke_id, String poke_name) {
        this.poke_id = poke_id;
        this.poke_name = poke_name;
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
