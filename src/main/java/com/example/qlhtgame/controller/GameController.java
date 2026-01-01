package com.example.qlhtgame.controller;

import com.example.qlhtgame.entity.Game;
import com.example.qlhtgame.service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    @GetMapping
    public List<Game> all() {
        return service.getAll();
    }

    @PostMapping
    public Game create(@RequestBody Game g) {
        return service.create(g);
    }

    @PutMapping("/{id}")
    public Game update(@PathVariable Long id, @RequestBody Game g) {
        return service.update(id, g);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
