package peaksoft.dao;

import org.hibernate.Session;
import peaksoft.model.User;
import peaksoft.util.Util;

import javax.persistence.Query;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {


    @Override
    public void createUsersTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.createSQLQuery("""
                    create table if not exists users (
                    id serial primary key,
                    name varchar(250) not null,
                    last_name varchar(250) not null,
                    age smallint not null )
                    """).executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (Throwable e) {
            System.out.println("jok" + e);

        }
    }

    @Override
    public void dropUsersTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.createSQLQuery("drop table if exists users;").executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Successfully deleteAll:");
        } catch (Throwable e) {
            System.out.println("jok" + e);
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            session.close();
            System.out.println("Successfully saved: ");
        } catch (Throwable e) {
            System.out.println("jok" + e);
        }
    }

    @Override
    public void removeUserById(long id) {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            User student = session.get(User.class, id);
            session.delete(student);
            session.getTransaction().commit();
            session.close();
            System.out.println("Successfully delete:");
        } catch (Throwable e) {
            System.out.println("jok" + e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            List<User> list = session.createQuery("from User ").getResultList();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Throwable e) {
            System.out.println("jok" + e);
        }
        return null;
    }

    @Override
    public void cleanUsersTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.createQuery("DELETE FROM User").executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Successfully deleteAll:");
        } catch (Throwable e) {
            System.out.println("jok" + e);
        }
    }
}