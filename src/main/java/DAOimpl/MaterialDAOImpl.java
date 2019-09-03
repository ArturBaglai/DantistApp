package DAOimpl;

import model.Material;
import DAO.MaterialDAO;
import model.Desease;
import model.Material;
import sample.HibernateSessionFactoryUtill;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class MaterialDAOImpl implements MaterialDAO {
    @Override
    public void saveMaterial(Material material) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        session.save(material);
        transaction.commit();
        session.close();
    }

    @Override
    public ObservableList<Material> fildAllMaterials() {
        ObservableList<Material> materials = FXCollections.observableArrayList((List<Material>)HibernateSessionFactoryUtill.getSessionFactory().openSession().createQuery("FROM Material").list());
        return materials;
    }
}
