package com.example.qlhtgame.service;

import com.example.qlhtgame.entity.Match;
import com.example.qlhtgame.entity.Player;
import com.example.qlhtgame.repository.MatchRepository;
import com.example.qlhtgame.repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service

public class MatchService {

    private final MatchRepository matchRepo;
    private final PlayerRepository playerRepo;

    public MatchService(MatchRepository matchRepo, PlayerRepository playerRepo) {
        this.matchRepo = matchRepo;
        this.playerRepo = playerRepo;
    }

    public Match saveResult(Match match) {

        Player p = match.getPlayer();
        Player dbPlayer = playerRepo.findById(p.getId()).orElseThrow();

        dbPlayer.setTotalMatch(dbPlayer.getTotalMatch() + 1);

        if ("WIN".equals(match.getResult())) {
            dbPlayer.setWinCount(dbPlayer.getWinCount() + 1);
            dbPlayer.setScore(dbPlayer.getScore() + match.getScoreEarned());
        }

        playerRepo.save(dbPlayer);
        return matchRepo.save(match);
    }
}
