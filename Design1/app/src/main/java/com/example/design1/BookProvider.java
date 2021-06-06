package com.example.design1;

import java.util.ArrayList;

public class BookProvider {
    static String[] titles = {
            "Javascript For Kids",
            "Modern Compiler Design",
            "Fundamentals of Thermal-Fluid Sciences",
            "Mechanical Engineering Design",
            "Electrical Engineering 101",
            "Materials Chemistry",
            "Rocket Propulsion Elements",
            "Essential Mathematics for Engineers and Scientists",
            "Bridge Building 101",
            "Biomedical",

            "Heart Disease",
            "The Lung",
            "A Textbook Of Liver Disease",
            "Diseases Of The Stomach",
            "Physiology Of The Brain",
            "The Kidney",
            "Textbook of Pancreatic Cancer",
            "Diseases of the Gallbladder and Bile Ducts",
            "Textbook of Gastrointestinal Radiology",
            "Principles and Practice of Surgery for the Colon, Rectum, and Anus",

            "Laying Down The Law",
            "Constitutional Law",
            "Essentials of Business Law",
            "Pretrial",
            "Australian Torts Law",
            "Evidence Law and Practice",
            "The Legal and Ethical Environment of Business",
            "Crime and Justice: a guide to Criminology",
            "Acing Contracts: a Checklist Approach to Contracts Law",
            "Forensic Psychology For Dummies"};

    static String[] ids = {"001", "002", "003", "004", "005", "006", "007",
            "008", "009", "010",
            "011", "012", "013", "014", "015", "016", "017",
            "018", "019", "020",
            "021", "022", "023", "024", "025", "026", "027",
            "028", "029", "030"};

    static int[] costs = {
            10, 75, 10, 25, 15, 50, 67, 10, 90, 45,
            10, 75, 10, 25, 15, 50, 67, 10, 90, 45,
            10, 75, 10, 25, 15, 50, 0, 10, 90, 45
    };

    static String[] authors = {
            "Nick Morgan",
            "Dick Grune, Kees van Reeuwijk, Henri E. Bal, Ceriel J.H. Jacobs, Koen Langendoen",
            "Yunus Cengel,John Cimbala, Afshin Ghajar",
            "Joseph Edward Shigley, Charles R. Mischke",
            "Darren Ashby",
            "Bradley D. Fahlman",
            "George Paul Sutton",
            "Thomas J. Pence, Indrek S. Wichman",
            "Walter Dean Myers",
            "Jane Austen",

            "Douglas P. Zipes MD",
            "Kent Pinkerton & Richard Harding",
            "David Zakim MD & Thomas D. Boyer MD",
            "Max Einhorn ",
            "Neil R. Carlson & Melissa A. Birkett",
            "Peter Vize,Adrian S. Woolf, Jonathan Bard",
            "Kjetil Soreide & Stefan Stättner",
            "Pierre-Alain Clavien & John Baillie",
            "Richard Gore & Marc Levine",
            "Philip H. Gordon & Santhat Nivatvongs",


            "Robin Creyke, David Hamer, Patrick John O'Mara, Belinda Smith, Taylor. Tristan",
            "Erwin Chemerinsky",
            "Chandra Gopalan",
            "Thomas A. Mauet",
            "Amanda Stickley",
            "Steven I. Friedland, Paul Bergman, Dustin B. Benham",
            "Terence Lau & Lisa Johnson",
            "de Lint & Palmer Dalton",
            "Suzanne Darrow-Kleinhaus",
            "David V. Canter & Ian Rankin"};

    static String[] blurbs = {
            "JavaScript for kids, title says it all. Well worn through and has been used by kids (so may have some slightly damaged pages) ",
            "Learn how to design a modern compiler. Book in pristine condition, never opened",
            "Recommended for your second year in mechatronics or mechanical. No longer needed   ",
            "”Covering almost all the important machine elements encountered in the machine design course”"+
                    " Quote from the blurb, no longer need the textbook reselling. Would recommend if you do mechanical engineering ",
            " 10/10 – would recommend, this book got me through my degree. Have since graduated so no longer needed. Condition is well worn (as I have used it a lot), but still easily usable.",
            "A second edition book of Materials Chemistry that helped me through part of my degree. Book is in a fairly good condition was recommended the textbook by the lecturer but was barely used.",
            "Brand new, never opened, bought accidentally. ",
            "Condition is well used but still usable",
            "RECOMMENDED FOR CIVIL ENGINEERS. Well used, pages mixing or scribbled on, pricing will reflect that.",
            "No longer need this textbook as I have dropped out. Book is used but not damaged condition.",


            //MED STARTS
            "Used for personal reading not needed for coursework but useful. ",
            "The Lung: useful textbook that was barely used ",
            "Heavily used but not damaged",
            "No longer need this textbook as I have dropped out. Book is used but not damaged condition.",
            "Good Condition. If you pick it up yourself, you can get a 10% discount",
            "Textbook with no marking, almost as good as new.",
            "This textbook was the reason I passed the course. Lol. A must have.",
            "Contains lecture notes for each of the lectures. Neat and in good condition.",
            "You’ll be Penge’d anyway might as well get the textbook as well",
            "Must have, really detailed with handwritten notes attached separately, Neat condition, not scribbling",

            // LAW
            "Has detailed case studies to explain different scenarios precisely. A must have for the course. ",
            "Explains the constitutional law. Handwritten explanation for each law. In not the best condition but have reduced the price.",
            "Not that useful but a must have if you are really interested in the subject.",
            "So much reading but this textbook is not like other books. Has high level definitions to make studying easier",
            "Didn’t attend or watch one single lecture still got a solid B by just reading this book. Save your time and do this.",
            "Heavily used, pages falling out, but text still intact so useable. Detachable pages are in their correct space.",
            "This is an ebook, that I got, willing to give away for free",
            "Good condition, with post it notes stuck around, might be scribbles in some places. I have tried to remove most of them.",
            "This was helpful cause lectures sucked",
            "Didn’t want to be a Doctor don’t know why have to learn about this stuff but this book kind of makes sense, so yeah"


    };
    //image path of book covers in the drawable folder
    static int[] coveraddrs1 = {R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001,
                                R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001,
                                R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001};

    static int[] coveraddrs2 = {R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001,
                                R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001,
                                R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001};

    static int[] coveraddrs3 = {R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001,
                                R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001,
                                R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001, R.drawable.b001};

    static ArrayList<Books> eng = new ArrayList<>();
    static ArrayList<Books> law = new ArrayList<>();
    static ArrayList<Books> med = new ArrayList<>();

    public static void generateData() {
        if (eng.isEmpty() && med.isEmpty() && law.isEmpty()) {
            for (int i = 0; i < 30; i++) {
                //Book info assignment
                String id = ids[i];
                String author = authors[i];
                String title = titles[i];
                int cost = costs[i];
                String blurb = blurbs[i];
                int coveraddr[] = {coveraddrs1[i], coveraddrs2[i], coveraddrs3[i]};
                int views = 5;


                if (i < 10) {
                    Books aBook = new Books(title, author, views, 'e', id, cost, blurb, coveraddr);
                    eng.add(aBook);
                } else if (i < 20) {
                    Books aBook = new Books(title, author, views, 'm', id, cost, blurb, coveraddr);
                    med.add(aBook);
                } else {
                    Books aBook = new Books(title, author, views, 'l', id, cost, blurb, coveraddr);
                    law.add(aBook);
                }


            }
        }
    }
}
