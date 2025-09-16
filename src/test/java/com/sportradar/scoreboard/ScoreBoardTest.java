package com.sportradar.scoreboard;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sportradar.scoreboard.impl.ScoreBoard;
import com.sportradar.scoreboard.interfaces.IGame;

public class ScoreBoardTest {
    private ScoreBoard sb;

    @BeforeEach
    protected void beforeEachTest() {
        sb = new ScoreBoard();
    }

    @Test
    public void startGameTest() {
        var homeTeamName = "Poland";
        var awayTeamName = "Germany";

        var game = sb.startGame(homeTeamName, awayTeamName);
        verifyNewMatch(game, homeTeamName, awayTeamName);

        var summary = sb.getSummary();
        assertNotNull(summary);
        assertEquals(summary.size(), 1);
        var theOnlyGame = summary.get(0);
        verifyNewMatch(theOnlyGame, homeTeamName, awayTeamName);
    }

    private void verifyNewMatch(IGame game, String homeTeamName, String awayTeamName) {
        assertNotNull(game);
        assertEquals(game.getHomeTeamName(), "Poland");
        assertEquals(game.getAwayTeamName(), "Germany");
        assertEquals(game.getHomeScore(), 0);
        assertEquals(game.getAwayScore(), 0);
    }

    @Test
    public void doubleStartGameTest() {
        var homeTeamName = "Poland";
        var awayTeamName = "Germany";

        var game1 = sb.startGame(homeTeamName, awayTeamName);
        var game2 = sb.startGame(homeTeamName, awayTeamName);
        assertEquals(game1, game2);
        verifyNewMatch(game1, homeTeamName, awayTeamName);
        verifyNewMatch(game2, homeTeamName, awayTeamName);

        var summary = sb.getSummary();
        assertNotNull(summary);
        assertEquals(summary.size(), 1);
        var theOnlyGame = summary.get(0);
        verifyNewMatch(theOnlyGame, homeTeamName, awayTeamName);
    }

    // TODO other tests here
}
