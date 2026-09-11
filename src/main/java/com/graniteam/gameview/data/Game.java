package com.graniteam.gameview.data;
import jakarta.persistence.*;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_seq")
    @SequenceGenerator(name = "game_seq", sequenceName = "game_id_seq", allocationSize = 1)
    private Long id;

    private String name;
    private String purchaseDate;
    private String playingDevice;
    private Float playTimeHours;

    public Game()
    {
        name = "";
        purchaseDate = "";
        playingDevice = "";
        playTimeHours = 0f;
    }

    public Game(String name, String purchaseDate, String playingDevice, Float playTimeHours)
    {
        this.name = name;
        this.purchaseDate = purchaseDate;
        this.playingDevice = playingDevice;
        this.playTimeHours = playTimeHours;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getPurchaseDate() {return purchaseDate;}
    public void setPurchaseDate(String purchaseDate) {this.purchaseDate = purchaseDate;}

    public String getPlayingDevice() {return playingDevice;}
    public void setPlayingDevice(String playingDevice) {this.playingDevice = playingDevice;}

    public Float getPlayTimeHours() {return playTimeHours;}
    public void setPlayTimeHours(Float playTimeHours) {this.playTimeHours = playTimeHours;}
}
