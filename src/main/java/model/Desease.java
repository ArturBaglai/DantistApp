package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="DESEASE")
public class Desease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="IDDESEASE")
    private int IDDESEASE;
    @Column(name="NAME")
    public String NAME;

    @OneToMany(mappedBy = "desease", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DeseaseHistory> deseaseHistories;

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }
}
