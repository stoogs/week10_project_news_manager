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
            HashMap<String, Object> model = new HashMap<>();
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            Journalist ham = new Journalist("Ham", "The first monkey to be sent into space. According to Karl, when he pressed the 'left button' he gets a banana. Also, according to Karl, within the spaceship there are left, right, and reverse buttons");
           DBHelper.save(ham); //OK
            //journalists.add(ham);
            model.put("ham", ham);
            model.put("template", "templates/journalists/index.vtl");
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





