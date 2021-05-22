package com.example.design1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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
        public String getName(){
            return this.name;
        }


    }
    ArrayList<Books> eng  = new ArrayList<>();
    ArrayList<Books> law  = new ArrayList<>();
    ArrayList<Books> med  = new ArrayList<>();
    ArrayList<Books> search  = new ArrayList<>();

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
        optionFirst.putExtra("toDisplay", eng);
        startActivity(optionFirst);
    }
    public void onSecond(View view){
        Intent optionFirst = new Intent(this, OptionFirst.class);
        optionFirst.putExtra("toDisplay", law);
        startActivity(optionFirst);
    }
    public void onThird(View view){
        Intent optionFirst = new Intent(this, OptionFirst.class);
        optionFirst.putExtra("toDisplay", med);
        startActivity(optionFirst);
    }

    public void searchBook (String searchTerm){
        search.clear();
        for (Books book: eng){
            if (nameMatch(book.getName(),searchTerm)){
                search.add(book);
            }
        }
    }

    public boolean nameMatch(String name,String search){
        if (name.contains(search)){
            return true;
        }
        return false;
    }


}