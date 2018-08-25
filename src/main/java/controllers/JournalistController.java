package controllers;

import db.DBHelper;
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

//        get("/journalists/new", (req, res) -> {
//            HashMap<String, Object> model = new HashMap<>();
//            model.put("template", "create.vtl");
//            return new ModelAndView(model, "layout.vtl");
//        }, new VelocityTemplateEngine());

        get("/journalists", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);

            model.put("template", "templates/journalists/index.vtl");
            model.put("journalists", journalists);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

//        post("/journalists", (req, res) -> {
//            String jounalistName = req.queryParams("journalistName");
//            String biography = req.queryParams("biography");
//
//            Journalist newJournalist = new Journalist(jounalistName, biography );
//            journalists.add(newJournalist);
//            HashMap<String, Object> model = new HashMap<>();
//            model.put("journalists", journalists);
//            model.put("template", "journalists.vtl");
//            return new ModelAndView(model, "layout.vtl");
//        }, velocityTemplateEngine);
    }
}





