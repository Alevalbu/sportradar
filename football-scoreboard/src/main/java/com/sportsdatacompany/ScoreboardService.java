package com.sportsdatacompany;

import java.util.List;

public class ScoreboardService {
    private final Scoreboard scoreboard;

    public ScoreboardService() {
        this.scoreboard = new Scoreboard();
    }

    public Match startMatch(String homeTeam, String awayTeam) {
        return scoreboard.startMatch(homeTeam, awayTeam);
    }

    public void updateScore(Match match, int homeScore, int awayScore) {
        scoreboard.updateScore(match, homeScore, awayScore);
    }

    public void finishMatch(Match match) {
        scoreboard.finishMatch(match);
    }

    public List<Match> getSummary() {
        return scoreboard.getSummary();
    }
}