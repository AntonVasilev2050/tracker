package com.avvsoft2050.dao;

import com.avvsoft2050.model.Message;
import com.avvsoft2050.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class MessageDaoImpl implements MessageDao {
//    private static final SessionFactory sessionFactory1 = new Configuration().configure().buildSessionFactory();

    @Override
    public void addMessage(Message message) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(message);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteMessageById(int messageId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Message message = session.get(Message.class, messageId);
        session.delete(message);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteMessage(Message message) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
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
        Transaction transaction = session.beginTransaction();
        List<Message> list = session.createQuery("from Message order by dateTime desc", Message.class).getResultList();
        transaction.commit();
        session.close();
//        return list.stream().sorted((o1, o2) ->
//                (int) (o1.getDateTime() - o2.getDateTime())).collect(Collectors.toList());
        return list;
    }

    @Override
    public Message getMessageById(int messageId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Message message = session.get(Message.class, messageId);
        transaction.commit();
        session.close();
        return message;
    }
}
