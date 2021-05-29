package com.example.design1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class OptionFirst extends AppCompatActivity {

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