package model;

import javax.persistence.*;

@Entity
@Table(name="DENT")
public class Dent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DENT_ID")
    private int DENT_ID;
    //@Column(name="DESEASE_IDDESEASE")

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DESEASE_IDDESEASE")
    private Dent dent;
    //@Column(name="IMAGEPATH")
    private String imagePath;
    @Column(name="DENTNUMBER")
    private String DENTNUMBER;

    public Dent() {

    }

    public Dent(String DENTNUMBER) {
        this.DENTNUMBER = DENTNUMBER;
    }

    public String getDENTNUMBER() {
        return DENTNUMBER;
    }

    public void setDENTNUMBER(String DENTNUMBER) {
        this.DENTNUMBER = DENTNUMBER;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
