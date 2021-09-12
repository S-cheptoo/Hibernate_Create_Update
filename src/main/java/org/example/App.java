package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Organization org = new Organization();
        org.setId(1010);
        org.setName("Tracom Services");

        User user = new User();
        user.setEmail("ian.gmail.com");
        user.setName("Ian the Geek");
        user.setPassword("1234567890");
        user.setId(455);
        //HOW TO SAVE THESE TABLES IN HIBERNATE

        Configuration cfg = new Configuration().configure()
                .addAnnotatedClass(Organization.class)
                .addAnnotatedClass(User.class);

        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        SessionFactory sf = cfg.buildSessionFactory(sr);
        Session sn = sf.openSession();
        sn.beginTransaction();
        sn.save(org);
        sn.save(user);
        sn.getTransaction().commit();


    }
}

