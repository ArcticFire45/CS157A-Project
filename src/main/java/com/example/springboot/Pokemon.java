package com.example.springboot;

public class Pokemon {

    @Override
    public String toString() {
        return "Pokemon [poke_id=" + poke_id + ", poke_name=" + poke_name + "]";
    }
    private Integer poke_id;
    private String poke_name;
<<<<<<< HEAD

// USER TABLE
// U_ID, Name, Age, favorite_pokemon
// 1, Tyler, 22, poke_id=1

=======
>>>>>>> 9aa75bea1a7bc0bf17ace55e510dedec7202f0b1
    
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
