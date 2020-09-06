package com.example.newsapi1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  String Url="https://newsapi.org/v2/top-headlines?country=in&apiKey=6038096e326042aa888c4242383dcc58";
  ArrayList<MyPojo> myPojos = new ArrayList<MyPojo>();
  RequestQueue requestQueue;
  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue= Volley.newRequestQueue(MainActivity.this);
      ProgressDialog progressDialog = new ProgressDialog(this);
      progressDialog.setMessage("Loading Data");
      progressDialog.show();
      JsonObjectRequest myrequest=new JsonObjectRequest(Request.Method.GET, Url, new JSONObject(), new Response.Listener<JSONObject>() {
          @Override
          public void onResponse(JSONObject response) {
//           Log.e("Result",response.toString());

              try {
//                  String s=response.getString("status");
//                  Log.e("status",s);
                  JSONArray jsonArray=response.getJSONArray("articles");
                  for(int i=0;i<jsonArray.length();i++)
                  {
                      JSONObject obj=jsonArray.getJSONObject(i);
                      String author=obj.getString("author");
                      String title=obj.getString("title");
                      String description=obj.getString("description");
                      String urltoimg=obj.getString("urlToImage");
//                      Log.e("author",author);
//                      Log.e("title",title);
//                      Log.e("description",description);
                      JSONObject obj1= obj.getJSONObject("source");
                      String name=obj1.getString("name");
//                      Log.e("name",obj1.getString("name"));
                         MyPojo myPojo=new MyPojo();

                         myPojo.setName(name);
                        myPojo.setAuthor(author);
                         myPojo.setTitle(title);
                         myPojo.setImageUrl(urltoimg);
                      myPojo.setDescription(description);
                         myPojos.add(myPojo);

                  }
                Intent i = new Intent(MainActivity.this,NewsActivity.class);
                  i.putExtra("mydata",myPojos);
                  startActivity(i);
              } catch (JSONException e) {
                  e.printStackTrace();
              }

          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
              Toast.makeText(MainActivity.this," "+error.getMessage(),Toast.LENGTH_LONG).show();
          }
      });
      requestQueue.add(myrequest);

    }
}