package com.lab3;

import java.util.Collection;

/**
 * Created by francistoupin on 15-02-25.
 */
public class Player implements Comparable<Player> {

    private Dice[] dices;
    private int round;
    private int score;

    public Player(Dice[] dices){
        this.dices = dices;
        round = 0;
    }

    @Override
    public int compareTo(Player o) {
        return 0;
    }

    public void play(ScoreCalculatorStrategy scoreCalculatorStrategy){
        for(Dice dice : dices){
            dice.roll();
        }

        score += scoreCalculatorStrategy.calculateScore(dices,1);
        round++;
    }

    public int getScore(){
        return this.score;
    }

    public int getRound(){
        return this.round;
    }
}
