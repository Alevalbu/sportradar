package com.sportsdatacompany;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ScoreboardServiceTest {

    private ScoreboardService service;

    @BeforeEach
    public void setUp() {
        service = new ScoreboardService();
    }

    @Test
    public void testStartMatch() {
        Match match = service.startMatch("Home Team", "Away Team");
        assertNotNull(match);
        assertEquals("Home Team", match.getHomeTeam());
        assertEquals("Away Team", match.getAwayTeam());
    }

    @Test
    public void testUpdateScore() {
        Match match = service.startMatch("Home Team", "Away Team");
        service.updateScore(match, 2, 1);
        assertEquals(2, match.getHomeScore());
        assertEquals(1, match.getAwayScore());
    }

    @Test
    public void testFinishMatch() {
        Match match = service.startMatch("Home Team", "Away Team");
        service.finishMatch(match);
        assertTrue(service.getSummary().isEmpty());
    }

    @Test
    public void testGetSummary() {
        Match match1 = service.startMatch("Mexico", "Canada");
        Match match2 = service.startMatch("Spain", "Brazil");
        Match match3 = service.startMatch("Germany", "France");
        Match match4 = service.startMatch("Uruguay", "Italy");
        Match match5 = service.startMatch("Argentina", "Australia");

        service.updateScore(match1, 0, 5);
        service.updateScore(match2, 10, 2);
        service.updateScore(match3, 2, 2);
        service.updateScore(match4, 6, 6);
        service.updateScore(match5, 3, 1);

        List<Match> summary = service.getSummary();
        assertEquals(5, summary.size());
        assertEquals("Uruguay 6 - Italy 6", summary.get(0).toString());
        assertEquals("Spain 10 - Brazil 2", summary.get(1).toString());
        assertEquals("Mexico 0 - Canada 5", summary.get(2).toString());
        assertEquals("Argentina 3 - Australia 1", summary.get(3).toString());
        assertEquals("Germany 2 - France 2", summary.get(4).toString());
    }
}