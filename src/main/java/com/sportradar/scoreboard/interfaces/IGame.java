package com.sportradar.scoreboard.interfaces;

import java.time.LocalDateTime;

public interface IGame {
    public String getHomeTeamName();

    public int getHomeScore();

    public String getAwayTeamName();

    public int getAwayScore();

    public void setHomeScore(int homeScore);

    public void setAwayScore(int awayScore);

    public LocalDateTime getStartDateTime();
}
