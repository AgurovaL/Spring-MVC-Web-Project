package dbActions.repositories;

import dbActions.HibernateUtil;
import dbModels.Book;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data
@NoArgsConstructor
public class BookRepositoryImpl {
    public void save(Book book) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(book);
        session.flush();
        transaction.commit();
        session.close();
    }

    public void saveAll(Iterable<Book> books) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        for (Book book : books) {
            session.saveOrUpdate(book);
            session.flush();

        }
        transaction.commit();
        session.close();
    }

    public Book findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Book resultBook = session.get(Book.class, id);
        Hibernate.initialize(resultBook.getClients());
        session.close();
        return resultBook;
    }

    public List<Book> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Book> result = session.createQuery("from BOOKS").list();
        for (Book book : result) {
            Hibernate.initialize(book.getClients());
        }
        session.close();
        return result;
    }

    public List<Book> findAllByTitle(String title) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Book> result = session.createQuery("from BOOKS").list();
        for (Book book : result) {
            Hibernate.initialize(book.getClients());
        }
        session.close();
        return result;
    }

    public long count() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Book> list = session.createQuery("from BOOKS").list();
        long result = list.size();
        session.close();
        return result;
    }

    public void deleteById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            Book book = session.get(Book.class, id);
            session.delete(book);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
    }

    public void delete(Book book) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.delete(book);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
    }
}
