package Services;

import DAOimpl.PatientDAOimpl;
import model.Patient;

public class PatientService {
    private PatientDAOimpl patientDAOimpl = new PatientDAOimpl();

    public void savePatient(Patient patient)
    {
        patientDAOimpl.savePatient(patient);
    }
}
