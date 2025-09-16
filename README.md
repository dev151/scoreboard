# scoreboard

Live Football World Cup Score Board Java library

## Assumptions:

1. Library will work in multithreading environment, take care of concurrency

2. Point 4: _"Get a summary of games by total score. Those games with the same total score

will be returned ordered by the most recently added to our system."_ is understood the way, that matches are sorted twice:

&nbsp;	a) by the sum of scores (home team score + away team score) and then by

&nbsp;	b) the match creation date (established in "1. Start a game" routine)

&nbsp;	(BTW: Netflix uses this idea for film scoring)

3. Point 3: _"Update score. Receiving the pair score; home team score and away team score updates a game score"_ - to update the score also game should be identified either by home/away team names or by the @IGame@ object itself (this approach is implemented).
There is no extralogic to detect score gaps or score beeing changed in the other direction (decreased).

4. Point 2: _"Finish a game. It will remove a match from the scoreboard."_ It is implemented the way that call for this function can be performed multiple time, each subsequnt call does not change the scoreBoard state but also doesn't throw any exception.

5. Point 1: "Start a game." It can start the same game multiple times. Each subsequent time ensures that there is initial 0-0 result.

## Future possible improvements ideas

- maintain already sorted structure ready for immediate usage - as a performance improvement (@IScoreBoard.getSummary()@)
- verify if additional check might be needed to prevent mixing home and away team order (this can lead to the situation when given game will be represented in summary twice as "Home Team - Away Team" and "Away Team - Home Team" entries).
Potentially possible when multiple Scouts are reporting Game status.
- verify the requirement: "game score can only grow"
