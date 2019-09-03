package DAO;

import model.DeseaseHistory;
import model.Doctor;
import model.Patient;

public interface PatientDAO
{
    public void savePatient(Patient patient);
    public void updatePatient(Patient patient);
    public void deletePatient(Patient patient);
    public Patient findPatientByFirstName(String firstName);
    public Patient findPatientByLastName(String lastName);
    public Doctor findDoctorByPatintFirstName(String firstName);
    public Doctor findDoctorByPatintLastName(String lastName);
    public DeseaseHistory findDeseaseHistoryPatintLastName(String lastName);
}
