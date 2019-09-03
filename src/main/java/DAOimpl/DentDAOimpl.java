package DAOimpl;

import DAO.DentDAO;
import model.Dent;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sample.HibernateSessionFactoryUtill;

public class DentDAOimpl implements DentDAO {

    @Override
    public void saveDent(Dent dent) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        session.save(dent);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateDent(Dent dent) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        session.update(dent);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteDent(Dent dent) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        session.delete(dent);
        transaction.commit();
        session.close();
    }

}
