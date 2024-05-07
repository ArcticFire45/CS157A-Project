package com.example.springboot;
public class PokemonRoster {
    private Integer ownerID;
    private Integer poke1;
    private Integer poke2;
    private Integer poke3;
    private Integer poke4;
    private Integer poke5;
    private Integer poke6;

    public PokemonRoster(Integer ownerID, Integer poke1, Integer poke2, Integer poke3, Integer poke4, Integer poke5, Integer poke6){
        this.ownerID = ownerID;
        this.poke1 = poke1;
        this.poke2 = poke2;
        this.poke3 = poke3;
        this.poke4 = poke4;
        this.poke5 = poke5;
        this.poke6 = poke6;
    }

    public Integer getOwnerID(){
        return ownerID;
    }

    public void setOwnerID(Integer ownerID){
        this.ownerID = ownerID;
    }

    public Integer getPoke1(){
        return poke1;
    }

    public void setPoke1(Integer poke1){
        this.poke1 = poke1;
    }

    public Integer getPoke2() {
        return poke2;
    }
    
    public void setPoke2(Integer poke2) {
        this.poke2 = poke2;
    }
    
    public Integer getPoke3() {
        return poke3;
    }
    
    public void setPoke3(Integer poke3) {
        this.poke3 = poke3;
    }
    
    public Integer getPoke4() {
        return poke4;
    }
    
    public void setPoke4(Integer poke4) {
        this.poke4 = poke4;
    }
    
    public Integer getPoke5() {
        return poke5;
    }
    
    public void setPoke5(Integer poke5) {
        this.poke5 = poke5;
    }
    
    public Integer getPoke6() {
        return poke6;
    }
    
    public void setPoke6(Integer poke6) {
        this.poke6 = poke6;
    }
    
    

}
