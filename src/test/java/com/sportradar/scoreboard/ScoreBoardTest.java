package com.sportradar.scoreboard;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sportradar.scoreboard.impl.ScoreBoard;
import com.sportradar.scoreboard.interfaces.IGame;
import com.sportradar.scoreboard.model.Game;

public class ScoreBoardTest {
    private ScoreBoard scoreBoard;
    private final String homeTeamName = "Poland";
    private final String awayTeamName = "Germany";

    @BeforeEach
    protected void beforeEachTest() {
        scoreBoard = new ScoreBoard();
    }

    @Test
    public void startGameTest() {
        var game = scoreBoard.startGame(homeTeamName, awayTeamName);
        verifyNewGame(game, homeTeamName, awayTeamName);
    }

    private void verifyNewGame(IGame game, String homeTeamName, String awayTeamName) {
        assertNotNull(game);
        assertEquals(game.getHomeTeamName(), homeTeamName);
        assertEquals(game.getAwayTeamName(), awayTeamName);
        assertEquals(game.getHomeScore(), 0);
        assertEquals(game.getAwayScore(), 0);
    }

    @Test
    public void doubleStartGameTest() {
        var game1 = scoreBoard.startGame(homeTeamName, awayTeamName);
        var game2 = scoreBoard.startGame(homeTeamName, awayTeamName);
        assertEquals(game1, game2);
        verifyNewGame(game1, homeTeamName, awayTeamName);
        verifyNewGame(game2, homeTeamName, awayTeamName);

        var summary = scoreBoard.getSummary();
        assertNotNull(summary);
        assertEquals(summary.size(), 1);
        var theOnlyGame = summary.get(0);
        verifyNewGame(theOnlyGame, homeTeamName, awayTeamName);
    }

    @Test
    void finishGameTest() {
        var game = scoreBoard.startGame(homeTeamName, awayTeamName);
        scoreBoard.updateScore(game, 1, 0);
        var summary = scoreBoard.getSummary();
        assertEquals(summary.size(), 1);

        scoreBoard.finishGame(game);
        summary = scoreBoard.getSummary();
        assertEquals(summary.size(), 0);
    }

    @Test
    void getSummarySingleGameTest() {
        scoreBoard.startGame(homeTeamName, awayTeamName);
        var summary = scoreBoard.getSummary();
        assertNotNull(summary);
        assertEquals(summary.size(), 1);
        var theOnlyGame = summary.get(0);
        verifyNewGame(theOnlyGame, homeTeamName, awayTeamName);
    }

    @Test
    void getSummaryEmptyGameTest() {
        var summary = scoreBoard.getSummary();
        assertNotNull(summary);
        assertEquals(summary.size(), 0);
    }

    @Test
    void testUpdateScore() {
        var maxScore = 7;
        var game = scoreBoard.startGame(homeTeamName, awayTeamName);
        for (int score = 1; score <= maxScore; score++) {
            scoreBoard.updateScore(game, score, 0);
        }

        assertEquals(game.getHomeScore(), maxScore);
        assertEquals(game.getAwayScore(), 0);

        for (int score = 1; score <= maxScore; score++) {
            scoreBoard.updateScore(game, maxScore, score);
        }

        assertEquals(game.getHomeScore(), maxScore);
        assertEquals(game.getAwayScore(), maxScore);

        var summary = scoreBoard.getSummary();
        assertNotNull(summary);
        assertEquals(summary.size(), 1);
        var theOnlyGame = summary.get(0);
        assertEquals(theOnlyGame.getHomeScore(), maxScore);
        assertEquals(theOnlyGame.getAwayScore(), maxScore);
    }

    
    @Test
    void getSummaryMultipleGameTest() {
        List<IGame> inputGames = List.of(
                new Game("Mexico", "Canada", 0, 5),
                new Game("Spain", "Brazil", 10, 2),
                new Game("Germany", "France", 2, 2),
                new Game("Uruguay", "Italy", 6, 6),
                new Game("Argentina", "Australia", 3, 1));

        List<IGame> expectedSummary = List.of(
                new Game("Uruguay", "Italy", 6, 6),
                new Game("Spain", "Brazil", 10, 2),
                new Game("Mexico", "Canada", 0, 5),
                new Game("Argentina", "Australia", 3, 1),
                new Game("Germany", "France", 2, 2));

        for (IGame input : inputGames) {
            var game = scoreBoard.startGame(input.getHomeTeamName(), input.getAwayTeamName());
            scoreBoard.updateScore(game, input.getHomeScore(), input.getAwayScore());
        }

        var summary = scoreBoard.getSummary();
        assertEquals(summary.size(), expectedSummary.size());

        var cnt = 0;
        for(IGame expectedGame : expectedSummary) {
            var summaryGame = summary.get(cnt);
            assertTrue(expectedGame.equals(summaryGame),  "Comparing game from score table on position %d.".formatted(cnt));
            cnt++;
        }

    }
}
