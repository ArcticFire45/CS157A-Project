package com.example.springboot;

public class Posts {
    private Integer postID;
    private String author;
    private String postDesc;
    private String imageURL;

    public Posts(Integer postID, String author, String postDesc, String imageURL) {
        this.postID = postID;
        this.author = author;
        this.postDesc = postDesc;
        this.imageURL = imageURL;
    }

    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPostDesc() {
        return postDesc;
    }

    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Posts [postID=" + postID + ", author=" + author + ", postDesc=" + postDesc + ", imageURL=" + imageURL
                + "]";
    }
}
