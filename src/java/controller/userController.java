/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Users;
import model.UsersHibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author user
 */
public class userController {

    public void register(Users users) {
        Transaction trans = null;
        Session session = UsersHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(users);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Users> readUsers() {

        List users = new ArrayList();
        Transaction trans = null;
        Session session = UsersHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("FROM Users");
            users = query.list();

            trans.commit();

        } catch (Exception e) {

        }
        return users;
    }

    public List<Users> getByUsername(String username) {
        List<Users> users = new ArrayList();

        Transaction trans = null;
        Session session = UsersHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Users where username = :username");
            query.setString("username", username);
            users = query.list();

            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public void updateUsers(Users users) {
        Transaction trans = null;
        Session session = UsersHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(users);
            trans.commit();
        } catch (Exception e) {

        }
    }

    public void deleteUsers(int id) {
        Transaction trans = null;
        Session session = UsersHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Users users = (Users) session.load(Users.class, new Integer(id));
            session.delete(users);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Users> getbyID(int id) {
        List<Users> users = new ArrayList();

        Transaction trans = null;
        Session session = UsersHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Users where id= :id");
            query.setInteger("id", id);
            users = query.list();

            trans.commit();
        } catch (Exception e) {

        }
        return users;
    }
}
