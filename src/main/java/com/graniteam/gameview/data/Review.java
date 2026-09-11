package com.graniteam.gameview.data;
import jakarta.persistence.*;

@Entity
public class Review
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_seq")
    @SequenceGenerator(name = "review_seq", sequenceName = "review_id_seq", allocationSize = 1)
    private Long id;

    private String title;
    private String description;
    private Integer rating;

    public Review()
    {
        title = "";
        description = "";
        rating = 5;
    }

    public Review(String title, String description, Integer rating)
    {
        this.title = title;
        this.description = description;
        this.rating = rating;
    }


    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public Integer getRating() {return rating;}
    public void setRating(Integer rating) {this.rating = rating;}
}
