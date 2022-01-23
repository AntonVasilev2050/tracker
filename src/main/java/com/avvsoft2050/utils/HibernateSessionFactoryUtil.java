package com.avvsoft2050.utils;

import com.avvsoft2050.model.Group;
import com.avvsoft2050.model.Message;
import com.avvsoft2050.model.Person;
import com.avvsoft2050.model.Role;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * https://javarush.ru/groups/posts/hibernate-java
 */
public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Group.class);
                configuration.addAnnotatedClass(Message.class);
                configuration.addAnnotatedClass(Person.class);
                configuration.addAnnotatedClass(Role.class);
                StandardServiceRegistryBuilder builder =
                        new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
