package model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PATIENT")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PATIENTID")
    private int id;
    @Column(name = "FIRSTNAME")
    private String FIRSTNAME;
    @Column(name = "PERSONALID")
    private String PERSONALID;
    @Column(name = "EMAIL")
    private String EMAIL;
    @Column(name = "ADRESS")
    private String ADRESS;
    @Column(name = "TELEPHONE")
    private String TELEPHONE;
    @Column(name = "LASTNAME")
    private String LASTNAME;
    @Column(name = "VISITDATE")
    private LocalDate visitDate;
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "DOCTORID")
    @Column(name = "DOCTORID")
    private int doctor;
    @Column(name = "TIME")
    private String time;

    public Patient(){

    }

    public Patient(String FIRSTNAME, String PERSONALID, String EMAIL, String ADRESS, String TELEPHONE, String LASTNAME, LocalDate visitDate, int doctorId,String time) {
        this.FIRSTNAME = FIRSTNAME;
        this.PERSONALID = PERSONALID;
        this.EMAIL = EMAIL;
        this.ADRESS = ADRESS;
        this.TELEPHONE = TELEPHONE;
        this.LASTNAME = LASTNAME;
        this.visitDate = visitDate;
        this.doctor = doctorId;
        this.time=time;
    }

    public String getFIRSTNAME() {
        return FIRSTNAME;
    }

    public void setFIRSTNAME(String name) {
        this.FIRSTNAME = name;
    }

    public String getPERSONALID() {
        return PERSONALID;
    }

    public void setPERSONALID(String PERSONALID) {
        this.PERSONALID = PERSONALID;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getADRESS() {
        return ADRESS;
    }

    public void setADRESS(String ADRESS) {
        this.ADRESS = ADRESS;
    }

    public String getTELEPHONE() {
        return TELEPHONE;
    }

    public void setTELEPHONE(String TELEPHONE) {
        this.TELEPHONE = TELEPHONE;
    }

    public String getLASTNAME() {
        return LASTNAME;
    }

    public void setLASTNAME(String LASTNAME) {
        this.LASTNAME = LASTNAME;
    }
    //private String doctorsNameAndLastName;

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }



    // public String getDoctorsNameAndLastName() {
    //     return doctorsNameAndLastName;
    //}
    // public void setDoctorsNameAndLastName(String doctorsNameAndLastName) {
    //      this.doctorsNameAndLastName = doctorsNameAndLastName;
    //  }

    public int getDoctor() {
        return doctor;
    }

    public void setDoctor(int doctor) {
        this.doctor = doctor;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }




}
