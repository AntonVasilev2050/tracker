package com.avvsoft2050.dao;

import com.avvsoft2050.model.Group;
import com.avvsoft2050.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GroupDaoImpl implements GroupDao{
    @Override
    public void addGroup(Group group) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(group);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteGroup(int groupId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Group group = getGroupById(groupId);
        session.delete(group);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateGroup(Group group) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(group);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Group> getAllGroups() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Group> list = (List<Group>)session.createQuery("from Group").list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public Group getGroupById(int groupId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Group group = session.get(Group.class, groupId);
        transaction.commit();
        session.close();
        return group;
    }
}
