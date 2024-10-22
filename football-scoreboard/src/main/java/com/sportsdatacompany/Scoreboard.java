package com.sportsdatacompany;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Scoreboard {
    private final List<Match> matches;

    public Scoreboard() {
        this.matches = new ArrayList<>();
    }

    public Match startMatch(String homeTeam, String awayTeam) {
        Match match = new Match(homeTeam, awayTeam);
        matches.add(match);
        return match;
    }

    public void updateScore(Match match, int homeScore, int awayScore) {
        match.updateScore(homeScore, awayScore);
    }

    public void finishMatch(Match match) {
        matches.remove(match);
    }

    public List<Match> getSummary() {
        return matches.stream()
                .sorted(Comparator.comparing(Match::getTotalScore)
                        .thenComparing(Match::getStartTime).reversed())
                .collect(Collectors.toList());
    }

    public List<Match> getMatches() {
        return new ArrayList<>(matches);
    }
}