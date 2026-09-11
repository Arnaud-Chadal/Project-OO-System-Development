package com.graniteam.gameview.services;
import com.graniteam.gameview.data.Game;
import com.graniteam.gameview.data.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GameServices
{

    @Autowired
    private GameRepository gameRepository;

    public Game addGame(Game Game) {
        return gameRepository.save(Game);
    }

    public List<Game> getAllGames() {
        return (List<Game>) gameRepository.findAll();
    }

    public Optional<Game> getGameById(Long id) {
        return gameRepository.findById(id);
    }
}