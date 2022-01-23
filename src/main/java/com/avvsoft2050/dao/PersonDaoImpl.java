package com.avvsoft2050.dao;

import com.avvsoft2050.model.Person;
import com.avvsoft2050.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PersonDaoImpl implements PersonDao {
    @Override
    public void addPerson(Person person) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
    }

    @Override
    public void deletePerson(int personId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Person person = session.get(Person.class, personId);
        session.delete(person);
        transaction.commit();
        session.close();
    }

    @Override
    public void updatePerson(Person person) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(person);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Person> getAllPeople() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Person> people = (List<Person>) session.createQuery("from Person").list(); //or getResultList ???
        return people;
    }

    @Override
    public Person getPersonById(int personId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Person person = session.get(Person.class, personId);
        return null;
    }
}
