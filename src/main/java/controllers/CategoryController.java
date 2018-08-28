package controllers;

import db.DBCategory;
import db.DBHelper;
import models.*;
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

//        INDEX
        get("/categories", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Category> categoryList = DBHelper.getAll(Category.class);
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            List<Category> categories = DBHelper.getAll(Category.class);
            List<Location> locations = DBHelper.getAll(Location.class);
            model.put("journalists", journalists);
            model.put("categories", categories);
            model.put("locations", locations);
            model.put("categories", categoryList);
            model.put("template", "templates/categories/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

//        NEW
        get("/categories/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Category> categoryList = DBHelper.getAll(Category.class);
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            List<Category> categories = DBHelper.getAll(Category.class);
            List<Location> locations = DBHelper.getAll(Location.class);
            model.put("journalists", journalists);
            model.put("categories", categories);
            model.put("locations", locations);
            model.put("categories", categoryList);
            model.put("template", "templates/categories/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

//        SHOW
        get("/categories/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Category category = DBHelper.find(Category.class, intId);
            String categoryCategory = category.getCategoryName();
            List<Article> categoryArticles = DBCategory.getArticlesByCategory(category);
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            List<Category> categories = DBHelper.getAll(Category.class);
            List<Location> locations = DBHelper.getAll(Location.class);
            Map<String, Object> model = new HashMap<>();
            model.put("journalists", journalists);
            model.put("categories", categories);
            model.put("locations", locations);
            model.put("categoryCategory", categoryCategory);
            model.put("categoryArticles", categoryArticles);
            model.put("template", "templates/categories/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/categories", (req, res) -> {
            String categoryName = req.queryParams("categoryName");
            Category addCategory = new Category(categoryName);
            System.out.println(addCategory);
            DBHelper.save(addCategory);
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/categories/layout.vtl");
            res.redirect("/categories");
            return new ModelAndView(model, "layout.vtl");
        }, new VelocityTemplateEngine());


//        UPDATE
        get("/categories/edit/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Category category = DBHelper.find(Category.class, intId);
            Map<String, Object> model = new HashMap<>();
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            List<Category> categories = DBHelper.getAll(Category.class);
            List<Location> locations = DBHelper.getAll(Location.class);
            model.put("journalists", journalists);
            model.put("categories", categories);
            model.put("locations", locations);
            model.put ("category", category);
            model.put("template", "templates/categories/edit.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/categories/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Category categoryList = DBHelper.find(Category.class, intId);
            String categoryName = req.queryParams("categoryName");

            categoryList.setCategoryName(categoryName);
            DBHelper.update(categoryList);
            HashMap<String, Object> model = new HashMap<>();
            res.redirect("/categories");
            return new ModelAndView(model, "layout.vtl");
        }, new VelocityTemplateEngine());


//        DELETE
        get ("/categories/delete/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Category deletedCategory = DBHelper.find(Category.class, intId);
            DBHelper.delete(deletedCategory);
            res.redirect("/categories");
            return null;
        }, new VelocityTemplateEngine());

    }
}