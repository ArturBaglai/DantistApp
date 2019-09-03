package model;

import javax.persistence.*;

@Entity
@Table(name="CHANNELS")
public class Channels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCHANNELS")
    private int IDCHANNELS;
    @Column(name = "LENGTH")
    private char LENGTH;
    @Column(name = "DATE")
    private char DATE;
    @Column(name = "DENT_IDDENT")
    private int DENT_IDDENT;
    @Column(name = "CHANNELMATERIALS_ID")
    private int CHANNELMATERIALS_ID;
}
