package com.graniteam.gameview.data;
import jakarta.persistence.*;

@Entity
public class GameState
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_seq")
    @SequenceGenerator(name = "game_seq", sequenceName = "game_id_seq", allocationSize = 1)
    private Long id;

    private Integer gameId;
    private Integer userId;
    private String state;

    public GameState()
    {
        gameId = 0;
        userId = 0;
        state = "";
    }

    public GameState(Integer gameId, Integer userId, String state)
    {
        this.gameId = gameId;
        this.userId = userId;
        this.state = state;
    }

    public Integer getGameId() {return gameId;}
    public void setGameId(Integer gameId) {this.gameId = gameId;}

    public Integer getUserId() {return userId;}
    public void setUserId(Integer userId) {this.userId = userId;}

    public String getState() {return state;}
    public void setState(String state) {this.state = state;}
}
