package DAO;

public interface ServicesDAO {
    public void findserviceByServiceName (String serviceName);
    public void findserviceByPatientFirstName (String patientFirstName);
    public void findserviceByPatientLastName (String patientLastName);
}
