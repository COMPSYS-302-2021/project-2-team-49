package com.example.design1;

import java.util.ArrayList;

public class BookProvider {
    static String[] titles = {"Space Marines", "Raven Guard", "Fundamentals of Thermal-Fluid Sciences",
            "Mechanical Engineering Design", "Electrical Engineering", "Chemicals and Materials",
            "Rocket Propulsion Elements", "Essential Mathematics for Engineers", "Bridge Building 101", "Biomedical",
            "Heart", "Lungs", "Liver", "Stomach", "Brain", "Kidney (bean)", "Pancreas", "Gall Bladder", "Intestines",
            "Anal Canal", "Robbery", "Chose and Action", "Case Closed", "Fiduciary Obligations", "Breaches",
            "Conflict of Interests", "Order in the Court", "Agency", "Negligent Misstatement ", "the Doctrine of Indefeasibility"};

    static String[] ids = {"001", "002", "003", "004", "005", "006", "007",
            "008", "009", "010", "011", "012", "013", "014", "015", "016", "017",
            "018", "019", "020", "021", "022", "023", "024", "025", "026", "027",
            "028", "029", "030"};

    static String[] authors = {"Jane Austen", "William Shakespeare",
            "William Shakespeare", "William Shakespeare", "William Shakespeare", "Arthur Golden",
            "Jane Austen", "Tony Hawk", "William Shakespeare", "Walter Dean Myers", "Jane Austen", "William Shakespeare",
            "William Shakespeare", "William Shakespeare", "William Shakespeare", "Arthur Golden",
            "Jane Austen", "Tony Hawk", "William Shakespeare", "Walter Dean Myers", "Jane Austen", "William Shakespeare",
            "William Shakespeare", "William Shakespeare", "William Shakespeare", "Arthur Golden",
            "Jane Austen", "Tony Hawk", "William Shakespeare", "Walter Dean Myers"};

    //image path of book covers in the drawable folder
    static int[] coveraddrs = {R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001,};
    static ArrayList<Books> eng = new ArrayList<>();
    static ArrayList<Books> law = new ArrayList<>();
    static ArrayList<Books> med = new ArrayList<>();
    static ArrayList<Books> search = new ArrayList<>();

    public static void generateData() {
        if (eng.isEmpty() && med.isEmpty() && law.isEmpty()) {
            for (int i = 0; i < 30; i++) {
                String id = ids[i];
                String author = authors[i];
                String title = titles[i];
                int coveraddr = coveraddrs[0];
                int views = 5;
                if (i < 10) {
                    Books aBook = new Books(title, author, views, 'e', id, coveraddr);
                    eng.add(aBook);
                } else if (i < 20) {
                    Books aBook = new Books(title, author, views, 'm', id, coveraddr);
                    med.add(aBook);
                } else {
                    Books aBook = new Books(title, author, views, 'l', id, coveraddr);
                    law.add(aBook);
                }


            }
        }
    }
}
