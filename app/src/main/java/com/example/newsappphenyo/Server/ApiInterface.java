package com.example.newsappphenyo.Server;

import com.example.newsappphenyo.Model.NewsHeadlines;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("mostpopular/v2/")
    Call<NewsHeadlines> getNewsHeadlines(
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );


}
