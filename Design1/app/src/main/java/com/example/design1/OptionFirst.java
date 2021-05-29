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
    ArrayList<Books> booksToDisplay  = new ArrayList<>();


    public class BookAdapter extends ArrayAdapter<Books> {
        private static class ViewHolder{
            public ImageView ivCover;
            public TextView tvTitle;
            public TextView tvAuthor;
        }
        public BookAdapter(Context context, ArrayList<Book> aBooks){
            super(context, 0, aBooks); }
        //translates a particular 'Book' given a position
        //into a relevant row within an AdapterView
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            //get the data item for this position
            final Book book = getItem(position);
            //check if an existing view is being reused, otherwise inflate the
            view
            ViewHolder viewHolder;
            if (convertView == null){
                viewHolder = new ViewHolder();
                LayoutInflater inflater =
                        (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVIC
                                E);
                convertView = inflater.inflate(R.layout.item_book,parent,false);
                viewHolder.ivCover =
                        (ImageView)convertView.findViewById(R.id.ivBookCover);
                viewHolder.tvTitle =
                        (TextView)convertView.findViewById(R.id.tvTitle);
                viewHolder.tvAuthor =
                        (TextView)convertView.findViewById(R.id.tvAuthor);
                convertView.setTag(viewHolder);
            } else{
                viewHolder = (ViewHolder) convertView.getTag();
            }
            //Populate the data into the template view using the data object
            viewHolder.tvTitle.setText(book.getTitle());
            viewHolder.tvAuthor.setText(book.getAuthor());
            int resID = book.getCover();
            viewHolder.ivCover.setImageResource(resID);
            return convertView;
        }
    }











    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option_first);
        Intent thisIntent = getIntent();
        booksToDisplay = (ArrayList<Books>) thisIntent.getSerializableExtra("list");
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