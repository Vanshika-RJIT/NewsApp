package com.example.newsapi1;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity2 extends AppCompatActivity {
   ImageView i;
   TextView Name,Title,Description,Author;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String name=getIntent().getStringExtra("name");
        String title=getIntent().getStringExtra("title");
        String author=getIntent().getStringExtra("author");
        String desc= getIntent().getStringExtra("desc");
        String photo=getIntent().getStringExtra("photo");
        i=findViewById(R.id.Photo);
        Name=findViewById(R.id.name);
        Title=findViewById(R.id.title);
        Description=findViewById(R.id.desc);
        Author=findViewById(R.id.author);
        Picasso.with(getApplicationContext()).load(photo).into(i);
        Name.setText(name);
        Title.setText(title);
        Description.setText(desc);
        Author.setText(author);
    }
}