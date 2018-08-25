package controllers;

import db.DBHelper;
import models.Category;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class CategoryController {
    public CategoryController()  {
        this.setupEndpoints();
    }

    public void setupEndpoints(){

        get("/categories", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Category> categoryList = DBHelper.getAll(Category.class);
            model.put("template", "templates/categories/index.vtl");
            model.put("categories", categoryList);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/categories/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Category> categoryList = DBHelper.getAll(Category.class);
            model.put("catergories", categoryList);
            model.put("template", "templates/categories/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/categories", (req, res) -> {
            String catergoryName = req.queryParams("categoryName");
            Category addCategory = new Category(catergoryName);
            System.out.println(addCategory);
            DBHelper.save(addCategory);
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/categories/layout.vtl");
            res.redirect("/categories");
            return new ModelAndView(model, "layout.vtl");
        }, new VelocityTemplateEngine());



    }
}
