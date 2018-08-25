package controllers;

import db.DBHelper;
import models.Category;
import models.Journalist;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.staticFileLocation;

public class JournalistController {

    public JournalistController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {
        //VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
        //staticFileLocation("/public");
//        ArrayList<Journalist> journalists = new ArrayList<>();
        get("/journalists/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Journalist editJournalist = DBHelper.find(Journalist.class, intId);
            Map<String, Object> model = new HashMap<>();
            model.put("journalist", editJournalist);
            model.put("template", "templates/journalists/edit.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/journalists/new", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Journalist> newJournalists = DBHelper.getAll(Journalist.class);
            model.put("journalists", newJournalists);
            model.put("template", "templates/journalists/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/journalists", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            model.put("template", "templates/journalists/index.vtl");
            model.put("journalists", journalists);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
//UPDATE
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

        post ("/journalists/:id/delete", (req, res) -> {
            int intId = Integer.parseInt(req.params(":id"));
            Journalist journalistToDelete = DBHelper.find(Journalist.class, intId);
            DBHelper.delete(journalistToDelete);
            res.redirect("/journalists");
            return null;
        }, new VelocityTemplateEngine());

        get("/journalists/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Journalist journalist = DBHelper.find(Journalist.class, intId);
            Map<String, Object> model = new HashMap<>();
            model.put("journalist", journalist);
            model.put("template", "templates/journalists/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


//EDIT POST
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



    }
}





