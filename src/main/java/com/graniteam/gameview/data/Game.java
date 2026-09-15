package com.graniteam.gameview.data;
import jakarta.persistence.*;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_seq")
    @SequenceGenerator(name = "game_seq", sequenceName = "game_id_seq", allocationSize = 1)
    private Long id;

    private String name;
    private Long userId;
    private String purchaseDate;
    private String playingDevice;
    private Float playTimeHours;
    private String state;

    public Game()
    {
        name = "";
        userId = 0L;
        purchaseDate = "";
        playingDevice = "";
        playTimeHours = 0f;
        state = "stopped";
    }

    public Game(String name, Long userId, String purchaseDate, String playingDevice)
    {
        this.name = name;
        this.userId = userId;
        this.purchaseDate = purchaseDate;
        this.playingDevice = playingDevice;
        playTimeHours = 0f;
        state = "stopped";
    }

    public Long getId() {return id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Long getUserId() {return userId;}
    public void setUserId(Long userId) {this.userId = userId;}

    public String getPurchaseDate() {return purchaseDate;}
    public void setPurchaseDate(String purchaseDate) {this.purchaseDate = purchaseDate;}

    public String getPlayingDevice() {return playingDevice;}
    public void setPlayingDevice(String playingDevice) {this.playingDevice = playingDevice;}

    public Float getPlayTimeHours() {return playTimeHours;}
    public void setPlayTimeHours(Float playTimeHours) {this.playTimeHours = playTimeHours;}

    public String getState() {return state;}
    public void setState(String state) {this.state = state;}
}
