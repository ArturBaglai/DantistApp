package sample;

import DAOimpl.DoctorDAOimpl;
import model.*;
import model.Dent;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
//https://javarush.ru/groups/posts/hibernate-java
public class HibernateSessionFactoryUtill {
    private static SessionFactory sessionFactory;
    private HibernateSessionFactoryUtill() {};

    public static SessionFactory getSessionFactory() {
        if(sessionFactory ==null)
        {
            try{
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Channels.class);
                configuration.addAnnotatedClass(Dent.class);
                configuration.addAnnotatedClass(Desease.class);
                configuration.addAnnotatedClass(DeseaseHistory.class);
                configuration.addAnnotatedClass(Doctor.class);
                //configuration.addAnnotatedClass(Material.class);
                configuration.addAnnotatedClass(Patient.class);
               // configuration.addAnnotatedClass(Seal.class);
                configuration.addAnnotatedClass(Services.class);
                //configuration.addAnnotatedClass(DoctorDAOimpl.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (HibernateException exception)
            {
                System.out.println("Exeption");
                exception.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
