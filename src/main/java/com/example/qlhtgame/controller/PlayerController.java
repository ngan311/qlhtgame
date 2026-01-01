package com.example.qlhtgame.controller;

import com.example.qlhtgame.entity.Player;
import com.example.qlhtgame.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Player> all() {
        return service.getAll();
    }

    @PostMapping
    public Player create(@RequestBody Player p) {
        return service.create(p);
    }

    @PutMapping("/{id}")
    public Player update(@PathVariable Long id, @RequestBody Player p) {
        return service.update(id, p);
    }

    @PutMapping("/{id}/lock")
    public void lock(@PathVariable Long id) {
        service.lockPlayer(id);
    }

    @GetMapping("/ranking")
    public List<Player> ranking() {
        return service.ranking();
    }
}
