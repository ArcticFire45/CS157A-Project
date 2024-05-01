package com.example.springboot;

public class User {
    private String username;
    private String password;
    private Float money;

    public User(String username, String password, Float money){
        this.username = username;
        this.password = password;
        this.money = money;
    }

    public void set_username(String username){
        this.username = username;
    }

    public String get_username(){
        return username;
    }

    public void set_password(String password){
        this.password = password;
    }

    public void set_money(Float money){
        this.money = money;
    }

    public Float get_money(){
        return money;
    }


}
