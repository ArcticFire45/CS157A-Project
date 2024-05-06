package com.example.springboot;

//required:
//UserPosts(PostID, description, image_url)

// User posts pokemon 
public class UserPosts {
    private Integer PostID;
    private String description;
    private String image_url;

    public UserPosts(Integer PostID, String description, String image_url) {
        this.PostID = PostID;
        this.description = description;
        this.image_url = image_url;

    }

    public Integer getPostid() {
        return PostID;
    }

    public void setPostid(Integer PostID) {
        this.PostID = PostID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "UserPosts [postId=" + PostID + ", description=" + description + ", imageUrl=" + image_url + "]";
    }
}
