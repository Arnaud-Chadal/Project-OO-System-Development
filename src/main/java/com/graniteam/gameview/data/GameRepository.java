package com.graniteam.gameview.data;
import com.graniteam.gameview.data.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {
}