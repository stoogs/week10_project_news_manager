package db;


import models.Article;
import models.Category;
import models.Journalist;
import models.Location;
import org.apache.commons.lang.ObjectUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;


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
        Journalist journalistMonkey86 = new Journalist("Monkey 86", "Drove to Spain after nicking a car from a magician he used to work for");
        DBHelper.save(journalistMonkey86); // OK
        Journalist alfredTheMonkey = new Journalist("Alfred The Monkey", "Intercepted a bank robber(mid-heist) and made off with his loot before returning to his zoo to try and negotiate the release of the other chimps");
        DBHelper.save(alfredTheMonkey); //OK
        Journalist marty = new Journalist("Marty", "The web-using monkey you can supposedly have a chat with over the internet");
        DBHelper.save(marty); //OK
        Journalist ham = new Journalist("Ham", "The first monkey to be sent into space. According to Karl, when he pressed the 'left button' he gets a banana. Also, according to Karl, within the spaceship there are left, right, and reverse buttons");
        DBHelper.save(ham); //OK
        Journalist jack = new Journalist("Jack", " a monkey (actually a baboon) that got pal-ly with a bloke who worked in a railway station. Jack took over when the bloke lost a leg");
        DBHelper.save(jack); //OK
        Journalist jenny = new Journalist("Jenny", "The New York Fire Department's Monkey");
        DBHelper.save(jenny); //OK
        Journalist enos = new Journalist("Enos", "The second monkey to go into space, following Ham's successful mission. In real life, the rocket did not sustain proper altitude and the mission had to be aborted so Enos was returned safely to Earth. In Karl's world, the two buttons became reversed so the one for everything else began dispensing bananas. Fortunately, Enos figured it out and is now living in a monkey retirement home with Ham and all the other Chmiponauts, talking about the old times and that");
        DBHelper.save(enos);  // TOO LONG
        Journalist ollieTheChimp = new Journalist("Ollie The Chimp", "Ollie was a chimpanzee suspected to be a missing link between humans and apes. In Karl's world, Ollie befriended a zoo-keeper who took him out for dinners and eventually let him live with him. Ollie would start the day with a cuppa tea, end on a brandy, and in the end of the story run off with the zoo-keeper's wife, leaving him a lonely divorcee.");
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
        List<Location> tester = DBHelper.getAll(Location.class);

        // -------------------------Seed Time & Date----------------------------------------------------------
        GregorianCalendar currentTimeAndDate = new GregorianCalendar();
        GregorianCalendar dateS01E01 = new GregorianCalendar(2018, 7, 03, 07, 35, 00);
        GregorianCalendar dateS01E02 = new GregorianCalendar(2018, 04, 12, 16, 30, 00);
        GregorianCalendar dateS01E03 = new GregorianCalendar(2017, 11, 19, 16, 30, 00);
        GregorianCalendar dateS01E04 = new GregorianCalendar(2018, 03, 22, 16, 30, 00);
        GregorianCalendar dateS01E05 = new GregorianCalendar(2018, 7, 2, 16, 30, 00);
        GregorianCalendar dateS01E06 = new GregorianCalendar(2018, 7, 9, 16, 30, 00);
        GregorianCalendar dateS01E07 = new GregorianCalendar(2018, 7, 16, 16, 30, 00);
        GregorianCalendar dateS01E08 = new GregorianCalendar(2018, 7, 20, 16, 30, 00);
        GregorianCalendar dateS01E09 = new GregorianCalendar(2018, 7, 24, 16, 30, 00);
        GregorianCalendar dateS01E10 = new GregorianCalendar(2018, 4, 6, 16, 30, 00);
        GregorianCalendar dateS01E011 = new GregorianCalendar(2006, 1, 13, 16, 30, 00);
        GregorianCalendar dateS01E012 = new GregorianCalendar(2006, 1, 20, 16, 30, 00);

        // -------------------------Seed Article---------------------------------------------------
        Article articles01e01 = new Article("Monkey In space", alfredTheMonkey, categoryOuterSpace, locationOuterSpace, dateS01E01,
                "Monkey wasn't allowed to go back in space, ends up committing suicide because couldn't reach the buzz similar to space traveling any other way",
                "Ricky introduces the regular feature, Monkey News. Steve cues the jingle and Ricky obliges. Karl begins to speak of the first thing in space -- Armstrong gets the glory, but there was a monkey first (Note: His actual name was Ham). Laika the dog is mentioned, but Karl dismisses it. The banana dispenser is explained in full. Karl parries all of Steve and Ricky's initial inquiries and moves on. After the monkey launches the rocket, he begins his journey into space. The mission is accomplished and he reverses back to Earth. The celebration is short-lived, because the monkey was never able to return to space, grew despondent (as evidenced by its demeanour) and eventually killed itself. Ricky dismisses all of this as absolute bollocks.");
        DBHelper.save(articles01e01);

        Article articles01e02 = new Article("Monkey Bargain Hunter", marty, categoryBusiness, locationLocal, dateS01E02,
                "Monkey Bargain hunter", "Karl speaks of an experiment where monkeys are taught the value of money in San Francisco. The monkeys were given about five quid. Some came back with little. The last one came back with a lot, so the receipts were examined. Apparently, he went for the slightly older food that was cheaper. Ricky is not having it and berates Karl.Karl speaks of an experiment where monkeys are taught the value of money in San Francisco. The monkeys were given about five quid. Some came back with little. The last one came back with a lot, so the receipts were examined. Apparently, he went for the slightly older food that was cheaper. Ricky is not having it and berates Karl.");
        DBHelper.save(articles01e02);

        Article articles01e03 = new Article("Monkey Sanctuary Hunter", ham, categoryFakeNews, locationZoo, dateS01E03,
                "Monkey Sanctuary where women workers were encouraged to bare their breasts to the gorillas", "This news story is about a monkey sanctuary where monkeys go if they don't like the zoo. One of the chimps wanted to mess about with the woman's breasts that worked there. She wasn't having it, but her boss told her to carry on despite the harassment. Rick denies any truth to the story, but Karl insists it's true and says he'll post the article. In the end the woman was sacked.");
        DBHelper.save(articles01e03);

        Article articles01e04 = new Article("Monkey chat show", jack, categoryPropaganda, locationWorld, dateS01E04,
                "Monkey hosts chat show in Moscow", " In Moscow, there is a TV channel that went through a load of redundancies. As a chat show was about to go live, the crew realised they had no one to present. For some reason, there was a chimp knocking about. They popped the chimp into a suit and he presented the show. Karl isn't sure how the chimp asked questions, but it went all right. Steve suggests Cher is on the show, and Karl carries on about how Cher loved the chimp and it was one of the best interviews she'd ever been part of. The chimp stayed on.");
        DBHelper.save(articles01e04);
        Article articles01e05 = new Article("Monkey Lives With Zoo Keeper", ollieTheChimp, categoryFakeNews, locationZoo, dateS01E05,
                "Monkey starts acting like a human person, starts hitting on zoo keeper's wife, ends up living with zoo keeper's wife", "Oliver the Humanzee, the chimp who was a bit lonely in the zoo as there was no other monkeys and became mates with the zoo keeper. As time went on he started helping the zoo keeper with his work. After a while, the monkey moved in with the zoo keeper... and trouble ensues.");
        DBHelper.save(articles01e05);

        Article articles01e06 = new Article("NYFD Monkey", enos, categoryLocalHero, locationWorld, dateS01E06,
                "Monkey from NYFD saves people from burning building", " involves a skyscraper fire in New York and a short little hero with long hairy arms. DJ ReachAround presents a dance mix version of I Could Eat a Knob at Night.");
        DBHelper.save(articles01e06);

        Article articles01e07 = new Article("Monkey on building site", jenny, categoryLocalHero, locationWorld, dateS01E07,
                "Monkey builder goes from building to building just building", "While working on a building site, a man is surprised to see a little fella working on the top bit. He is curious why this bloke stays working high up and never comes down, after more investigation, the bloke makes a startling revelation...");
        DBHelper.save(articles01e07);

        Article articles01e08 = new Article("Monkey Winter Olympics", alfredTheMonkey, categoryObituary, locationWorld, dateS01E08,
                "Monkey crashes bobsled during Winter Olympics...", "Monkey crashes bobsled during Winter Olympics because of photographers' cameras flashes, is taken by an ambulance, ends up in zoo with some sort of neck guard");
        DBHelper.save(articles01e08);
    }

        //-----------------------------------------------------------------------
        public static String storyAge(GregorianCalendar article) {
        GregorianCalendar currentTime = new GregorianCalendar();
            System.out.println(article.get(Calendar.WEEK_OF_MONTH));
            int articleYearsOld = (currentTime.get(Calendar.YEAR) - article.get(Calendar.YEAR));
            int articleMonthsOld = (currentTime.get(Calendar.MONTH) - article.get(Calendar.MONTH));
            int articleWeeksOld = (currentTime.get(Calendar.WEEK_OF_YEAR) - article.get(Calendar.WEEK_OF_YEAR));
            int articleDaysOld = (currentTime.get(Calendar.DAY_OF_WEEK) - article.get(Calendar.DAY_OF_WEEK));
            //If current Time is behind Article time then -ve values occur.
            //TODO This is chaos
            if (articleYearsOld > 0) { articleYearsOld += -1;}
            if (articleWeeksOld > 0) { articleWeeksOld += -52;}
            if (articleMonthsOld > 0) { articleMonthsOld += -12;}
            if (articleDaysOld > 0) { articleDaysOld += -7;}
            String result = articleYearsOld  + " years " + articleMonthsOld + " months " + articleDaysOld + " days old";
            return result;
        }

        public static String storyAgeSimple(GregorianCalendar article) {
            GregorianCalendar currentTime = new GregorianCalendar();
            String storyAgeSimple = new String();
            int articleYearsOld = (currentTime.get(Calendar.YEAR) - article.get(Calendar.YEAR));
            int articleWeeksOld = (currentTime.get(Calendar.WEEK_OF_YEAR) - article.get(Calendar.WEEK_OF_YEAR));
            int articleDaysOld = currentTime.get(Calendar.DAY_OF_WEEK) - article.get(Calendar.DAY_OF_WEEK);
            int articleHoursOld = currentTime.get(Calendar.HOUR_OF_DAY) - article.get(Calendar.HOUR_OF_DAY);
            int articleMinutesOld = currentTime.get(Calendar.MINUTE) - article.get(Calendar.MINUTE);
            int articleMonthsOld = currentTime.get(Calendar.MONTH) - article.get(Calendar.MONTH);

            if (articleYearsOld > 0) {
                storyAgeSimple += (articleYearsOld + " years ago");}
            else
            if (articleMonthsOld > 0 && articleMonthsOld < 12 ) {
                storyAgeSimple +=(articleMonthsOld + " month(s) ago");}
            else
            if (articleWeeksOld > 0 && articleWeeksOld < 53 ) {
                storyAgeSimple +=(articleWeeksOld + " week(s) ago");}
            else
            if (articleDaysOld > 0 && articleDaysOld <32 ){
                storyAgeSimple +=(articleDaysOld + " day(s) ago");}
            else
            if (articleHoursOld > 0 && articleHoursOld < 24 ){
                storyAgeSimple += (articleHoursOld + " hour(s) ago.");}
            else
            if (articleMinutesOld > 0 && articleMinutesOld < 60){
                storyAgeSimple += (articleMinutesOld + " minute(s) ago.");}
            else
            if (articleMinutesOld != 0 ){
                storyAgeSimple += (" Just Added!");
            }
            else
                storyAgeSimple += ("Milliseconds old.");

//            System.out.println(storyAgeSimple);
            return storyAgeSimple;
        }

}











//        int yearsSince1 = dateS01E01.get(Calendar.YEAR);
//        int yearsSince2 = currentTimeAndDate.get(Calendar.YEAR);
//        int weeksSince1 = dateS01E01.get(Calendar.WEEK_OF_YEAR);
//        int daysSince1 = dateS01E01.get(Calendar.DAY_OF_YEAR);
//        int weeksSince2 = dateS01E02.get(Calendar.WEEK_OF_YEAR);
//        int daysSince2 = dateS01E02.get(Calendar.DAY_OF_YEAR);
//
//        System.out.println("<><><><><><<><><><><>");
//        int yearsSince = yearsSince2 - yearsSince1;
//        int weeksSince = weeksSince2 - weeksSince1;
//        int daysSince = daysSince2 - daysSince1;
//        String result = yearsSince + " years " + weeksSince + " weeks " + daysSince +" days old";
//        System.out.println("YEARS SINCE: " + (yearsSince2 - yearsSince1));
//        System.out.println("Story is " + (weeksSince2 - weeksSince1) + " week(s) and " + (daysSince2 - daysSince1) + " days old");
//        System.out.println("<><><><><><<><><><><>");


        //--------------------------------TIME EXPERIMENTS--------------------------
        //---------------LOCAL DATE TIME-----------------------------
//        LocalDateTime lpd1 = LocalDateTime.now();
//        System.out.println("-------------------");
//        System.out.println(lpd1);
//        LocalDateTime ldtTest = LocalDateTime.of(2015,11,05,16,23);
//        LocalDateTime ldtTest2 = LocalDateTime.of(2014,11,30,10,23);
//        System.out.println(ldtTest);
//        System.out.println(ldtTest.getMonthValue());
//        int newwww = ldtTest.compareTo(ldtTest2);
//        System.out.println(newwww );

        //------------------------------DATE ------------------------
        //Date currentDateDate = new Date();
        //Date myDate = parseDate("2014-12-25 13:45");
        //Date dateS01E01 = parseDate("2005-12-05 17:55");
        //Date dateS01E01 = new Calendar.DATE;
        //GregorianCalendar dateS01e01 = new GregorianCalendar(2005, Calendar.DECEMBER, 05);
        //java.util.Date dateS01E01 = new java.util.Date("05/12/2005");
        //LocalDate dateS01E01 = LocalDate.of(2005, 12, 05);
        //Date date = new GregorianCalendar(year, month, day).getTime();
        //DateTime S01E01 =  new DateTime;
        //GregorianCalendar dateS01E01 = new GregorianCalendar(2005,11,12, 12,30,00);

        //long testerino =  getDateDiff(dateS01E01, currentDate ,TimeUnit.DAYS);
        //System.out.println(testerino);

//        public static Date parseDate (String date){
//            try {
//                return new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(date);
//            } catch (ParseException e) {
//                return null;
//            }
//        }

//    public static long getDateDiff(GregorianCalendar date1, GregorianCalendar date2, TimeUnit timeUnit) {
//        long diffInMinutes = date2.getTime() - date1.getTime();
//        return timeUnit.convert(diffInMinutes,TimeUnit.MINUTES);
//    }


//get years since
//get months since
//get weeks since
//get days since
//PRINT RESULT ALONGSIDE STORY
//if calendar years since is >0
//then string = story over a year old
//else
//if month > 0
//then string = story over a month old
//else
//if week >0
//then string story over a week old
//else
//if days >0 story x days old
//else
//if hours >0 then story x hours old
//else
//if minutes > 0 then story is x minutes old.
//end
//​



