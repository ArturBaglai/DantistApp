package DAO;

import javafx.collections.ObservableList;
import model.Doctor;
import model.Patient;

import java.util.List;

public interface DoctorDAO {
    public List findDoctrorNameByUserName (String userName);
    public List findDoctorLastNameByUserName(String userName);
    public void saveDoctor (Doctor doctor);
    public void updateDoctor (Doctor doctor);
    public void deleteDoctor (String doctorPersonalCode);
    public String checkDoctorRole(String userName, String role);


    public List<Doctor> findAllDoctors();
    public List<Patient> findAllPatientsByDoctorId(String doctorId);
    public boolean signginDoctor(String userName, String password);
    public List findDoctorIdByDoctorUsername(String dictorUserName);
    public boolean checkIfUserNameExists(String doctorUserName);

    public void countPateintsPriceByDoctorId(String doctorId);



}
