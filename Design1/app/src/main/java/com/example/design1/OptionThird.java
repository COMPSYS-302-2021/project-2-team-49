package com.example.design1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
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


public class OptionThird extends AppCompatActivity {

    public static final String BOOKS_DETAIL_KEY = "books";

    String displayType;
    ArrayList<Books> booksToDisplay  = new ArrayList<>();
    ArrayList<Books> med;
    BookAdapter bookAdapter, currentAdapter;
    ListView lvBooks;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_third);
        Intent thisIntent = getIntent();
        BookProvider.generateData();
        med = BookProvider.med;

        ArrayList<Books> aBooks = med;

        bookAdapter = new BookAdapter(this, aBooks);
        lvBooks = (ListView)findViewById(R.id.lViewBooks);
        lvBooks.setAdapter(bookAdapter);
        currentAdapter = bookAdapter;

        LinearLayoutManager lm = new LinearLayoutManager(this);

        setupBookSelectedListener();


    }
    public void onHome(View view) {
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }

    public void onCart(View view) {
        Intent cart = new Intent(this, Cart.class);
        startActivity(cart);
    }

    public void setupBookSelectedListener(){
        lvBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(OptionThird.this, BookDetailedActivity.class);
                intent.putExtra(BOOKS_DETAIL_KEY, currentAdapter.getItem(position));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first_option, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Reset SearchView
                searchView.clearFocus();
                searchView.setQuery("", false);
                searchView.setIconified(true);
                searchItem.collapseActionView();

                ArrayList<Books> tempBookArray = new ArrayList<Books>();

                int bookCount = bookAdapter.getCount();
                for (int i = 0; i < bookCount; i++) {
                    tempBookArray.add(bookAdapter.getItem(i));
                }

                BookAdapter tempAdapter = new BookAdapter(getBaseContext(), tempBookArray);
                tempBookArray = new ArrayList<Books>();

                for (int i = 0; i < tempAdapter.getCount(); i++) {
                    Books currentBook = tempAdapter.getItem(i);
                    String currentTitle = currentBook.getTitle();
                    String currentAuthor = currentBook.getAuthor();
                    Boolean containsQuery = (currentTitle.toLowerCase()).contains(query.toLowerCase()) || (currentAuthor.toLowerCase()).contains(query.toLowerCase());
                    if (!containsQuery) {
                        tempBookArray.add(currentBook);
                    }
                }
                for (int i = 0; i < tempBookArray.size(); i++) {
                    tempAdapter.remove(tempBookArray.get(i));
                }

                lvBooks.setAdapter(tempAdapter);
                currentAdapter = tempAdapter;
                // Set activity title to search query
                OptionThird.this.setTitle(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}