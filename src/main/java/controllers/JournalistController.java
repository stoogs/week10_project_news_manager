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

        //String flightNumber = req.queryParams("flightNumber");
        //            String airline = req.queryParams("airline");
        //            String departureAirport = req.queryParams("departureAirport");
        //            String arrivalAirport = req.queryParams("arrivalAirport");
        //
        //            Flight newFlight = new Flight(flightNumber, airline, departureAirport, arrivalAirport );
        //            flights.add(newFlight);
        //            HashMap<String, Object> model = new HashMap<>();
        //            model.put("flights", flights);
        //            model.put("template", "flights.vtl");
        //            return new ModelAndView(model, "layout.vtl");
    }
}





