package com.example.springboot;

//SalesPosts(SalesID, PostID)
public class SalesPost {
    private Integer SalesID;
    private Integer PostID;

    public SalesPost(Integer SalesID, Integer PostID) {
        this.SalesID = SalesID;
        this.PostID = PostID;
    }

    //getters and setters
    public Integer getSalesID(){
        return SalesID;
    }

    public void setSalesID(Integer SalesID) {
        this.SalesID = SalesID;
    }

    public Integer getPostID() {
        return PostID;
    }

    public void setPostId(Integer PostID) {
        this.PostID = PostID;
    }

    @Override
    public String toString() {
        return "SalesPost [salesId=" + SalesID + ", postId=" + PostID + "]";
    }
}


