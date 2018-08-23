import db.DBHelper;
//import models.Article;
import models.Category;
import models.Journalist;

import java.util.Date;

public class Runner {

    public static void main(String[] args) {

        Category categoryCrime = new Category("Crime");
            DBHelper.save(categoryCrime);

        Journalist journalistMonkey86 = new Journalist("Monkey 86");
            DBHelper.save(journalistMonkey86);

//            Date testDate = new Date();
//
//        Article articleTest = new Article("Test", journalistMonkey86, categoryCrime, "Test News", "test test test", testDate);
        }
}
