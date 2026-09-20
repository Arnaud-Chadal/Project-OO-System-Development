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


    @GetMapping("/addGame/userId:{userId}/name:{name}/purchaseDate:{purchaseDate}/device:{device}")
    public Long addGame(@PathVariable("userId") Long userId, @PathVariable("name") String name, @PathVariable("purchaseDate") String purchaseDate, @PathVariable("device") String device)
    {
        return services.addGame(userId, name, purchaseDate, device);
    }

    @GetMapping("/addReview/userId:{userId}/gameId:{gameId}/title:{title}/description:{description}/rating:{rating}")
    public Long addReview(@PathVariable("userId") Long userId, @PathVariable("gameId") Long gameId, @PathVariable("title") String title, @PathVariable("description") String description, @PathVariable("rating") Float rating)
    {
        return services.addReview(userId, gameId, title, description, rating);
    }

    @GetMapping("/addUser/name:{name}/accountCreationDate:{accountCreationDate}")
    public Long addUser(@PathVariable("name") String name, @PathVariable("accountCreationDate") String accountCreationDate)
    {
        return services.addUser(name, accountCreationDate);
    }

    @GetMapping("/editGameState/gameId:{gameId}/state:{state}/hoursToAdd:{hoursToAdd}")
    public Boolean editGame(@PathVariable("gameId") Long gameId, @PathVariable("state") String state, @PathVariable("hoursToAdd") Float hoursToAdd)
    {
        return services.editGameState(gameId, state, hoursToAdd);
    }

    @GetMapping("/editUser/userId:{userId}/name:{name}")
    public Boolean editUser(@PathVariable("userId") Long userId, @PathVariable("name") String name)
    {
        return services.editUser(userId, name);
    }

    @GetMapping("/editReview/reviewId:{reviewId}/title:{title}/description:{description}/rating:{rating}")
    public Boolean editReview(@PathVariable("reviewId") Long reviewId, @PathVariable("title") String title, @PathVariable("description") String description, @PathVariable("rating") Float rating)
    {
        return services.editReview(reviewId, title, description, rating);
    }

    @GetMapping("/deleteReview/reviewId:{reviewId}")
    public Boolean deleteReview(@PathVariable("reviewId") Long reviewId)
    {
        return services.deleteReview(reviewId);
    }
}
