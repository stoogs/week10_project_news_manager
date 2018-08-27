package db;

import models.Article;
import models.Location;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBLocation {
    private static Session session;
    private static Transaction transaction;


    public static List<Article> getArticlesByLocation(Location location){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Article> categoryLocations = null;
        try{
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(Article.class);
            cr.add(Restrictions.eq("location", location));
            categoryLocations = cr.list();
        } catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        } return categoryLocations;
    }
}
