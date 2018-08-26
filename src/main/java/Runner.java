import db.DBArticle;
import db.DBHelper;
import db.Seeds;
import models.Article;
import models.Journalist;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

//    Seeds.seedData();
        List<Journalist> journalists = DBHelper.getAll(Journalist.class);

        }
}
