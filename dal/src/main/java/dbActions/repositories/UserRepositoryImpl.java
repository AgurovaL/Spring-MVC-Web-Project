package dbActions.repositories;

import dbActions.HibernateUtil;
import dbModels.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data
@NoArgsConstructor
public class UserRepositoryImpl {
    private static final Logger LOG = Logger.getLogger(UserRepositoryImpl.class);

    public void save(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(user);
        session.flush();
        transaction.commit();
        session.close();
    }

    public List<User> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> result = session.createQuery("from CLIENTS").list();
        for (User user : result) {
            Hibernate.initialize(user.getBooks());
        }
        session.close();
        return result;
    }

    public User findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User resultUser = session.get(User.class, id);
        Hibernate.initialize(resultUser.getBooks());
        session.close();
        return resultUser;
    }

    public User findByFirstName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from CLIENTS where firstName=?1");
        query.setParameter(1, name);

        User resultUser = (User) query.getResultList().get(0);
        Hibernate.initialize(resultUser.getBooks());
        session.close();

        return resultUser;
    }

    public User findByLogin(String login) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from CLIENTS where login=?1");
        query.setParameter(1, login);

        User resultUser = (User) query.getResultList().get(0);
        Hibernate.initialize(resultUser.getBooks());
        session.close();

        return resultUser;
    }

    public long count() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> list = session.createQuery("from CLIENTS").list();
        long result = list.size();
        session.close();
        return result;
    }

    public void deleteById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
    }

    public void delete(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
    }
}
