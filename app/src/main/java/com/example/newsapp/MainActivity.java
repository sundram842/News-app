package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toolbar;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements catagoryAdapter.cat {

    private RecyclerView idRVCategorier;
    private RecyclerView idRVNews;
    private ProgressBar PBloading;
    private ArrayList<catagory>catagoryArrayList;
    private ArrayList<datastoreroom>datastoreroomArrayList;
    private catagoryAdapter catagoryAdapter;
    private newsmodelAdapter newsmodelAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idRVCategorier = (RecyclerView) findViewById(R.id.idRVCategorier);
        idRVNews = (RecyclerView) findViewById(R.id.idRVNews);
        PBloading = (ProgressBar) findViewById(R.id.PBloading);
       catagoryArrayList=new ArrayList<>();
       datastoreroomArrayList=new ArrayList<>();
       newsmodelAdapter=new newsmodelAdapter(datastoreroomArrayList,this);
       catagoryAdapter=new catagoryAdapter(catagoryArrayList,this,this::oncat);
       idRVCategorier.setAdapter(catagoryAdapter);
       idRVNews.setAdapter(newsmodelAdapter);
       getitem();
       getnews("all");
       newsmodelAdapter.notifyDataSetChanged();

    }
    public void getitem()
    {
        catagoryArrayList.add(new catagory("all","https://images.unsplash.com/photo-1572949645841-094f3a9c4c94?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8bmV3c3xlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=600&q=60"));
        catagoryArrayList.add(new catagory("technology","https://images.unsplash.com/photo-1518770660439-4636190af475?ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8dGVjaG5vbG9neXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=600&q=60"));
        catagoryArrayList.add(new catagory("science","https://images.unsplash.com/photo-1530210124550-912dc1381cb8?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTR8fHNjaWVuY2V8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=600&q=60"));
        catagoryArrayList.add(new catagory("sport","https://images.unsplash.com/photo-1461896836934-ffe607ba8211?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8c3BvcnR8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=600&q=60"));
        catagoryArrayList.add(new catagory("general","https://images.unsplash.com/photo-1457369804613-52c61a468e7d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTZ8fGdlbmVyYWwlMjB0aGluZ3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=600&q=60"));
        catagoryArrayList.add(new catagory("business","https://images.unsplash.com/photo-1462206092226-f46025ffe607?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTF8fGJ1c2luZXNzfGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=600&q=60"));
        catagoryArrayList.add(new catagory("entertainment","https://images.unsplash.com/photo-1514525253161-7a46d19cd819?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8ZW50ZXJ0YWlubWVudHxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=600&q=60"));
        catagoryArrayList.add(new catagory( "health", "https://images.unsplash.com/photo-1506126613408-eca07ce68773?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8aGVhbHRofGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=600&q=60"));
        catagoryAdapter.notifyDataSetChanged();

    }



    @Override
    public void oncat(int position) {
        String cat = catagoryArrayList.get(position).getCategroy();
        getnews(cat);
        newsmodelAdapter.notifyDataSetChanged();

    }

    private  void getnews(String category){
        PBloading.setVisibility(View.GONE);
        datastoreroomArrayList.clear();
        String categoryurl="https://newsapi.org/v2/top-headlines?country=in&category="+category+"&apikey=9d28962d6c794fdca76ccbd8b9022a93";
        String url="https://newsapi.org/v2/top-headlines?country=in&excludeDomains=stackoverflow.com&softBy=publishedArt&language=en&apiKey=9d28962d6c794fdca76ccbd8b9022a93";
        String Base_url="https://newsapi.org";
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(Base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apii Apii= retrofit.create(apii.class);
        Call<newsmodel>call;
        if (category.equals("all"))
        {
            call=Apii.getallnews(url);
        }
        else
        {
            call=Apii.getallnewscontain(categoryurl);
        }
        call.enqueue(new Callback<newsmodel>() {
            @Override
            public void onResponse(Call<newsmodel> call, Response<newsmodel> response) {
                newsmodel Newsmodel=response.body();
                ArrayList<datastoreroom>datastorerooms=Newsmodel.getArticles();
                for (int i=0;i<datastorerooms.size();i++)
                {
                    datastoreroomArrayList.add(new datastoreroom(datastorerooms.get(i).getTitle(),datastorerooms.get(i).getDescription(),datastorerooms.get(i).getUrl(),datastorerooms.get(i).getUrlToImage(),datastorerooms.get(i).getContent()));


                }
                newsmodelAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<newsmodel> call, Throwable t) {

            }
        });


    }


}