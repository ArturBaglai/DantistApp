package model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Entity
@Table (name="DOCTOR")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column(name = "FIRSTNAME", nullable = false)
    private String FIRSTNAME;
    @Column(name = "PERSONALID", nullable = false)
    private String PERSONALID;
    @Column(name = "EMAIL", nullable = false)
    private String EMAIL;
    @Column(name = "TELEFON", nullable = false)
    private String TELEFON;
    @Column(name = "ADRESS", nullable = false)
    private String ADRESS;
    @Column(name = "PASSWORD", length = 8, nullable = false)
    private String PASSWORD;
    @Column(name = "LASTNAME", nullable = false)
    private String LASTNAME;
    @Column(unique = true, nullable = false)
    private String USERNAME;
    @Column(unique = true, nullable = false)
    private String ROLE;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DeseaseHistory> DeseaseHistories;
    @OneToMany (mappedBy = "doctor",  orphanRemoval = true)
    private List<Patient> patients;


    public Doctor() {

    }
    public Doctor( String FIRSTNAME, String PERSONALID, String EMAIL, String TELEFON, String ADRESS, String PASSWORD, String LASTNAME, String USERNAME,String ROLE) {

        this.FIRSTNAME = FIRSTNAME;
        this.PERSONALID = PERSONALID;
        this.EMAIL = EMAIL;
        this.TELEFON = TELEFON;
        this.ADRESS = ADRESS;
        this.PASSWORD = PASSWORD;
        this.LASTNAME = LASTNAME;
        this.USERNAME = USERNAME;
        this.ROLE=ROLE;
        DeseaseHistories = new ArrayList<>();
        patients = new ArrayList<>();
    }
    public void addNewDeseaseHistory(DeseaseHistory deseaseHistory)
    {
        deseaseHistory.setDoctor(deseaseHistory.getDoctor());
        DeseaseHistories.add(deseaseHistory);
    }
    public void removeDeseaseHistory (DeseaseHistory deseaseHistory)
    {
        DeseaseHistories.remove(deseaseHistory);
    }


    public int getId() {
        return ID;
    }

    public void setId(int ID) {
        this.ID = ID;
    }

    public String getFIRSTNAME() {
        return FIRSTNAME;
    }

    public void setFIRSTNAME(String FIRSTNAME) {
        this.FIRSTNAME = FIRSTNAME;
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

    public String getTELEFON() {
        return TELEFON;
    }

    public void setTELEFON(String TELEFON) {
        this.TELEFON = TELEFON;
    }

    public String getADRESS() {
        return ADRESS;
    }

    public void setADRESS(String ADRESS) {
        this.ADRESS = ADRESS;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getLASTNAME() {
        return LASTNAME;
    }

    public void setLASTNAME(String LASTNAME) {
        this.LASTNAME = LASTNAME;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }
    public List<DeseaseHistory> getDeseaseHistories() {
        return DeseaseHistories;
    }

    public void setDeseaseHistories(List<DeseaseHistory> DeseaseHistories) {
        this.DeseaseHistories = DeseaseHistories;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public String getROLE() {
        return ROLE;
    }

    public void setROLE(String ROLE) {
        this.ROLE = ROLE;
    }


}
