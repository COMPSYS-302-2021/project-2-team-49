package com.example.design1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class Books {
    String name;
    String author;
    int viewed;
    char genre;
    String id;
    int pic;

    public Books (String name, String author, int viewed, char genre, String id, int pic){
        this.name = name;
        this.author = author;
        this.viewed = viewed;
        this.genre = genre;
        this.pic = pic;
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
}



class BookProvider{
    static String[] titles = {"Space Marines", "Raven Guard", "Fundamentals of Thermal-Fluid Sciences",
            "Mechanical Engineering Design", "Electrical Engineering", "Chemicals and Materials",
            "Rocket Propulsion Elements","Essential Mathematics for Engineers","Bridge Building 101", "Biomedical",
            "Heart", "Lungs", "Liver", "Stomach", "Brain","Kidney (bean)", "Pancreas", "Gall Bladder","Intestines",
            "Anal Canal","Robbery", "Chose and Action", "Case Closed", "Fiduciary Obligations", "Breaches",
            "Conflict of Interests", "Order in the Court", "Agency","Negligent Misstatement ","the Doctrine of Indefeasibility"};

    static String[] ids = {"001", "002", "003", "004", "005", "006", "007",
            "008", "009", "010", "011", "012", "013", "014", "015", "016", "017",
            "018", "019", "020","021", "022", "023", "024", "025", "026", "027",
            "028", "029", "030"};

    static String[] authors = {"Jane Austen", "William Shakespeare",
            "William Shakespeare", "William Shakespeare", "William Shakespeare", "Arthur Golden",
            "Jane Austen", "Tony Hawk", "William Shakespeare", "Walter Dean Myers","Jane Austen", "William Shakespeare",
            "William Shakespeare", "William Shakespeare", "William Shakespeare", "Arthur Golden",
            "Jane Austen", "Tony Hawk", "William Shakespeare", "Walter Dean Myers","Jane Austen", "William Shakespeare",
            "William Shakespeare", "William Shakespeare", "William Shakespeare", "Arthur Golden",
            "Jane Austen", "Tony Hawk", "William Shakespeare", "Walter Dean Myers"};

    //image path of book covers in the drawable folder
    static int[] coveraddrs = {R.drawable.b100};
    static ArrayList<Books> eng  = new ArrayList<>();
    static ArrayList<Books> law  = new ArrayList<>();
    static ArrayList<Books> med  = new ArrayList<>();
    static ArrayList<Books> search  = new ArrayList<>();

    public void  generateData() {
        for (int i = 0; i < 30; i++) {
            String id = ids[i];
            String author = authors[i];
            String title = titles[i];
            int coveraddr = coveraddrs[0];
            int views = 5;
            if (i<10){
                Books aBook = new Books(title,author,views,'e',id,coveraddr);
                eng.add(aBook);
            }else if (i<20){
                Books aBook = new Books(title,author,views,'m',id,coveraddr);
                med.add(aBook);
            }else{
                Books aBook = new Books(title,author,views,'l',id,coveraddr);
                law.add(aBook);
            }


        }
    }
}

public class MainActivity extends AppCompatActivity {
    class ViewHolder{

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
        optionFirst.putExtra("toDisplay", BookProvider.eng);
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
            if (nameMatch(book.getName(),searchTerm)){
                BookProvider.search.add(book);
            }
        }
        for (Books book: BookProvider.med){
            if (nameMatch(book.getName(),searchTerm)){
                BookProvider.search.add(book);
            }
        }
        for (Books book: BookProvider.law){
            if (nameMatch(book.getName(),searchTerm)){
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