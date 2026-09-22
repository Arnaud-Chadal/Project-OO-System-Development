package com.graniteam.gameview.data;
import jakarta.persistence.*;

@Entity
public class Review
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_seq")
    @SequenceGenerator(name = "review_seq", sequenceName = "review_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    private Game game;
    private String title;
    private String description;
    private Float rating;

    public Review()
    {
        game = null;
        title = "";
        description = "";
        rating = -1f;
    }

    public Review(Game game, User user, String title, String description, Float rating)
    {
        this.game = game;
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    public Long getId() {return id;}

    public Game getGame() {return game;}
    public void setGame(Game game) {this.game = game;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public Float getRating() {return rating;}
    public void setRating(Float rating) {this.rating = rating;}
}
