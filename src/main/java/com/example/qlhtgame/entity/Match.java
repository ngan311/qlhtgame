package com.example.qlhtgame.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String result; // WIN / LOSE / DRAW
    private int scoreEarned;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    // ===== getter & setter =====

    public Long getId() {
        return id;
    }

    public String getResult() {
        return result;
    }

    public int getScoreEarned() {
        return scoreEarned;
    }

    public Player getPlayer() {
        return player;
    }

    public Game getGame() {
        return game;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setScoreEarned(int scoreEarned) {
        this.scoreEarned = scoreEarned;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
