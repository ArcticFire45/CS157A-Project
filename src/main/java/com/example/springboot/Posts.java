package com.example.springboot;


public class Posts {
    private Integer postID;
    private String postContent;
    private String author;

    public Posts(Integer postID, String postContent, String author) {
        this.postID = postID;
        this.postContent = postContent;
        this.author = author;

    }

    public Integer getPostid() {
        return postID;
    }

    public void setPostid(Integer postID) {
        this.postID = postID;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "PokemonPosts [postId=" + postID + ", postContent=" + postContent + ", author=" + author + "]";
    }
}
