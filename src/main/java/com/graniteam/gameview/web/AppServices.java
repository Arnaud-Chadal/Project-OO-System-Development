package com.graniteam.gameview.web;
import com.graniteam.gameview.data.Game;
import com.graniteam.gameview.data.Review;
import com.graniteam.gameview.data.User;
import com.graniteam.gameview.services.GameServices;
import com.graniteam.gameview.services.ReviewServices;
import com.graniteam.gameview.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class AppServices
{
    @Autowired
    private GameServices gameServices;
    @Autowired
    private ReviewServices reviewServices;
    @Autowired
    private UserServices userServices;

    public AppServices() {}

    // GET REQUESTS

    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable long userId) {
        return userServices.getUserById(userId);
    }

    @GetMapping("/users")
    public List<User> getAllUser() {
        return userServices.getAllUsers();
    }

    @GetMapping("/games")
    public List<Game> getAllGames() {return gameServices.getAllGames();}

    @GetMapping("/gamesByUser/{userId}")
    public Collection<Game> getGamesForUserId(@PathVariable long userId) {return gameServices.getGamesForUserId(userId);}

    @GetMapping("/getReviewsByGame/{gameId}")
    public Collection<Review> getReviewsForGameId(@PathVariable long gameId) {
        return reviewServices.getReviewsForGameId(gameId);
    }

    // POST REQUESTS

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user)
    {
        return userServices.addUser(user);
    }

    @PostMapping("/addGame")
    public Game addGame(@RequestBody Game game)
    {
        return gameServices.addGame(game);
    }

    @PostMapping("/addGame/{userId}")
    public Game addGame(@RequestBody Game game, @PathVariable long userId)
    {
        return gameServices.addGame(game, userId);
    }

    @PostMapping("/addReview")
    public Review addReview(@RequestBody Review review)
    {
        return reviewServices.addReview(review);
    }

    @PostMapping("/addReview/{gameId}")
    public Review addReview(@RequestBody Review review, @PathVariable long gameId)
    {
        return reviewServices.addReview(review, gameId);
    }

    // PUT REQUESTS

    @PutMapping("/editGame/{gameId}")
    public Game editGame(@RequestBody Game game, @PathVariable Long gameId)
    {
        return gameServices.updateGame(game, gameId);
    }

    @PutMapping("/editUser/{userId}")
    public User editUser(@RequestBody User user, @PathVariable Long userId)
    {
        return userServices.updateUser(user, userId);
    }

    @PutMapping("/editReview/{reviewId}")
    public Review editReview(@RequestBody Review review, @PathVariable Long reviewId)
    {
        return reviewServices.updateReview(review, reviewId);
    }

    @DeleteMapping("/deleteReview/{reviewId}")
    public Boolean deleteReview(@PathVariable Long reviewId)
    {
        return reviewServices.deleteReview(reviewId);
    }
}
