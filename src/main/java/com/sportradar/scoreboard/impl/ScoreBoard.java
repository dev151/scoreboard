package com.sportradar.scoreboard.impl;

import java.util.*;
import java.util.stream.Collectors;

import com.sportradar.scoreboard.interfaces.IGame;
import com.sportradar.scoreboard.interfaces.IScoreBoard;
import com.sportradar.scoreboard.model.Game;

public class ScoreBoard implements IScoreBoard {

    private final Map<String, IGame> scoreBoard;
    public ScoreBoard() {
        scoreBoard = new HashMap<>();
    }

    @Override
    public IGame startGame(String homeTeamName, String awayTeamName) {
        var key = Game.getUniqueKey(homeTeamName, awayTeamName);
        synchronized(scoreBoard) {
            if(scoreBoard.containsKey(key)) {
                // game already started, make sure it maintains the initial 0-0 result
                var game = scoreBoard.get(key);
                game.setScore(0, 0);
                return game;
            }

            // create new game with initial scores
            var game = new Game(homeTeamName, awayTeamName);
            scoreBoard.put(key, game);
            return game;
        }
    }

    @Override
    public void finishGame(IGame game) {
        var key = Game.getUniqueKey(game.getHomeTeamName(), game.getAwayTeamName());
        synchronized(scoreBoard) {
            if(scoreBoard.containsKey(key)) {
                scoreBoard.remove(key);
            }
        }
    }

    @Override
    public void updateScore(IGame game, int homeTeamScore, int awayTeamScore) {
        game.setScore(homeTeamScore, awayTeamScore);
    }

    @Override
    public List<IGame> getSummary() {
        synchronized(scoreBoard) {
            return scoreBoard.values().stream().sorted(
                Comparator
                    .comparingInt((IGame g) -> g.getHomeScore() + g.getAwayScore())
                    .thenComparing(IGame::getStartDateTime)
                    .reversed()
            )
            .collect(Collectors.toList());
        }
    }
}