package DAOimpl;

import DAO.PatientDAO;
import model.DeseaseHistory;
import model.Doctor;
import model.Patient;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sample.HibernateSessionFactoryUtill;

public class PatientDAOimpl implements PatientDAO {

    @Override
    public void savePatient(Patient patient)
    {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        session.save(patient);
        transaction.commit();
        session.close();

    }

    @Override
    public void updatePatient(Patient patient)
    {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        session.update(patient);
        transaction.commit();
        session.close();
    }

    @Override
    public void deletePatient(Patient patient)
    {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        session.delete(patient);
        transaction.commit();
        session.close();
    }

    @Override
    public Patient findPatientByFirstName(String firstName) {
        return HibernateSessionFactoryUtill.getSessionFactory().openSession().get(Patient.class,firstName);
    }

    @Override
    public Patient findPatientByLastName(String lastName) {
       return HibernateSessionFactoryUtill.getSessionFactory().openSession().get(Patient.class,lastName);
    }

    @Override
    public Doctor findDoctorByPatintFirstName(String patientFirstName) {
      return HibernateSessionFactoryUtill.getSessionFactory().openSession().get(Doctor.class,patientFirstName);
    }

    @Override
    public Doctor findDoctorByPatintLastName(String patientLastName) {
        return HibernateSessionFactoryUtill.getSessionFactory().openSession().get(Doctor.class,patientLastName);
    }

    @Override
    public DeseaseHistory findDeseaseHistoryPatintLastName(String patientLastName) {
        return HibernateSessionFactoryUtill.getSessionFactory().openSession().get(DeseaseHistory.class,patientLastName);
    }
}
