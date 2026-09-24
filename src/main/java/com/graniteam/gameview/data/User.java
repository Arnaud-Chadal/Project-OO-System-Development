package com.graniteam.gameview.data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "\"user\"")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_id_seq", allocationSize = 1)
    private Long id;

    private String name;
    private String accountCreationDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonIgnore
    public Collection<Game> gamesPossessed;

    public User()
    {
        name = "";
        accountCreationDate = LocalDate.now().toString();
        gamesPossessed = new ArrayList<>();
    }

    public User(String name, String accountCreationDate)
    {
        this.name = name;
        this.accountCreationDate = accountCreationDate;
        gamesPossessed = new ArrayList<>();
    }

    public Long getId() {return id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getAccountCreationDate() {return accountCreationDate;}
    public void setAccountCreationDate(String accountCreationDate) {this.accountCreationDate = accountCreationDate;}

    public Collection<Game> getGamesPossessed() {
        return gamesPossessed;
    }

    public void setGamesPossessed(Collection<Game> gamesPossessed) {
        this.gamesPossessed = gamesPossessed;
    }

    public void addGamePossessed(Game game) {
        this.getGamesPossessed().add(game);
        game.user = this;
    }
}
