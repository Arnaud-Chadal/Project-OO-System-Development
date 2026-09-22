package com.graniteam.gameview.data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

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
    private GameState state;

    @ManyToOne
    @JsonIgnore
    public User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
    @JsonIgnore
    public Collection<Review> reviews;

    public Game()
    {
        name = "";
        user = null;
        purchaseDate = LocalDate.now().toString();
        playingDevice = "";
        playTimeHours = 0f;
        state = GameState.Default;
        reviews = new ArrayList<>();
    }

    public Game(String name, String purchaseDate, String playingDevice)
    {
        this.name = name;
        user = null;
        this.purchaseDate = purchaseDate;
        this.playingDevice = playingDevice;
        playTimeHours = 0f;
        state = GameState.Default;
        reviews = new ArrayList<>();
    }

    public Long getId() {return id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public User getUser() {return user;}
    public void setUser(User newUser) {user = newUser;}

    public String getPurchaseDate() {return purchaseDate;}
    public void setPurchaseDate(String purchaseDate) {this.purchaseDate = purchaseDate;}

    public String getPlayingDevice() {return playingDevice;}
    public void setPlayingDevice(String playingDevice) {this.playingDevice = playingDevice;}

    public Float getPlayTimeHours() {return playTimeHours;}
    public void setPlayTimeHours(Float playTimeHours) {this.playTimeHours = playTimeHours;}

    public GameState getState() {return state;}
    public void setState(GameState state) {this.state = state;}

    public Collection<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Collection<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review) {
        this.getReviews().add(review);
        review.setGame(this);
    }
}
