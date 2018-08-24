package db;


import models.Article;
import models.Category;
import models.Journalist;
import models.Location;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

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

        GregorianCalendar currentDate = new GregorianCalendar();
        //Date myDate = parseDate("2014-12-25 13:45");
        //Date dateS01E01 = parseDate("2005-12-05 17:55");
        //Date dateS01E01 = new Calendar.DATE;
        //GregorianCalendar dateS01e01 = new GregorianCalendar(2005, Calendar.DECEMBER, 05);
        //java.util.Date dateS01E01 = new java.util.Date("05/12/2005");
        //LocalDate dateS01E01 = LocalDate.of(2005, 12, 05);
        //Date date = new GregorianCalendar(year, month, day).getTime();
        //DateTime S01E01 =  new DateTime;
        //GregorianCalendar dateS01E01 = new GregorianCalendar(2005,11,12, 12,30,00);
        GregorianCalendar dateS01E01 =  new GregorianCalendar(2005,11,5,16,30,00);
        GregorianCalendar dateS01E02 =  new GregorianCalendar(2005,11,12,16,30,00);
        GregorianCalendar dateS01E03 =  new GregorianCalendar(2005,11,19,16,30,00);
        GregorianCalendar dateS01E04 =  new GregorianCalendar(2005,11,26,16,30,00);
        GregorianCalendar dateS01E05 =  new GregorianCalendar(2006,0,2,16,30,00);
        GregorianCalendar dateS01E06 =  new GregorianCalendar(2006,0,9,16,30,00);
        GregorianCalendar dateS01E07 =  new GregorianCalendar(2006,0,16,16,30,00);
        GregorianCalendar dateS01E08 =  new GregorianCalendar(2006,0,23,16,30,00);
        GregorianCalendar dateS01E09 =  new GregorianCalendar(2006,0,30,16,30,00);
        GregorianCalendar dateS01E10 =  new GregorianCalendar(2006,1,6,16,30,00);
        GregorianCalendar dateS01E011 = new GregorianCalendar(2006,1,13,16,30,00);
        GregorianCalendar dateS01E012 = new GregorianCalendar(2006,1,20,16,30,00);
//        Date dateS01e03 = new Date(2005,11,19);
//        Date dateS01e04 = new Date(2005,11,26);
//        Date dateS01e05 = new Date(2006,00,02);
//        Date dateS01e06 = new Date(2006,00,9);
//        Date dateS01e07 = new Date(2006,00,16);
//        Date dateS01e08 = new Date(2006,00,23);
//        Date dateS01e09 = new Date(2006,00,30);
//        Date dateS01e10 = new Date(2006,00,06);
//        Date dateS01e11 = new Date(2006,01,13);
//        Date dateS01e12 = new Date(2006,01,20);

        // -------------------------Seed Article---------------------------------------------------
//        Article articleTest = new Article("Test", journalistMonkey86, categoryCrime, testLocation,currentDate,"test test test","Test content");
//        DBHelper.save(articleTest);
//Article(String title, Journalist journalist, Category category, Location location, String headline, String content, Date timeStamp)
        Article articles01e01 = new Article("Monkey In space", alfredTheMonkey, categoryOuterSpace,locationOuterSpace,dateS01E01,
                "Monkey wasn't allowed to go back in space, ends up committing suicide because couldn't reach the buzz similar to space traveling any other way",
                "Ricky introduces the regular feature, Monkey News. Steve cues the jingle and Ricky obliges. Karl begins to speak of the first thing in space -- Armstrong gets the glory, but there was a monkey first (Note: His actual name was Ham). Laika the dog is mentioned, but Karl dismisses it. The banana dispenser is explained in full. Karl parries all of Steve and Ricky's initial inquiries and moves on. After the monkey launches the rocket, he begins his journey into space. The mission is accomplished and he reverses back to Earth. The celebration is short-lived, because the monkey was never able to return to space, grew despondent (as evidenced by its demeanour) and eventually killed itself. Ricky dismisses all of this as absolute bollocks.");
        DBHelper.save(articles01e01);

        Article articles01e02 = new Article("Monkey Bargain Hunter", marty, categoryBusiness,locationLocal,dateS01E02,
                "Monkey Bargain hunter","Karl speaks of an experiment where monkeys are taught the value of money in San Francisco. The monkeys were given about five quid. Some came back with little. The last one came back with a lot, so the receipts were examined. Apparently, he went for the slightly older food that was cheaper. Ricky is not having it and berates Karl.Karl speaks of an experiment where monkeys are taught the value of money in San Francisco. The monkeys were given about five quid. Some came back with little. The last one came back with a lot, so the receipts were examined. Apparently, he went for the slightly older food that was cheaper. Ricky is not having it and berates Karl.");
        DBHelper.save(articles01e02);

        Article articles01e03 = new Article("Monkey Sanctuary Hunter", ham, categoryFakeNews,locationZoo,dateS01E03,
                "Monkey Sanctuary where women workers were encouraged to bare their breasts to the gorillas","This news story is about a monkey sanctuary where monkeys go if they don't like the zoo. One of the chimps wanted to mess about with the woman's breasts that worked there. She wasn't having it, but her boss told her to carry on despite the harassment. Rick denies any truth to the story, but Karl insists it's true and says he'll post the article. In the end the woman was sacked.");
        DBHelper.save(articles01e03);

        Article articles01e04 = new Article("Monkey chat show", jack, categoryPropaganda,locationWorld,dateS01E04,
                "Monkey hosts chat show in Moscow"," In Moscow, there is a TV channel that went through a load of redundancies. As a chat show was about to go live, the crew realised they had no one to present. For some reason, there was a chimp knocking about. They popped the chimp into a suit and he presented the show. Karl isn't sure how the chimp asked questions, but it went all right. Steve suggests Cher is on the show, and Karl carries on about how Cher loved the chimp and it was one of the best interviews she'd ever been part of. The chimp stayed on.");
        DBHelper.save(articles01e04);
        Article articles01e05 = new Article("Monkey Lives With Zoo Keeper", ollieTheChimp, categoryFakeNews,locationZoo,dateS01E05,
                "Monkey starts acting like a human person, starts hitting on zoo keeper's wife, ends up living with zoo keeper's wife","Oliver the Humanzee, the chimp who was a bit lonely in the zoo as there was no other monkeys and became mates with the zoo keeper. As time went on he started helping the zoo keeper with his work. After a while, the monkey moved in with the zoo keeper... and trouble ensues.");
        DBHelper.save(articles01e05);

        Article articles01e06 = new Article("NYFD Monkey", enos, categoryLocalHero,locationWorld,dateS01E06,
                "Monkey from NYFD saves people from burning building"," involves a skyscraper fire in New York and a short little hero with long hairy arms. DJ ReachAround presents a dance mix version of I Could Eat a Knob at Night.");
        DBHelper.save(articles01e06);

        Article articles01e07 = new Article("Monkey on building site", jenny, categoryLocalHero,locationWorld,dateS01E07,
                "Monkey builder goes from building to building just building","While working on a building site, a man is surprised to see a little fella working on the top bit. He is curious why this bloke stays working high up and never comes down, after more investigation, the bloke makes a startling revelation...");
        DBHelper.save(articles01e07);

        Article articles01e08 = new Article("Monkey Winter Olympics", alfredTheMonkey, categoryObituary,locationWorld,dateS01E08,
                "Monkey crashes bobsled during Winter Olympics...","Monkey crashes bobsled during Winter Olympics because of photographers' cameras flashes, is taken by an ambulance, ends up in zoo with some sort of neck guard");
        DBHelper.save(articles01e08);






    }





    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
    }