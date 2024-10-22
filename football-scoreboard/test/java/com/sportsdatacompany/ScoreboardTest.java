package com.sportsdatacompany;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ScoreboardTest {

    private Scoreboard scoreboard;

    @BeforeEach
    public void setUp() {
        scoreboard = new Scoreboard();
    }

    @Test
    public void testStartMatch() {
        Match match = scoreboard.startMatch("Home Team", "Away Team");
        assertEquals(1, scoreboard.getMatches().size());
        assertEquals("Home Team", match.getHomeTeam());
        assertEquals("Away Team", match.getAwayTeam());
    }

    @Test
    public void testUpdateScore() {
        Match match = scoreboard.startMatch("Home Team", "Away Team");
        scoreboard.updateScore(match, 2, 1);
        assertEquals(2, match.getHomeScore());
        assertEquals(1, match.getAwayScore());
    }

    @Test
    public void testFinishMatch() {
        Match match = scoreboard.startMatch("Home Team", "Away Team");
        scoreboard.finishMatch(match);
        assertTrue(scoreboard.getMatches().isEmpty());
    }

    @Test
    public void testGetSummary() {
        Match match1 = scoreboard.startMatch("Mexico", "Canada");
        Match match2 = scoreboard.startMatch("Spain", "Brazil");
        Match match3 = scoreboard.startMatch("Germany", "France");
        Match match4 = scoreboard.startMatch("Uruguay", "Italy");
        Match match5 = scoreboard.startMatch("Argentina", "Australia");

        scoreboard.updateScore(match1, 0, 5);
        scoreboard.updateScore(match2, 10, 2);
        scoreboard.updateScore(match3, 2, 2);
        scoreboard.updateScore(match4, 6, 6);
        scoreboard.updateScore(match5, 3, 1);

        List<Match> summary = scoreboard.getSummary();
        assertEquals(5, summary.size());
        assertEquals("Uruguay 6 - Italy 6", summary.get(0).toString());
        assertEquals("Spain 10 - Brazil 2", summary.get(1).toString());
        assertEquals("Mexico 0 - Canada 5", summary.get(2).toString());
        assertEquals("Argentina 3 - Australia 1", summary.get(3).toString());
        assertEquals("Germany 2 - France 2", summary.get(4).toString());
    }
}