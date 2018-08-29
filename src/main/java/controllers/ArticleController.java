package controllers;

import db.DBArticle;
import db.DBHelper;
import db.Seeds;
import models.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.*;

import static spark.Spark.get;
import static spark.Spark.post;

public class ArticleController {

    public ArticleController() {
        this.setupEndpoints();
    }

    public void setupEndpoints() {

        //INDEX
        get("/articles", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<String> stringTimes = new ArrayList<>();
            List<Article> getArticles = DBArticle.orderArticlesByAgeDesc();

            //Create String Array of times from Articles
            for (Article article : getArticles) {
                String time = Seeds.storyAgeSimple(article.getTimeStamp());
                stringTimes.add(time);
            }

            model.put("articles", getArticles); //Send Array of Articles
            model.put("stringTimes", stringTimes);  //Send Array Of String Times
            model.put("template", "templates/articles/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
//NEW
        get("/articles/new", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            //Get all Articles from DataBase
            List<Article> newArticles = DBHelper.getAll(Article.class);

            //Get Lists to use for Drop Down Menu Bars
            List<Category> categories = DBHelper.getAll(Category.class);
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            List<Location> locations = DBHelper.getAll(Location.class);

            //send arrays to Drop Down Menu Bars
            model.put("journalists", journalists);
            model.put("categories", categories);
            model.put("locations", locations);
            model.put("articles", newArticles);
            model.put("template", "templates/articles/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        //CREATE NEW
        post("/articles", (req, res) -> {
            //Get chosen existing object id's from Drop Down Menu Bars to use here.
            int journalistId = Integer.parseInt(req.queryParams("journalist"));
            Journalist journalist = DBHelper.find(Journalist.class, journalistId);
            int categoryId = Integer.parseInt(req.queryParams("category"));
            Category category = DBHelper.find(Category.class, categoryId);
            int locationId = Integer.parseInt(req.queryParams("location"));
            Location location = DBHelper.find(Location.class, locationId);

            //Get new paramaters typed in for New Article
            String title = req.queryParams("title");
            String headline = req.queryParams("headline");
            String content = req.queryParams("content");

            //Create new Time for Article publish date
            GregorianCalendar timeStamp = new GregorianCalendar();
            //Create New Article from all elements
            Article newArticle = new Article(title, journalist, category, location, timeStamp, headline, content);
            // Save Article to DataBase
            DBHelper.save(newArticle);
            //Return to Articles view to see list again
            HashMap<String, Object> model = new HashMap<>();
            res.redirect("/articles");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        //EDIT FORM
        get("/articles/edit/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            //find article to edit using ID
            Article editArticle = DBHelper.find(Article.class, intId);
            List<Category> categories = DBHelper.getAll(Category.class);
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            List<Location> locations = DBHelper.getAll(Location.class);
            Map<String, Object> model = new HashMap<>();

            //send array of existing journalists to DDMB
            model.put("journalists", journalists);
            model.put("categories", categories);
            model.put("locations", locations);
            model.put("article", editArticle);
            model.put("template", "templates/articles/edit.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        //SHOW BY ID
        get("/articles/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Article article = DBHelper.find(Article.class, intId);

            //Add Counter to Articles
            //Retrieve current view counts for current article
            int counter = article.getCounter();
            counter = counter + 1;
            article.setCounter(counter);
            //Every time page is refreshed counter is added to then stored in  DataBase
            DBHelper.update(article);
            //Get date of article
            String storyAgeSimple = Seeds.storyAgeSimple(article.getTimeStamp());
            String storyAge = Seeds.storyAgeSimple(article.getTimeStamp());
            Map<String, Object> model = new HashMap<>();
            model.put("storyAge", storyAge);
            model.put("storyAgeSimple", storyAgeSimple);
            model.put("article", article);
            model.put("counter", counter);
            model.put("template", "templates/articles/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        //POST EDIT FORM
        post("/articles/edit/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            //Load article fro id to edit
            Article article = DBHelper.find(Article.class, intId);
            // Get details from DataBase
            int journalistId = Integer.parseInt(req.queryParams("journalist"));
            Journalist journalist = DBHelper.find(Journalist.class, journalistId);
            int categoryId = Integer.parseInt(req.queryParams("category"));
            Category category = DBHelper.find(Category.class, categoryId);
            int locationId = Integer.parseInt(req.queryParams("location"));
            Location location = DBHelper.find(Location.class, locationId);
            //Pull details from get forms
            String title = req.queryParams("title");
            String headline = req.queryParams("headline");
            String content = req.queryParams("content");
            //timestamp current time
            GregorianCalendar timeStamp = new GregorianCalendar();
            //Set all new values and update DataBase
            article.setTitle(title);
            article.setHeadline(headline);
            article.setContent(content);
            article.setJournalist(journalist);
            article.setCategory(category);
            article.setTimeStamp(timeStamp);
            article.setLocation(location);
            DBHelper.update(article);
            HashMap<String, Object> model = new HashMap<>();
            res.redirect("/articles");
            return null;
        }, new VelocityTemplateEngine());

        //DELETE
        get("/articles/delete/:id", (req, res) -> {
            //Get id for article from menubar
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Article articleToDelete = DBHelper.find(Article.class, intId);
            DBHelper.delete(articleToDelete);
            res.redirect("/articles");
            return null;
        }, new VelocityTemplateEngine());
    }
}
