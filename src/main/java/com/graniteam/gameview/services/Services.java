package com.graniteam.gameview.services;
import com.graniteam.gameview.data.Review;
import org.springframework.stereotype.Service;

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


}
