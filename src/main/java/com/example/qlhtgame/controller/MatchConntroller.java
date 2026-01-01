package com.example.qlhtgame.controller;

import com.example.qlhtgame.entity.Match;
import com.example.qlhtgame.service.MatchService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/matches")
public class MatchConntroller {

    private final MatchService service;

    public MatchConntroller(MatchService service) {
        this.service = service;
    }

    @PostMapping
    public Match submit(@RequestBody Match match) {
        return service.saveResult(match);
    }
}
