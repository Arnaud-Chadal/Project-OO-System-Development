package com.graniteam.gameview.web;
import com.graniteam.gameview.data.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.graniteam.gameview.services.Services;

import java.util.List;

@RestController
public class AppServices
{
    @Autowired
    private Services services;

    public AppServices() {}

    @GetMapping("/test")
    public List<Review> test() {
        services.publishReview("problem", "fqfefge", 3);
        return services.getAllReviews();
    }
}
