package com.graniteam.gameview.web;
import com.graniteam.gameview.data.Game;
import com.graniteam.gameview.data.Review;
import com.graniteam.gameview.data.User;
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

    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable("userId") long userId) {
        return services.getUserById(userId);
    }

    @PostMapping("/addGame")
    public Long addGame(@RequestBody Game game)
    {
        return services.addGame(game);
    }

    @PostMapping("/addReview/userId:{userId}/gameId:{gameId}/title:{title}/description:{description}/rating:{rating}")
    public Long addReview(@PathVariable("userId") Long userId, @PathVariable("gameId") Long gameId, @PathVariable("title") String title, @PathVariable("description") String description, @PathVariable("rating") Float rating)
    {
        return services.addReview(userId, gameId, title, description, rating);
    }

    @PostMapping("/addUser/name:{name}/accountCreationDate:{accountCreationDate}")
    public Long addUser(@PathVariable("name") String name, @PathVariable("accountCreationDate") String accountCreationDate)
    {
        return services.addUser(name, accountCreationDate);
    }

    @PutMapping("/editGameState/gameId:{gameId}/state:{state}/hoursToAdd:{hoursToAdd}")
    public Boolean editGame(@PathVariable("gameId") Long gameId, @PathVariable("state") String state, @PathVariable("hoursToAdd") Float hoursToAdd)
    {
        return services.editGameState(gameId, state, hoursToAdd);
    }

    @PutMapping("/editUser/userId:{userId}/name:{name}")
    public Boolean editUser(@PathVariable("userId") Long userId, @PathVariable("name") String name)
    {
        return services.editUser(userId, name);
    }

    @PutMapping("/editReview/reviewId:{reviewId}/title:{title}/description:{description}/rating:{rating}")
    public Boolean editReview(@PathVariable("reviewId") Long reviewId, @PathVariable("title") String title, @PathVariable("description") String description, @PathVariable("rating") Float rating)
    {
        return services.editReview(reviewId, title, description, rating);
    }

    @DeleteMapping("/deleteReview/reviewId:{reviewId}")
    public Boolean deleteReview(@PathVariable("reviewId") Long reviewId)
    {
        return services.deleteReview(reviewId);
    }
}
