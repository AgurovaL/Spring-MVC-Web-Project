package dbActions.repositories;

import dbActions.HibernateUtil;
import dbModels.BuyingOperation;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data
@NoArgsConstructor
public class BuyingOperationRepositoryImpl {
    public void save(BuyingOperation buyingOperation) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(buyingOperation);
        session.flush();
        transaction.commit();
        session.close();
    }

    public List<BuyingOperation> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<BuyingOperation> result = session.createQuery("from OPERATIONS").list();
        session.close();
        return result;
    }

    public BuyingOperation findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        BuyingOperation resultOperation = session.get(BuyingOperation.class, id);
        session.close();
        return resultOperation;
    }

    public void deleteById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            BuyingOperation buyingOperation = session.get(BuyingOperation.class, id);
            session.delete(buyingOperation);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
    }
}
