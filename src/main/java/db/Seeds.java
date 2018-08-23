package db;


import models.Article;
import models.Category;
import models.Journalist;
import models.Location;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Seeds {
    public static void seedData() {
        // -------------------------Seed Categories ---------------------------------------------------

        Category categoryCrime = new Category("Crime");
        DBHelper.save(categoryCrime);
       // -------------------------Seed Journalists----------------------------------------------------
        Journalist journalistMonkey86 = new Journalist("Monkey 86","Drove to Spain after nicking a car from a magician he used to work for");
        DBHelper.save(journalistMonkey86); // OK
        Journalist alfredTheMonkey = new Journalist("Alfred The Monkey","Intercepted a bank robber(mid-heist) and made off with his loot before returning to his zoo to try and negotiate the release of the other chimps");
        DBHelper.save(alfredTheMonkey); //OK
        Journalist marty = new Journalist("Marty","The web-using monkey you can supposedly have a chat with over the internet");
        DBHelper.save(marty); //OK
        Journalist ham  = new Journalist("Ham","The first monkey to be sent into space. According to Karl, when he pressed the 'left button' he gets a banana. Also, according to Karl, within the spaceship there are left, right, and reverse buttons");
        DBHelper.save(ham); //OK
        Journalist jack  = new Journalist("Jack"," a monkey (actually a baboon) that got pal-ly with a bloke who worked in a railway station. Jack took over when the bloke lost a leg");
        DBHelper.save(jack); //OK
        Journalist jenny  = new Journalist("Jenny", "The New York Fire Department's Monkey");
        DBHelper.save(jenny); //OK
        Journalist enos  = new Journalist("Enos","The second monkey to go into space, following Ham's successful mission. In real life, the rocket did not sustain proper altitude and the mission had to be aborted so Enos was returned safely to Earth. In Karl's world, the two buttons became reversed so the one for everything else began dispensing bananas. Fortunately, Enos figured it out and is now living in a monkey retirement home with Ham and all the other Chmiponauts, talking about the old times and that");
        DBHelper.save(enos);  // TOO LONG
        Journalist ollieTheChimp  = new Journalist("Ollie The Chimp", "Ollie was a chimpanzee suspected to be a missing link between humans and apes. In Karl's world, Ollie befriended a zoo-keeper who took him out for dinners and eventually let him live with him. Ollie would start the day with a cuppa tea, end on a brandy, and in the end of the story run off with the zoo-keeper's wife, leaving him a lonely divorcee.");
        DBHelper.save(ollieTheChimp);  // TOO LONG



        // -------------------------Seed Date----------------------------------------------------------

        Date currentDate = new Date();
        Date myDate = parseDate("2014-12-25 13:45");

        // -------------------------Seed Article---------------------------------------------------
        Location testLocation = new Location("tetsLocation");
        DBHelper.save(testLocation);
        Article articleTest = new Article("Test", journalistMonkey86, categoryCrime, testLocation, "test test test","Test content",myDate);
        DBHelper.save(articleTest);


    }
    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
    }