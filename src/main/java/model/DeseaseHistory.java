package model;

import javax.persistence.*;
import javax.print.Doc;


@Entity
@Table(name="DESEASEHISTORY")
public class DeseaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name ="IDHISTORY")
    private int IDHISTORY;
    // @Column(name ="DOCTORID")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID")
    private  Doctor doctor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DESEASE_IDDESEASE")
    private  Desease desease;
    //private int DESEASE_IDDESEASE;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENT_PATIENTID")
    private Patient patient;
    //private int PATIENT_PATIENTID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SERVICES_IDSERVICES")
    private Services services;
    //private int SERVISES_IDSERVISES;
    //private int DOCTOR_ID ;
    //@OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "DENTID")
    @OneToOne(mappedBy = "dent",cascade = CascadeType.ALL, orphanRemoval = true)
    private Dent dent;

    public DeseaseHistory ()
    {

    }

    // private int  DENTID

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Desease getDesease() {
        return desease;
    }

    public void setDesease(Desease desease) {
        this.desease = desease;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public Dent getDent() {
        return dent;
    }

    public void setDent(Dent dent) {
        this.dent = dent;
    }

}
