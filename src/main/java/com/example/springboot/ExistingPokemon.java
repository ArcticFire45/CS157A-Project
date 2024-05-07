package com.example.springboot;


// CREATE TABLE IF NOT EXISTS Pokemon (
//     PokeID INT PRIMARY KEY auto_increment, -- The pokemon identity
//     Username varchar(30), -- Pokemon owner
//     PokeTemplateID INT NOT NULL, -- Pokemon type
//     FOREIGN KEY (Username) REFERENCES Users(Username),
//     FOREIGN KEY (PokeTemplateID) REFERENCES PokemonTemplate(PokeTemplateID)
// );
public class ExistingPokemon {
    private Integer poke_id;
    private String username;
    private Integer poke_template_id;
    public ExistingPokemon(Integer poke_id, String username, Integer poke_template_id) {
        this.poke_id = poke_id;
        this.username = username;
        this.poke_template_id = poke_template_id;
    }
    public Integer getPoke_id() {
        return poke_id;
    }
    public void setPoke_id(Integer poke_id) {
        this.poke_id = poke_id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Integer getPoke_template_id() {
        return poke_template_id;
    }
    public void setPoke_template_id(Integer poke_template_id) {
        this.poke_template_id = poke_template_id;
    }
    @Override
    public String toString() {
        return "ExistingPokemon [poke_id=" + poke_id + ", username=" + username + ", poke_template_id="
                + poke_template_id + "]";
    }
}
