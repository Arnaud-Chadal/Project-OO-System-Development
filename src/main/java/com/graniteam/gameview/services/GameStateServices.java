package com.graniteam.gameview.services;

import com.graniteam.gameview.data.GameState;
import com.graniteam.gameview.data.GameStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameStateServices
{

    @Autowired
    private GameStateRepository gameStateRepository;

    public GameState addGameState(GameState gameState) {
        return gameStateRepository.save(gameState);
    }

    public List<GameState> getAllGameStates() {
        return (List<GameState>) gameStateRepository.findAll();
    }

    public Optional<GameState> getGameStateById(Long id) {
        return gameStateRepository.findById(id);
    }
}