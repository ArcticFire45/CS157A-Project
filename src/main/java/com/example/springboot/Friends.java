package com.example.springboot;

public class Friends {
    private String Username1;
    private String Username2;
    
    public String getUsername1() {
        return Username1;
    }
    public void setUsername1(String username1) {
        Username1 = username1;
    }
    public String getUsername2() {
        return Username2;
    }
    public void setUsername2(String username2) {
        Username2 = username2;
    }
    public Friends(String username1, String username2) {
        Username1 = username1;
        Username2 = username2;
    }
}
