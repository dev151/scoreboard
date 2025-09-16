package com.sportradar.scoreboard.model;

import com.sportradar.scoreboard.interfaces.IGame;

import java.time.LocalDateTime;
import java.util.Objects;

public class Game implements IGame {
    private final String homeTeamName;
    private final String awayTeamName;
    private final LocalDateTime startDateTime;
    private int homeScore;
    private int awayScore;

    public Game(String homeTeamName, String awayTeamName, int homeScore, int awayScore) {
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this. startDateTime = LocalDateTime.now();
    }

    // getters / interface
    @Override
    public String getHomeTeamName() {
        return homeTeamName;
    }

    @Override
    public int getHomeScore() {
        return homeScore;
    }

    @Override
    public String getAwayTeamName() {
        return awayTeamName;
    }

    @Override
    public int getAwayScore() {
        return awayScore;
    }

    @Override
    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    // setters
    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Game)) {
            return false;
        }
        Game game = (Game) o;
        return homeScore == game.homeScore && awayScore == game.awayScore
                && Objects.equals(homeTeamName, game.homeTeamName) && Objects.equals(awayTeamName, game.awayTeamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeamName, awayTeamName);
    }

    @Override
    public String toString() {
        return "Game{" +
                "homeTeamName='" + homeTeamName + '\'' +
                ", awayTeamName='" + awayTeamName + '\'' +
                ", homeScore=" + homeScore +
                ", awayScore=" + awayScore +
                '}';
    }

    public static String getUniqueKey(String homeTeamName, String awayTeamName) {
        return "%s#%s".formatted(homeTeamName, awayTeamName);
    }
}
