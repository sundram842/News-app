package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class newsDetail extends AppCompatActivity {
String tital,content,des,img,url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        tital=getIntent().getStringExtra("tital");
        content=getIntent().getStringExtra("content");
        des=getIntent().getStringExtra("des");
        img=getIntent().getStringExtra("img");
        url=getIntent().getStringExtra("url");
    }
}