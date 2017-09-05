package ua.azbest.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtilites {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    static {
        //org.apache.log4j.BasicConfigurator.configure(new NullAppender());
        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        catch (HibernateException e) {
            e.printStackTrace();
            System.out.println("Error create sessionFactory");
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        HibernateUtilites.sessionFactory = sessionFactory;
    }
}