package DAOimpl;

import DAO.DoctorDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Doctor;
import model.Patient;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sample.HibernateSessionFactoryUtill;

import java.util.List;

import DAO.DoctorDAO;
import model.Doctor;
import model.Patient;
import sample.HibernateSessionFactoryUtill;
import java.util.List;
import javafx.scene.control.TextField;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author BagMih
 */
public class DoctorDAOimpl implements DoctorDAO {
    // @Override
    public Doctor findIdByFirstNameAndLastName(String firstaName, String lastName) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();

        session.beginTransaction();
        Query query = session.createQuery("from Doctor where FIRSTNAME=:FIRSTNAME and LASTNAME=:LASTNAME");
        query.setString("USERNAME", firstaName);
        query.setString("PASSWORD", lastName);
        List <Doctor> list = query.list();
        Doctor doc = null;
        return doc ;
    }

    @Override
    public void saveDoctor(Doctor doctor) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        session.save(doctor);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        session.update(doctor);
        transaction.commit();
        session.close();

    }

    @Override
    public void deleteDoctor(String  doctorPersonalCode) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("select FIRSTNAME, LASTNAME, visitDate from Patient where PERSONALID=:PERSONALID");
        query.setString("PERSONALID", doctorPersonalCode);
    }

    @Override
    public List<Doctor> findAllDoctors() {
        return null;
    }

    @Override
    public List<Patient> findAllPatientsByDoctorId(String doctorId) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("select FIRSTNAME, LASTNAME, visitDate from Patient where DOCTORID=:DOCTORID");
        query.setString("DOCTORID", doctorId);
        List <Patient>listOfPatients = query.list();
        return listOfPatients;
    }

    @Override
    public boolean signginDoctor(String userName, String password) {

        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();

        session.beginTransaction();

        Query query = session.createQuery("from Doctor where USERNAME=:USERNAME and PASSWORD=:PASSWORD");
        query.setString("USERNAME", userName);
        query.setString("PASSWORD", password);

        List list = query.list();

        if(list.size()==1){
            System.out.println("Вы залогинились");
            return true;

        }else{
            System.out.println("Вы  не залогинились");
            return false;
        }

    }

    @Override
    public List  findDoctrorNameByUserName(String userName) {
        String doctorName = "";
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();

        session.beginTransaction();
        Query query = session.createQuery("select FIRSTNAME from Doctor where USERNAME=:USERNAME ");
        query.setString("USERNAME", userName);

        List  firstName = query.list();
        return firstName;
    }
    @Override
    public List findDoctorLastNameByUserName(String userName) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();

        session.beginTransaction();
        Query query = session.createQuery("select  LASTNAME from Doctor where USERNAME=:USERNAME ");
        query.setString("USERNAME", userName);

        List  Lstname = query.list();
        return Lstname;
    }

    @Override
    public List<Integer> findDoctorIdByDoctorUsername(String doctorUserName) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("select ID from Doctor where USERNAME=:USERNAME ");
        query.setString("USERNAME", doctorUserName);
        List <Integer> id = query.list();
        return id;
    }


    @Override
    public boolean checkIfUserNameExists(String doctorUserName) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("select USERNAME from Doctor where USERNAME=:USERNAME");
        query.setString("USERNAME", doctorUserName);
        List userNames = query.list();
        if(userNames.size() >=1){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public String checkDoctorRole(String userName, String role) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("select USERNAME from Doctor where ROLE=:ROLE");
        query.setString("ROLE", role);
        String doctorRole = query.toString();
        return doctorRole;
    }

    @Override
    public void countPateintsPriceByDoctorId(String doctorId) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("select PRICE from Material where ROLE=:ROLE");
    }






}