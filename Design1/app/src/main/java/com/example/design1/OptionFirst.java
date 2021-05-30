package com.example.design1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class OptionFirst extends AppCompatActivity {

    public static final String BOOKS_DETAIL_KEY = "books";

    String displayType;
    ArrayList<Books> booksToDisplay  = new ArrayList<>();
    ArrayList<Books> eng, med, law;
    BookAdapter bookAdapter;
    ListView lvBooks;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option_first);
        Intent thisIntent = getIntent();
        BookProvider.generateData();
        eng = BookProvider.eng;
        med = BookProvider.med;
        law = BookProvider.law;

        ArrayList<Books> aBooks = new ArrayList<Books>();
        aBooks.addAll(eng);
        aBooks.addAll(med);
        aBooks.addAll(law);
        bookAdapter = new BookAdapter(this, aBooks);
        lvBooks = (ListView)findViewById(R.id.lViewBooks);
        lvBooks.setAdapter(bookAdapter);
        LinearLayoutManager lm = new LinearLayoutManager(this);

        setupBookSelectedListener();


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

    public void setupBookSelectedListener(){
        lvBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(OptionFirst.this, BookDetailedActivity.class);
                intent.putExtra(BOOKS_DETAIL_KEY, bookAdapter.getItem(position));
                startActivity(intent);
            }
        });
    }
}