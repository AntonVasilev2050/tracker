package com.avvsoft2050.dao;

import com.avvsoft2050.model.Person;
import com.avvsoft2050.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
        Transaction transaction = session.beginTransaction();
        List<Person> people = (List<Person>) session.createQuery("from Person").list(); //or getResultList ???
        transaction.commit();
        session.close();
        return people;
    }

    @Override
    public Person getPersonById(int personId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Person person = session.get(Person.class, personId);
        transaction.commit();
        session.close();
        return person;
    }

//    @Override
//    public int getIdByUserName(String userName) {
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        Query query = session.createQuery("from Person p where p.telegramLogin =: tlog");
//        query.setParameter("tlog", userName);
//        int id = query.executeUpdate();
//        transaction.commit();
//        session.close();
//        return id;
//    }
}
