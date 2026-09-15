package com.graniteam.gameview.services;
import com.graniteam.gameview.data.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Services
{
    private final ReviewServices reviewServices;

    public Services(ReviewServices reviewServices) {
        this.reviewServices = reviewServices;
    }

    public Boolean publishReview(String title, String description, Integer rating)
    {
        Review newReview = new Review(title, description, rating);
        reviewServices.addReview(newReview);
        return true;
    }

    public List<Review> getAllReviews(){return reviewServices.getAllReviews();}
}
