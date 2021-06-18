package com.example.newsappphenyo.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.newsappphenyo.Model.Articles;
import com.example.newsappphenyo.Model.NewsHeadlines;
import com.example.newsappphenyo.R;
import com.example.newsappphenyo.Server.ApiClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    final String API_KEY = "WRSFwPR4cpKwipPz6AFiERdfpEMGXxHs";
    Adapter adapter;
    List<Articles> articles = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String country = getCountry();
        retrieveJson(country, API_KEY);

    }

    public void retrieveJson(String country, final String apiKey){

        Call<NewsHeadlines> call = ApiClient.getInstance().getApi().getNewsHeadlines(country, apiKey);
        call.enqueue(new Callback<NewsHeadlines>() {
            @Override
            public void onResponse(Call<NewsHeadlines> call, Response<NewsHeadlines> response) {

                if (response.isSuccessful() && response.body().getArticles() != null){
                    articles.clear();
                    articles = response.body().getArticles();
                    adapter = new Adapter(MainActivity.this,articles);
                    recyclerView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<NewsHeadlines> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

            }
        });

    }

    public String getCountry() {
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        return country.toLowerCase();

    }
}