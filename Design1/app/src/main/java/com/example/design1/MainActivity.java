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

    public static final String BOOK_DETAIL_KEY = "book";
    ListView lvBooks;
    BookAdapter bookAdapter;
    ArrayList<Books> eng,med,law;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        BookProvider.generateData();
//        eng = BookProvider.eng;
//        med = BookProvider.med;
//        law = BookProvider.law;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ArrayList<Books> aBooks = new ArrayList<Books>();
//        aBooks.addAll(eng);
//        aBooks.addAll(med);
//        aBooks.addAll(law);
//        bookAdapter = new BookAdapter(this, aBooks);
//        lvBooks = (ListView)findViewById(R.id.lViewBooks);
//        lvBooks.setAdapter(bookAdapter);
//        LinearLayoutManager lm = new LinearLayoutManager(this);


    }

    public void onCart(View view){
        Intent cart = new Intent(this, Cart.class);
        startActivity(cart);
    }
    public void onFirst(View view){
        Intent optionFirst = new Intent(this, OptionFirst.class);
        optionFirst.putExtra("toDisplay", BookProvider.eng);
        setContentView(R.layout.option_first);
        startActivity(optionFirst);
    }
    public void onSecond(View view){
        Intent optionFirst = new Intent(this, OptionFirst.class);
        optionFirst.putExtra("toDisplay", BookProvider.law);
        startActivity(optionFirst);
    }
    public void onThird(View view){
        Intent optionFirst = new Intent(this, OptionFirst.class);
        optionFirst.putExtra("toDisplay", BookProvider.med);
        startActivity(optionFirst);
    }

    public void searchBook (String searchTerm){
        BookProvider.search.clear();
        for (Books book: BookProvider.eng){
            if (nameMatch(book.getTitle(),searchTerm)){
                BookProvider.search.add(book);
            }
        }
        for (Books book: BookProvider.med){
            if (nameMatch(book.getTitle(),searchTerm)){
                BookProvider.search.add(book);
            }
        }
        for (Books book: BookProvider.law){
            if (nameMatch(book.getTitle(),searchTerm)){
                BookProvider.search.add(book);
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