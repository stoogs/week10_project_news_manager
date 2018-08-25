package controllers;

import db.DBHelper;
import models.*;
import models.Article;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class ArticleController {

    public ArticleController() {
        this.setupEndpoints();
    }

    public void setupEndpoints() {

//        INDEX
        get("/articles", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Article> articles = DBHelper.getAll(Article.class);
            model.put("template", "templates/articles/index.vtl");
            model.put("articles", articles);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
//NEW
        get("/articles/new", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Article> newArticles = DBHelper.getAll(Article.class);
            model.put("articles", newArticles);
            model.put("template", "templates/articles/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/articles", (req, res) -> {
            int journalistId = Integer.parseInt(req.queryParams("journalist"));
            int categoryId = Integer.parseInt(req.queryParams("category"));
            int locationId = Integer.parseInt(req.queryParams("location"));
            int timeStampId = Integer.parseInt(req.queryParams("timeStamp"));
            String title = req.queryParams("title");
            String headline = req.queryParams("headline");
            String content = req.queryParams("content");
            Journalist journalist = DBHelper.find(Journalist.class,journalistId);
            Category category = DBHelper.find(Category.class,categoryId);
            GregorianCalendar timeStamp = DBHelper.find(GregorianCalendar.class,timeStampId);
            Location location = DBHelper.find(Location.class,locationId);
            Article addArticle = new Article(title,journalist,category,location,timeStamp,headline,content);
            DBHelper.save(addArticle);
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/articles/layout.vtl");
            res.redirect("/articles");
            return new ModelAndView(model, "layout.vtl");
        }, new VelocityTemplateEngine());

        //EDIT
        get("/articles/edit/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Article editArticle = DBHelper.find(Article.class, intId);
            Map<String, Object> model = new HashMap<>();
            model.put("article", editArticle);
            model.put("template", "templates/articles/edit.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        //UPDATE
        get("/articles/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Article article = DBHelper.find(Article.class, intId);
            Map<String, Object> model = new HashMap<>();
            model.put("article", article);
            model.put("template", "templates/articles/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/articles/:id", (req, res) -> {
        int journalistId = Integer.parseInt(req.queryParams("journalist"));
        int categoryId = Integer.parseInt(req.queryParams("category"));
        int locationId = Integer.parseInt(req.queryParams("location"));
        int timeStampId = Integer.parseInt(req.queryParams("timeStamp"));
        String title = req.queryParams("title");
        String headline = req.queryParams("headline");
        String content = req.queryParams("content");
        Journalist journalist = DBHelper.find(Journalist.class,journalistId);
        Category category = DBHelper.find(Category.class,categoryId);
        GregorianCalendar timeStamp = DBHelper.find(GregorianCalendar.class,timeStampId);
        Location location = DBHelper.find(Location.class,locationId);
        Article addArticle = new Article(title,journalist,category,location,timeStamp,headline,content);
            DBHelper.update(addArticle);
            HashMap<String, Object> model = new HashMap<>();
            res.redirect("/articles");
            return new ModelAndView(model, "layout.vtl");
        }, new VelocityTemplateEngine());

        //DELETE
        get ("/articles/delete/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Article articleToDelete = DBHelper.find(Article.class, intId);
            DBHelper.delete(articleToDelete);
            res.redirect("/articles");
            return null;
        }, new VelocityTemplateEngine());
    }
}
