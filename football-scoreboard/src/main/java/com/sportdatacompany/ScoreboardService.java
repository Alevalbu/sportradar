package com.sportsdatacompany;

import java.util.List;

public class ScoreboardService {
    private final Scoreboard scoreboard;

    public ScoreboardService() {
        this.scoreboard = new Scoreboard();
    }

    public void startMatch(String homeTeam, String awayTeam) {
        scoreboard.startMatch(homeTeam, awayTeam);
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        scoreboard.updateScore(homeTeam, awayTeam, homeScore, awayScore);
    }

    public void finishMatch(String homeTeam, String awayTeam) {
        scoreboard.findMatch(homeTeam, awayTeam);
    }

    public List<String> getSummary() {
        return scoreboard.getSummary().stream().map(Match::toString).toList();
    }
}