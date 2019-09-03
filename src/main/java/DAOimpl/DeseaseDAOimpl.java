package DAOimpl;

import DAO.DeseaseDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Desease;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sample.HibernateSessionFactoryUtill;

import java.util.List;

public class DeseaseDAOimpl implements DeseaseDAO {


    @Override
    public void saveDesease(Desease desease) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        session.save(desease);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateDesease(Desease desease) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        session.update(desease);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteDesease(Desease desease) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        session.delete(desease);
        transaction.commit();
        session.close();
    }

    @Override
    public ObservableList<Desease> getDeseaseNames() {
        ObservableList<Desease> deseases = FXCollections.observableArrayList((List<Desease>)HibernateSessionFactoryUtill.getSessionFactory().openSession().createQuery("FROM Desease").list());

        return deseases;
    }

}
