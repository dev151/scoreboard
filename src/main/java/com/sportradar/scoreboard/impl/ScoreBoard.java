package com.sportradar.scoreboard.impl;

import java.util.*;

import com.sportradar.scoreboard.interfaces.IGame;
import com.sportradar.scoreboard.interfaces.IScoreBoard;

public class ScoreBoard implements IScoreBoard {
    @Override
    public IGame startGame(String homeTeamName, String awayTeamName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'startGame'");
    }

    @Override
    public void finishGame(IGame game) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finishGame'");
    }

    @Override
    public void updateScore(IGame game, int homeTeamScore, int awayTeamScore) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateScore'");
    }

    @Override
    public List<IGame> getSummary() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSummary'");
    }
}