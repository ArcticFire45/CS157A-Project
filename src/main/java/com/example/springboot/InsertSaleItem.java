package com.example.springboot;


//model for inserting items into application. each item has a saleID, postID, itemType, itemID
public class InsertSaleItem {

    private int saleID;
    private int postID;
    private String itemType; 
    private int itemId; 

    
    public InsertSaleItem(int saleID, int postID, String itemType, int itemId) {
        this.saleID = saleID;
        this.postID = postID;
        this.itemType = itemType;
        this.itemId = itemId;
    }

    public int getSaleID() {
        return saleID;
    }

    public void setSaleID(int saleID) {
        this.saleID = saleID;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "InsertSaleItem{" +
                "saleID=" + saleID +
                ", postID=" + postID +
                ", itemType='" + itemType + '\'' +
                ", itemId=" + itemId +
                '}';
    }
}