package controllers;

import db.DBHelper;
import models.Category;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

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

    }
}