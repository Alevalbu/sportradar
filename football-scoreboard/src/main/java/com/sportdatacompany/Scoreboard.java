package com.sportsdatacompany;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        findMatch(homeTeam, awayTeam).ifPresent(match -> match.updateScore(homeScore, awayScore));
    }

    public void finishMatch(String homeTeam, String awayTeam) {
        findMatch(homeTeam, awayTeam).ifPresent(matches::remove);
    }

    public List<Match> getSummary() {
        return matches.stream()
            .sorted(Comparator.comparing(Match::getTotalScore)).reversed()
                .thenComparing(Match::getStartTime).reversed()
            .toList();
    }

    private Optional<Match> findMatch(String homeTeam, String awayTeam) {
        return matches.stream()
                .filter(m -> m.getHomeTeam().equals(homeTeam) && m.getAwayTeam().equals(awayTeam))
                .findFirst();
    }
}
