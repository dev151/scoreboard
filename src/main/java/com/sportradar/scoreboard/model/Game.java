package com.sportradar.scoreboard.model;

import com.sportradar.scoreboard.interfaces.IGame;

public class Game implements IGame {

    public Game(String homeTeamName, String awayTeamName, int homeScore, int awayScore) {
        //TODO Auto-generated constructor stub
    }

    @Override
    public String getHomeTeamName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHomeTeamName'");
    }

    @Override
    public int getHomeScore() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHomeScore'");
    }

    @Override
    public String getAwayTeamName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAwayTeamName'");
    }

    @Override
    public int getAwayScore() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAwayScore'");
    }

}
