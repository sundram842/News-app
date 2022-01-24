package com.example.newsapp;

public class catagory {
    private String categroy;
    private String categroyImageUrl;

    public String getCategroy() {
        return categroy;
    }

    public void setCategroy(String categroy) {
        this.categroy = categroy;
    }

    public String getCategroyImageUrl() {
        return categroyImageUrl;
    }

    public void setCategroyImageUrl(String categroyImageUrl) {
        this.categroyImageUrl = categroyImageUrl;
    }

    public catagory(String categroy, String categroyImageUrl) {
        this.categroy = categroy;
        this.categroyImageUrl = categroyImageUrl;
    }
}
