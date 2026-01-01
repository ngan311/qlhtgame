package com.example.qlhtgame.controller;

import com.example.qlhtgame.repository.GameRepository;
import com.example.qlhtgame.repository.PlayerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final PlayerRepository playerRepo;
    private final GameRepository gameRepo;

    public AdminController(PlayerRepository p, GameRepository g) {
        this.playerRepo = p;
        this.gameRepo = g;
    }

    @GetMapping("/stats")
    public Map<String, Object> stats() {
        Map<String, Object> map = new HashMap<>();
        map.put("activePlayers", playerRepo.countActivePlayers());
        map.put("onlineGames", gameRepo.countOnlineGames());
        return map;
    }
}
