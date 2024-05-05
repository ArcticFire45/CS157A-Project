package com.example.springboot;

public class User {
    private String username;
    private String password;
    private double money;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public User(String username, String password, double money) {
        this.username = username;
        this.password = password;
        this.money = money;
    }

}
