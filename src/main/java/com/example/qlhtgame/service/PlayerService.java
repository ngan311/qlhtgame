package com.example.qlhtgame.service;

import com.example.qlhtgame.entity.Player;
import com.example.qlhtgame.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository repo;

    public PlayerService(PlayerRepository repo) {
        this.repo = repo;
    }

    public List<Player> getAll() {
        return repo.findAll();
    }

    public Player create(Player player) {
        player.setScore(0);
        player.setWinCount(0);
        player.setTotalMatch(0);
        player.setActive(true);
        return repo.save(player);
    }

    public Player update(Long id, Player data) {
        Player p = repo.findById(id).orElseThrow();
        p.setName(data.getName());
        return repo.save(p);
    }

    public void lockPlayer(Long id) {
        Player p = repo.findById(id).orElseThrow();
        p.setActive(false);
        repo.save(p);
    }

    public List<Player> ranking() {
        return repo.findAll()
                .stream()
                .sorted((a, b) -> b.getScore() - a.getScore())
                .toList();
    }
}
