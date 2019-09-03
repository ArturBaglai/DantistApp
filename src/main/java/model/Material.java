
package model;


import javax.persistence.*;


import java.util.List;
@Entity
@Table(name="MATERIAL")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(name = "PRICE")
    private double PRICE;
    @Column(name = "MATERIALNAME")
    public String MATERIALNAME;

    @OneToMany(mappedBy = "MATERIAL_ID", cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "SEAL_ID")
    private List<Seal> seals;

    public Material(){

    }
    public Material(String MATERIALNAME, double PRICE) {


        this.MATERIALNAME = MATERIALNAME;
        this.PRICE = PRICE;
    }

    // @OneToOne(mappedBy = "seal", cascade = CascadeType.ALL, orphanRemoval = true)




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPRICE() {
        return PRICE;
    }

    public void setPRICE(double PRICE) {
        this.PRICE = PRICE;
    }

    public String getMATERIALNAME() {
        return MATERIALNAME;
    }

    public void setMATERIALNAME(String MATERIALNAME) {
        this.MATERIALNAME = MATERIALNAME;
    }

    public List<Seal>  getSeals() {
        return seals;
    }

    public void setListOfSeals(List<Seal> seals) {
        this.seals = seals;
    }

}
