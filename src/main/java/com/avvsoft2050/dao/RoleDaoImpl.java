package com.avvsoft2050.dao;

import com.avvsoft2050.model.Role;
import com.avvsoft2050.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoleDaoImpl implements RoleDao{
    @Override
    public void addRole(Role role) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(role);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteRole(int roleId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Role role = session.get(Role.class, roleId);
        session.delete(role);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateRole(Role role) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(role);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Role> getAllRoles() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Role> list = (List<Role>) session.createQuery("from Role").list();
        session.close();
        return list;
    }

    @Override
    public Role getRoleById(int roleId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Role role = session.get(Role.class, roleId);
        return role;
    }
}
