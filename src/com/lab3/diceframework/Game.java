package com.lab3.diceframework;

import java.util.Iterator;

/**
 * Created by francistoupin on 15-02-25.
 */
public class Game {
    private final Players players;
    private final int numberOfRounds;
    private final ScoreCalculatorStrategy scoreCalculatorStrategy;

    private int currentRound;

    Game(Players players, int numberOfRounds, ScoreCalculatorStrategy scoreCalculatorStrategy){
        this.players = players;
        this.numberOfRounds = numberOfRounds;
        this.scoreCalculatorStrategy = scoreCalculatorStrategy;

        currentRound = 0;
    }

    /**
     * Faire un tour dans le jeu. Chaque joueur va brasser les dés et additionner le résultat à son score total.
     */
    public void playRound(){
        if(isGameOver()){
            throw new IllegalStateException("La partie est terminée");
        }

        for(Player player : players){
            Iterator<Dice> iteratorDice = player.rollDices();
            int roundScore = scoreCalculatorStrategy.calculateScore(iteratorDice,currentRound);

            player.incrementScore(roundScore);
        }
        currentRound++;
    }

    /**
     *
     * @return true si la ronde finale a été jouée
     */
    public boolean isGameOver(){
        return currentRound > numberOfRounds;
    }

    /**
     *
     * @return Le joueur ayant le plus haut score à la ronde actuelle.
     */
    public Player getBestPlayer(){
        Player bestPlayer = null;
        for(Player player : players) {
            if(bestPlayer != null && player.getScore() > bestPlayer.getScore()){
                bestPlayer = player;
            }
        }

        return bestPlayer;
    }
}
