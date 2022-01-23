package com.avvsoft2050.dao;

import com.avvsoft2050.model.Message;
import com.avvsoft2050.model.Person;
import com.avvsoft2050.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MessageDaoImpl implements MessageDao {
    @Override
    public void addMessage(Message message) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(message);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteMessage(int messageId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Message message = session.get(Message.class, messageId);
        session.delete(message);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateMessage(Message message) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(message);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Message> getAllMessages() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Message> list = (List<Message>) session.createQuery("from Message").list();
        return list;
    }

    @Override
    public Person getMessageById(int messageId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Message message = session.get(Message.class, messageId);
        return null;
    }
}
