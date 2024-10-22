package com.sportsdatacompany;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatchTest {

    @Test
    public void testMatchCreation() {
        Match match = new Match("Home Team", "Away Team");
        assertEquals("Home Team", match.getHomeTeam());
        assertEquals("Away Team", match.getAwayTeam());
        assertEquals(0, match.getHomeScore());
        assertEquals(0, match.getAwayScore());
        assertNotNull(match.getStartTime());
    }

    @Test
    public void testUpdateScore() {
        Match match = new Match("Home Team", "Away Team");
        match.updateScore(2, 1);
        assertEquals(2, match.getHomeScore());
        assertEquals(1, match.getAwayScore());
        assertEquals(3, match.getTotalScore());
    }

    @Test
    public void testToString() {
        Match match = new Match("Home Team", "Away Team");
        match.updateScore(2, 1);
        assertEquals("Home Team 2 - Away Team 1", match.toString());
    }
}