package com.example.newsapi1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

public class AdapterActivity extends RecyclerView.Adapter<AdapterActivity.ViewHolder> {

    Context context;
   ArrayList<MyPojo> myPojos= new ArrayList<>();

    public AdapterActivity(Context context,ArrayList<MyPojo> myPojos) {
        this.context = context;
        this.myPojos=myPojos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adapter,null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)  {
//        MyPojo myPojo= myPojos.get(position);
      holder.author.setText(myPojos.get(position).getAuthor());
      holder.name.setText(myPojos.get(position).getName());
      holder.title.setText(myPojos.get(position).getTitle());
      holder.desc.setText(myPojos.get(position).getDescription());
      Picasso.with(context).load(myPojos.get(position).getImageUrl()).into(holder.img);
       }

    @Override
    public int getItemCount() {
        return myPojos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView author,name,title,desc;
        private ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            author=itemView.findViewById(R.id.author_name);
            name=itemView.findViewById(R.id.name);
            title=itemView.findViewById(R.id.title);
            desc=itemView.findViewById(R.id.description);
            img=itemView.findViewById(R.id.imageView);
            img.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int position= this.getAdapterPosition();
            MyPojo myPojo=myPojos.get(position);
            String name=myPojo.getName();
            String author=myPojo.getAuthor();
            String title=myPojo.getTitle();
            String des=myPojo.getDescription();
            String url=myPojo.getImageUrl();
            Intent i = new Intent(view.getContext(),MainActivity2.class);
            i.putExtra("name",name);
            i.putExtra("author",author);
            i.putExtra("title",title);
            i.putExtra("desc",des);
            i.putExtra("photo",url);

            context.startActivity(i);


        }
    }
}