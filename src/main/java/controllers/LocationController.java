package controllers;

import db.DBArticle;
import db.DBHelper;
import db.DBLocation;
import models.Article;
import models.Category;
import models.Journalist;
import models.Location;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class LocationController {
    public LocationController() {
        this.setupEndpoints();
    }

    public void setupEndpoints() {
//        INDEX
        get("/locations", (req, res) -> {
            List<Location> getLocationList = DBHelper.getAll(Location.class);
            List<Article> articles = DBArticle.orderArticlesByAgeDesc();
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            List<Category> categories = DBHelper.getAll(Category.class);
            List<Location> locations = DBHelper.getAll(Location.class);
            Map<String, Object> model = new HashMap<>();
            model.put("articles", articles);
            model.put("journalists", journalists);
            model.put("categories", categories);
            model.put("locations", locations);
            model.put("template", "templates/locations/index.vtl");
            model.put("locationList", getLocationList);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        //        NEW
        get("/locations/new", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Location> newLocation = DBHelper.getAll(Location.class);
            List<Article> articles = DBArticle.orderArticlesByAgeDesc();
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            List<Category> categories = DBHelper.getAll(Category.class);
            List<Location> locations = DBHelper.getAll(Location.class);
            model.put("articles", articles);
            model.put("journalists", journalists);
            model.put("categories", categories);
            model.put("locations", locations);
            model.put("locations", newLocation);
            model.put("template", "templates/locations/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

//        SHOW
        get("/locations/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Location location = DBHelper.find(Location.class, intId);
            List<Article> articles = DBArticle.orderArticlesByAgeDesc();
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            List<Category> categories = DBHelper.getAll(Category.class);
            List<Location> locations = DBHelper.getAll(Location.class);
            String locationLocation = location.getLocationName();
            List<Article> locationArticles = DBLocation.getArticlesByLocation(location);
            Map<String, Object> model = new HashMap<>();
            model.put("articles", articles);
            model.put("journalists", journalists);
            model.put("categories", categories);
            model.put("locations", locations);
            model.put("locationLocation", locationLocation);
            model.put("locationArticles", locationArticles);
            model.put("template", "templates/locations/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/locations", (req, res) -> {
            String locationName = req.queryParams("locationName");
            Location addLocations = new Location(locationName);
            List<Article> articles = DBArticle.orderArticlesByAgeDesc();
            System.out.println(addLocations);
            DBHelper.save(addLocations);
            HashMap<String, Object> model = new HashMap<>();
            model.put("articles", articles);
            model.put("template", "templates/locations/layout.vtl");
            res.redirect("/locations");
            return new ModelAndView(model, "layout.vtl");
        }, new VelocityTemplateEngine());

//        UPDATE
        get("/locations/edit/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Location getEditLocation = DBHelper.find(Location.class, intId);
            List<Article> articles = DBArticle.orderArticlesByAgeDesc();
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            List<Category> categories = DBHelper.getAll(Category.class);
            List<Location> locations = DBHelper.getAll(Location.class);

            Map<String, Object> model = new HashMap<>();
            model.put("articles", articles);
            model.put("journalists", journalists);
            model.put("categories", categories);
            model.put("locations", locations);
            model.put ("location", getEditLocation);
            model.put("template", "templates/locations/edit.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/locations/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Location postIdLocationList = DBHelper.find(Location.class, intId);
            List<Article> articles = DBArticle.orderArticlesByAgeDesc();
            String locationName = req.queryParams("locationName");

            postIdLocationList.setLocationName(locationName);
            DBHelper.update(postIdLocationList);
            HashMap<String, Object> model = new HashMap<>();
            model.put("articles", articles);
            res.redirect("/locations");
            return new ModelAndView(model, "layout.vtl");
        }, new VelocityTemplateEngine());


//        DELETE
        get ("/locations/delete/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Location deleteLocation = DBHelper.find(Location.class, intId);
            DBHelper.delete(deleteLocation);
            res.redirect("/locations");
            return null;
        }, new VelocityTemplateEngine());
//
       }
    }

