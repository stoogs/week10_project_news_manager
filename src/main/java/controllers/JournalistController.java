package controllers;

import db.DBHelper;
import db.DBJournalist;
import models.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class JournalistController {

    public JournalistController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {
        //VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
        //staticFileLocation("/public");
//        ArrayList<Journalist> journalists = new ArrayList<>();

        //INDEX
        get("/journalists", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            List<Category> categories = DBHelper.getAll(Category.class);
            List<Location> locations = DBHelper.getAll(Location.class);
            model.put("journalists", journalists);
            model.put("categories", categories);
            model.put("locations", locations);
            model.put("template", "templates/journalists/index.vtl");
            model.put("journalists", journalists);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        //NEW
        get("/journalists/new", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Journalist> newJournalists = DBHelper.getAll(Journalist.class);
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            List<Category> categories = DBHelper.getAll(Category.class);
            List<Location> locations = DBHelper.getAll(Location.class);
            model.put("journalists", journalists);
            model.put("categories", categories);
            model.put("locations", locations);
            model.put("journalists", newJournalists);
            model.put("template", "templates/journalists/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

//CREATE NEW
        post ("/journalists", (req, res) -> {
            String journalistName = req.queryParams("journalistName");
            String biography = req.queryParams("biography");
            Journalist addJournalist = new Journalist(journalistName,biography);
            System.out.println(addJournalist);
            DBHelper.save(addJournalist);
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/journalists/layout.vtl");
            res.redirect("/journalists");
            return new ModelAndView(model, "layout.vtl");
        }, new VelocityTemplateEngine());

        //EDIT
        get("/journalists/edit/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Journalist editJournalist = DBHelper.find(Journalist.class, intId);
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            List<Category> categories = DBHelper.getAll(Category.class);
            List<Location> locations = DBHelper.getAll(Location.class);
            Map<String, Object> model = new HashMap<>();
            model.put("journalists", journalists);
            model.put("categories", categories);
            model.put("locations", locations);
            model.put("journalist", editJournalist);
            model.put("template", "templates/journalists/edit.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        //UPDATE - SHOW
        get("/journalists/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Journalist journalist = DBHelper.find(Journalist.class, intId);
            //Category category = DBHelper.find(Category.class, intId);
            List<Article> journalistArticles = DBJournalist.getArticlesByJournalist(journalist);
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            List<Category> categories = DBHelper.getAll(Category.class);
            List<Location> locations = DBHelper.getAll(Location.class);
            Map<String, Object> model = new HashMap<>();
            model.put("journalists", journalists);
            model.put("categories", categories);
            model.put("locations", locations);
            model.put("journalist", journalist);
            model.put("journalistArticles", journalistArticles);
            model.put("template", "templates/journalists/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/journalists/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Journalist journalist = DBHelper.find(Journalist.class, intId);
            String journalistName = req.queryParams("journalistName");
            journalist.setJournalistName(journalistName);
            String biography = req.queryParams("biography");
            journalist.setBiography(biography);
            DBHelper.update(journalist);
            HashMap<String, Object> model = new HashMap<>();
            res.redirect("/journalists");
            return new ModelAndView(model, "layout.vtl");
        }, new VelocityTemplateEngine());

        //DELETE
        get ("/journalists/delete/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Journalist journalistToDelete = DBHelper.find(Journalist.class, intId);
            DBHelper.delete(journalistToDelete);
            res.redirect("/journalists");
            return null;
        }, new VelocityTemplateEngine());

    }
}





