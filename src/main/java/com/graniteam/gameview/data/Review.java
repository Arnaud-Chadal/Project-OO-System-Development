package com.graniteam.gameview.data;
import jakarta.persistence.*;

@Entity
public class Review
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_seq")
    @SequenceGenerator(name = "review_seq", sequenceName = "review_id_seq", allocationSize = 1)
    private Long id;

    private Long gameId;
    private Long userId;
    private String title;
    private String description;
    private Float rating;

    public Review()
    {
        gameId = 0L;
        userId = 0L;
        title = "";
        description = "";
        rating = 5f;
    }

    public Review(Long gameId, Long userId, String title, String description, Float rating)
    {
        this.gameId = gameId;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    public Long getId() {return id;}

    public Long getGameId() {return gameId;}
    public void setGameId(Long gameId) {this.gameId = gameId;}

    public Long getUserId() {return userId;}
    public void setUserId(Long userId) {this.userId = userId;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public Float getRating() {return rating;}
    public void setRating(Float rating) {this.rating = rating;}
}
