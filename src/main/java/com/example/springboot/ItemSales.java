package com.example.springboot;

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
