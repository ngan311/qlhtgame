package com.example.qlhtgame.service;

import com.example.qlhtgame.entity.Game;
import com.example.qlhtgame.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository repo;

    public GameService(GameRepository repo) {
        this.repo = repo;
    }

    public List<Game> getAll() {
        return repo.findAll();
    }

    public Game create(Game g) {
        return repo.save(g);
    }

    public Game update(Long id, Game data) {
        Game g = repo.findById(id).orElseThrow();
        g.setName(data.getName());
        g.setCategory(data.getCategory());
        g.setOnline(data.isOnline());
        return repo.save(g);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
