package com.example.design1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class OptionFirst extends AppCompatActivity {

    String displayType;
    ArrayList<MainActivity.Books> booksToDisplay  = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option_first);
        Intent thisIntent = getIntent();
        booksToDisplay = (ArrayList<MainActivity.Books>) thisIntent.getSerializableExtra("list");
        https://stackoverflow.com/questions/8109867/array-list-of-objects-via-intent

        if (displayType.equals('e')){

        }else if (displayType.equals('l')){

        }else if (displayType.equals('m')){

        }else if (displayType.equals('s')){

        }


    }
    public void onHome(View view) {
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }

    public void displayEngineering(){

    }
    public void displayLaw(){

    }
    public void displayMed(){

    }
    public void displaySearch(){

    }

    public void onCart(View view) {
        Intent cart = new Intent(this, Cart.class);
        startActivity(cart);
    }
}