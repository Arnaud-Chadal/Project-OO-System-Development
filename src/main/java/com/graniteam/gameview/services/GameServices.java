package com.graniteam.gameview.services;
import com.graniteam.gameview.data.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GameServices
{

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private UserRepository userRepository;

    public Game addGame(Game game) {
        return gameRepository.save(game);
    }

    public Game addGame(Game game, long userId) {
        game.setState(GameState.NotPlaying);
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        user.addGamePossessed(game);
        return gameRepository.save(game);
    }

    public List<Game> getAllGames() {
        return (List<Game>) gameRepository.findAll();
    }

    public Optional<Game> getGameById(Long id) {
        return gameRepository.findById(id);
    }

    public Collection<Game> getGamesForUserId(long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        return user.getGamesPossessed();
    }

    public Game updateGame(Game newGame, long gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + gameId));
        if (!newGame.getName().isEmpty() && !newGame.getName().isBlank()) {
            game.setName(newGame.getName());
        }
        if (newGame.getState() != GameState.Default) {
            game.setState(newGame.getState());
        }
        if (newGame.getPlayTimeHours() != 0) {
            game.setPlayTimeHours(newGame.getPlayTimeHours());
        }
        gameRepository.save(game);
        return game;
    }
}