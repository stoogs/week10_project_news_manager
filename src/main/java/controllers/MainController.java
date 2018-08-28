package controllers;

import db.DBArticle;
import db.Seeds;
import models.Article;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class MainController {
    public static void main(String[] args) {

        Seeds.seedData();
        staticFileLocation("/public");

        ArticleController articleController = new ArticleController();
        CategoryController categoryController = new CategoryController();
        JournalistController journalistController = new JournalistController();
        LocationController loctionController = new LocationController();

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            ArrayList<String> mostPopularArticles = new ArrayList<>();
            List<Article> articles = DBArticle.orderArticlesByAgeDesc();
            for (Article article : articles){
                String time = Seeds.storyAgeSimple(article.getTimeStamp());
                mostPopularArticles.add(time); }
            model.put("articles", articles);
            model.put("mostPopularArticles", mostPopularArticles);
            model.put("template", "templates/main.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}

