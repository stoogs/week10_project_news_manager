package db;

import models.Article;
import models.Category;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBCategory {

    private static Session session;
    private static Transaction transaction;


    public static List<Article> getArticlesByCategory(Category category){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Article> articles = null;
        try{
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(Category.class);
            cr.createAlias("category", "category");
            cr.add(Restrictions.eq("article.category_id", category.getId()));
            articles = cr.list();
        } catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        } return articles;
    }


}
