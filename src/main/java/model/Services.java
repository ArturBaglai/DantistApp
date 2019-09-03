package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="SERVICES")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IDSERVICES")
    private int IDSERVICES;
    @Column(name="NAME")
    private String NAME;
    @Column(name="PRICE")
    private double PRICE;
    @OneToMany(mappedBy = "services", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DeseaseHistory> DeseaseHistories;


    public Services(int IDSERVICES, String NAME, double PRICE) {
        this.IDSERVICES = IDSERVICES;
        this.NAME = NAME;
        this.PRICE = PRICE;
    }


    public int getIDSERVICES() {
        return IDSERVICES;
    }

    public void setIDSERVICES(int IDSERVICES) {
        this.IDSERVICES = IDSERVICES;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public double getPRICE() {
        return PRICE;
    }

    public void setPRICE(double PRICE) {
        this.PRICE = PRICE;
    }
    public List<DeseaseHistory> getDeseaseHistories() {
        return DeseaseHistories;
    }
    public void setDeseaseHistories(List<DeseaseHistory> DeseaseHistories) {
        this.DeseaseHistories = DeseaseHistories;
    }
}
