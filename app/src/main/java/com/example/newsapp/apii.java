package com.example.newsapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface apii {
    @GET
    Call<newsmodel>getallnews(@Url String url);
    @GET
    Call<newsmodel>getallnewscontain(@Url String url);
}
