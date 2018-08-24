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
        Category categoryEnvironmental = new Category("Environmental");
        DBHelper.save(categoryEnvironmental);
        Category categoryObituary = new Category("Obituary");
        DBHelper.save(categoryObituary);
        Category categoryLocal = new Category("Local");
        DBHelper.save(categoryLocal);
        Category categoryPropaganda = new Category("Propaganda");
        DBHelper.save(categoryPropaganda);
        Category categoryFakeNews = new Category("FakeNews");
        DBHelper.save(categoryFakeNews);
        Category categoryOuterSpace = new Category("Outer Space");
        DBHelper.save(categoryOuterSpace);
        Category categoryLocalHero = new Category("Local Hero");
        DBHelper.save(categoryLocalHero);
        Category categoryPolitics = new Category("Politics");
        DBHelper.save(categoryPolitics);
        Category categoryTech = new Category("Tech");
        DBHelper.save(categoryTech);
        Category categoryScience = new Category("Science");
        DBHelper.save(categoryScience);
        Category categoryBusiness = new Category("Business");
        DBHelper.save(categoryBusiness);

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
        // -------------------------Seed Locations-----------------------------------------------------
        Location testLocation = new Location("testLocation");
        DBHelper.save(testLocation);
        Location locationLocal = new Location("Local");
        DBHelper.save(locationLocal);
        Location locationUK = new Location("UK");
        DBHelper.save(locationUK);
        Location locationOuterSpace = new Location("Outer Space");
        DBHelper.save(locationOuterSpace);
        Location locationWorld = new Location("World");
        DBHelper.save(locationWorld);
        Location locationZoo = new Location("Zoo");
        DBHelper.save(locationZoo);


        // -------------------------Seed Date----------------------------------------------------------

        Date currentDate = new Date();
        Date myDate = parseDate("2014-12-25 13:45");
        Date dateS01e01 = new Date(2005,12,05);
//        Date dateS01e02 = new Date(2005,12,12);
//        Date dateS01e03 = new Date(2005,12,19);
//        Date dateS01e04 = new Date(2005,12,26);
//        Date dateS01e05 = new Date(2006,01,02);
//        Date dateS01e06 = new Date(2006,01,9);
//        Date dateS01e07 = new Date(2006,01,16);
//        Date dateS01e08 = new Date(2006,01,23);
//        Date dateS01e09 = new Date(2006,01,30);
//        Date dateS01e10 = new Date(2006,02,06);
//        Date dateS01e11 = new Date(2006,02,13);
//        Date dateS01e12 = new Date(2006,02,20);

        // -------------------------Seed Article---------------------------------------------------
        Article articleTest = new Article("Test", journalistMonkey86, categoryCrime, testLocation,myDate,"test test test","Test content");
        DBHelper.save(articleTest);

//Article(String title, Journalist journalist, Category category, Location location, String headline, String content, Date timeStamp)
        Article articles01e01 = new Article("Monkey In space", alfredTheMonkey, categoryOuterSpace,locationOuterSpace,dateS01e01,
                "Monkey wasn't allowed to go back in space, ends up committing suicide because couldn't reach the buzz similar to space traveling any other way",
                "Ricky introduces the regular feature, Monkey News. Steve cues the jingle and Ricky obliges. Karl begins to speak of the first thing in space -- Armstrong gets the glory, but there was a monkey first (Note: His actual name was Ham). Laika the dog is mentioned, but Karl dismisses it. The banana dispenser is explained in full. Karl parries all of Steve and Ricky's initial inquiries and moves on. After the monkey launches the rocket, he begins his journey into space. The mission is accomplished and he reverses back to Earth. The celebration is short-lived, because the monkey was never able to return to space, grew despondent (as evidenced by its demeanour) and eventually killed itself. Ricky dismisses all of this as absolute bollocks.");
        DBHelper.save(articles01e01);






    }





    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
    }