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
    private ScoreCalculatorStrategy scoreCalculatorStrategy;

    protected GameFactory(int numberOfRounds, ScoreCalculatorStrategy scoreCalculatorStrategy){

        this.numberOfRounds = numberOfRounds;
        this.scoreCalculatorStrategy = scoreCalculatorStrategy;
    }

    protected abstract Players createPlayers();

    /**
     * VOMIS! (Non ok, faut changer ça)
     * @return
     */
    public Game create(){
        Players players = createPlayers();


        return new Game(players,numberOfRounds,scoreCalculatorStrategy);
    }
}
