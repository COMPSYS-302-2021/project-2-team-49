package com.example.design1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.Scanner;


public class MainActivity extends AppCompatActivity {

    public static final String BOOKS_DETAIL_KEY = "books";

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
        Intent optionFirst = new Intent(this, OptionSecond.class);
        startActivity(optionFirst);
    }
    public void onThird(View view){
        Intent optionFirst = new Intent(this, OptionThird.class);
        startActivity(optionFirst);
    }
}