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


public class ItemSales {


    private Integer item_sales_id;
    private Integer item_id;
    
    public ItemSales(Integer item_sales_id, Integer item_id) {
        this.item_sales_id = item_sales_id;
        this.item_id = item_id;
    }
    public Integer getItem_sales_id() {
        return item_sales_id;
    }
    public void setItem_sales_id(Integer item_sales_id) {
        this.item_sales_id = item_sales_id;
    }
    public Integer getItem_id() {
        return item_id;
    }
    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }
    @Override
    public String toString() {
        return "ItemSales [item_sales_id=" + item_sales_id + ", item_id=" + item_id + "]";
    }

}
