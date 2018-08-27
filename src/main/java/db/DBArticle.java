package db;

import models.Article;
import models.Journalist;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBArticle {

    private static Session session;

    //Give all articles from DB and sort by Journalist

    public static List<Article> getArticleJournalists(Journalist journalist) {
        List<Article> results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Article.class);
            cr.createAlias("journalists", "journalist"); // ADDED
            cr.add(Restrictions.eq("journalist.id", journalist.getId())); // ADDED
            results = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;

    }
    public static List<Article> orderArticlesByAgeDesc(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Article> articles = null;
        try {
            Criteria cr = session.createCriteria(Article.class);
            cr.addOrder(Order.desc("timeStamp"));
            articles = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return articles;
    }


}