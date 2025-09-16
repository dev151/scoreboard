package com.sportradar.scoreboard.interfaces;

import java.util.List;

public interface IScoreBoard {
    // 1. Start a game. When a game starts, it should capture (being initial score 0-0)
    public IGame startGame(String homeTeamName, String awayTeamName);

    // 2. Finish a game. It will remove a match from the scoreboard.
    public void finishGame(IGame game);

    // 3. Update score. Receiving the pair score; home team score and away team
    // score updates a game score
    public void updateScore(IGame game, int homeTeamScore, int awayTeamScore);

    // 4. Get a summary of games by total score. Those games with the same total
    // score will be returned ordered by the most recently added to our system.
    public List<IGame> getSummary();
}