package com.example.design1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    class ViewHolder{

    }
    class Books {
        String name;
        String author;
        int viewed;
        char genre;
        int id;
        int isbn;
        String pic;
        String blurb;
        List<Books> eng  = new ArrayList<>();
        List<Books> law  = new ArrayList<>();
        List<Books> med  = new ArrayList<>();
        public Books (String name, String author, int viewed, char genre,int id, int isbn, String pic, String blurb){
            this.name = name;
            this.author = author;
            this.viewed = viewed;
            this.genre = genre;
            this.isbn = isbn;
            this.pic = pic;
            this.blurb = blurb;
            this.id = id;
            if (genre == 'e'){
                eng.add(this);
            }
            else if (genre == 'l'){
                law.add(this);
            }
            else{
                med.add(this);
            }
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCart(View view){
        Intent cart = new Intent(this, Cart.class);
        startActivity(cart);
    }
    public void onFirst(View view){
        Intent optionFirst = new Intent(this, OptionFirst.class);
        startActivity(optionFirst);
    }
    public void onSecond(View view){
        Intent optionSecond = new Intent(this, OptionSecond.class);
        startActivity(optionSecond);
    }
    public void onThird(View view){
        Intent optionThird = new Intent(this, OptionThird.class);
        startActivity(optionThird);
    }


}