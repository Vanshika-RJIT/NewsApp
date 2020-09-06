package com.example.newsapi1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {
  RecyclerView r;
  RecyclerView.LayoutManager layoutManager;
  ArrayList<MyPojo> mydata = new ArrayList<MyPojo>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        mydata= (ArrayList<MyPojo>) getIntent().getSerializableExtra("mydata");
        Log.e("mydata",""+mydata.size());
        r=findViewById(R.id.recycler);
        layoutManager=new LinearLayoutManager(NewsActivity.this,RecyclerView.VERTICAL,false);
        r.setLayoutManager(layoutManager);
        AdapterActivity adapterActivity=new AdapterActivity(NewsActivity.this,mydata);
        r.setAdapter(adapterActivity);
    }
}