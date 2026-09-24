package com.graniteam.gameview.services;
import com.graniteam.gameview.data.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServices
{

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private UserRepository userRepository;


    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review addReview(Review review, long gameId) {
        if (review.getRating() == -1f) {
            review.setRating(0f);
        }
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new EntityNotFoundException("Cannot found game with id: " + gameId));
        game.addReview(review);
        return reviewRepository.save(review);
    }

    public boolean deleteReview(Long reviewId) {
        Review revieweToDelete = reviewRepository.findById(reviewId).orElseThrow(() -> new EntityNotFoundException("Cannot found review with id: " + reviewId));
        reviewRepository.delete(revieweToDelete);
        return true;
    }

    public List<Review> getAllReviews() {
        return (List<Review>) reviewRepository.findAll();
    }

    public Collection<Review> getReviewsForGameId(long gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + gameId));
        return game.getReviews();
    }

    public Review updateReview(Review newReview, long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new EntityNotFoundException("Cannot found review with id: " + reviewId));
        if (!newReview.getTitle().isBlank() && !newReview.getTitle().isEmpty()) {
            review.setTitle(newReview.getTitle());
        }
        if (!newReview.getDescription().isEmpty() && !newReview.getDescription().isBlank()) {
            review.setDescription(newReview.getDescription());
        }
        if (newReview.getRating() != -1f) {
            review.setRating(newReview.getRating());
        }
        reviewRepository.save(review);
        return review;
    }
}