package Services;

import DAOimpl.DoctorDAOimpl;
import model.Doctor;
import java.util.List;
public class DoctorService {
    private DoctorDAOimpl doctorDAOimpl = new DoctorDAOimpl();

    public void saveDoctor(Doctor doctor){
        doctorDAOimpl.saveDoctor(doctor);
    }
    public void signInDoctor(String userName, String password){
        doctorDAOimpl.signginDoctor(userName, password);
    }
    public void findAllPatientsByDoctorId (String doctorId){
        doctorDAOimpl.findAllPatientsByDoctorId(doctorId);
    }

    public void deleteDoctorByPersonalCode (String doctorPersonalCode){
        doctorDAOimpl.deleteDoctor(doctorPersonalCode);
    }
    public List  findDoctorIdByDoctorUsername (String dictorUserName){
        List doctorLoggedInId =  doctorDAOimpl.findDoctorIdByDoctorUsername(dictorUserName);
        return doctorLoggedInId;
    }
    public List <Doctor> findDoctorFirstNameByDoctorUsername (String doctorUserName){
        List doctorLoggedInFirstName =  doctorDAOimpl.findDoctrorNameByUserName(doctorUserName);
        return doctorLoggedInFirstName;
    }
    public List <Doctor> findDoctorLastNameByDoctorUsername (String doctorUserName){
        List doctorLoggedInLastName =  doctorDAOimpl.findDoctorLastNameByUserName(doctorUserName);
        return doctorLoggedInLastName;
    }
}

