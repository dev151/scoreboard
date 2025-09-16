# scoreboard

Live Football World Cup Score Board Java library

## Assumptions:

1. Library will work in multithreading environment, take care of concurrency

2. Point 4: _"Get a summary of games by total score. Those games with the same total score

will be returned ordered by the most recently added to our system."_ is understood the way, that matches are sorted twice:

&nbsp;	a) by the sum of scores (home team score + away team score) and then by

&nbsp;	b) the match creation date (established in "1. Start a game" routine)

&nbsp;	(BTW: Netflix uses this idea for film scoring)


## Future possible improvements ideas

- maintain already sorted structure ready for immediate usage - as a performance improvement (@IScoreBoard.getSummary()@)

