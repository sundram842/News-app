package com.example.newsapp;

import java.util.ArrayList;

public class newsmodel {

    private String status;
    private int totalResults;
    private ArrayList<datastoreroom>articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<datastoreroom> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<datastoreroom> articles) {
        this.articles = articles;
    }

    public newsmodel(String status, int totalResults, ArrayList<datastoreroom> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }
}
