package com.graniteam.gameview.services;
import com.graniteam.gameview.data.Game;
import com.graniteam.gameview.data.Review;
import com.graniteam.gameview.data.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class Services
{
    private final ReviewServices reviewServices;
    private final GameServices gameServices;
    private final UserServices userServices;

    public Services(ReviewServices reviewServices, GameServices gameServices, UserServices userServices) {
        this.reviewServices = reviewServices;
        this.gameServices = gameServices;
        this.userServices = userServices;
    }

    public Long addGame(Long userId, String name, String purchaseDate, String device)
    {
        Game newGame = new Game(name, userId, purchaseDate, device);
        gameServices.addGame(newGame);
        return newGame.getId();
    }

    public Long addReview(Long userId, Long gameId, String title, String description, Float rating)
    {
        Review newReview = new Review(gameId, userId, title, description, rating);
        reviewServices.addReview(newReview);
        return newReview.getId();
    }

    public Long addUser(String name, String accountCreationDate)
    {
        User newUser = new User(name, accountCreationDate);
        userServices.addUser(newUser);
        return newUser.getId();
    }

    public Boolean editGameState(Long gameId, String state, Float hoursToAdd)
    {
        Optional<Game> optionalGame = gameServices.getGameById(gameId);
        optionalGame.ifPresent(game -> {
            game.setState(state);
            game.setPlayTimeHours(game.getPlayTimeHours()+hoursToAdd);
            gameServices.addGame(game);
        });
        return true;
    }

    public Boolean editUser(Long userId, String name)
    {
        Optional<User> optionalUser = userServices.getUserById(userId);
        optionalUser.ifPresent(user -> {
            user.setName(name);
            userServices.addUser(user);
        });
        return true;
    }

    public Boolean editReview(Long reviewId, String title, String description, Float rating)
    {
        Optional<Review> optionalReview = reviewServices.getReviewById(reviewId);
        optionalReview.ifPresent(review -> {
            review.setTitle(title);
            review.setDescription(description);
            review.setRating(rating);
            reviewServices.addReview(review);
        });
        return true;
    }

    public Boolean deleteReview(Long reviewId)
    {
        Optional<Review> optionalReview = reviewServices.getReviewById(reviewId);
        optionalReview.ifPresent(review -> {
            reviewServices.deleteReview(review);
        });
        return true;
    }
}
