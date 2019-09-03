package model;

import java.time.LocalDate;
import javax.persistence.*;





@Entity
@Table (name="SEAL")

public class Seal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IDSEAL;
    @Column(name = "DENT_IDDENT")
    private int DENT_IDDENT;


    @Column(name = "SEAL_DATE")
    private LocalDate SEAL_DATE;
    @Column(name = "WORK_PRICE")
    private double WORKPRICE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MATERIAL_ID")
    private Material MATERIAL_ID;

    public Seal(int IDSEAL, int DENT_IDDENT,  LocalDate SEALDATE, double WORKPRICE) {
        this.IDSEAL = IDSEAL;
        this.DENT_IDDENT = DENT_IDDENT;

        this.SEAL_DATE = SEALDATE;
        this.WORKPRICE = WORKPRICE;
    }

    public int getIDSEAL() {
        return IDSEAL;
    }

    public void setIDSEAL(int IDSEAL) {
        this.IDSEAL = IDSEAL;
    }

    public int getDENT_IDDENT() {
        return DENT_IDDENT;
    }

    public void setDENT_IDDENT(int DENT_IDDENT) {
        this.DENT_IDDENT = DENT_IDDENT;
    }

    public Material getMATERIAL_ID() {
        return MATERIAL_ID;
    }

    public Material setMATERIAL_ID(Material MATERIAL) {
        this.MATERIAL_ID = MATERIAL;
        return MATERIAL;
    }

    public LocalDate getSEALDATE() {
        return SEAL_DATE;
    }

    public void setSEALDATE(LocalDate SEALDATE) {
        this.SEAL_DATE = SEALDATE;
    }

    public double getWORKPRICE() {
        return WORKPRICE;
    }

    public void setWORKPRICE(double WORKPRICE) {
        this.WORKPRICE = WORKPRICE;
    }


}
