package com.lab3.diceframework;

/**
 * Created by francistoupin on 15-02-26.
 */
public abstract class GameFactory {

    /*
     * todo : cette classe là est abbérante, sorry. Je vois mal comment implémenter le template, ça semble useless.
      * On checkera ça.
     */
    private int numberOfRounds;
    private int numberOfPlayers;
    private ScoreCalculatorStrategy scoreCalculatorStrategy;

    protected GameFactory(int numberOfRounds, int numberOfPlayers, ScoreCalculatorStrategy scoreCalculatorStrategy){

        this.numberOfRounds = numberOfRounds;
        this.numberOfPlayers = numberOfPlayers;
        this.scoreCalculatorStrategy = scoreCalculatorStrategy;
    }

    protected abstract Dices createDicesForPlayer();
    protected abstract Player createPlayer(Dices dices);

    /**
     * VOMIS! (Non ok, faut changer ça) (C'est peut-être un peu mieux maintenant..)
     * @return
     */
    public Game create(){
        Players players = new Players();

        for (int index = 0; index < numberOfPlayers; index++) {
            Dices playersDices = createDicesForPlayer();
            players.add(createPlayer(playersDices));
        }

        return new Game(players,numberOfRounds,scoreCalculatorStrategy);
    }
}
