package com.lab3;

/**
 * Created by francistoupin on 15-02-25.
 */
public interface ScoreCalculatorStrategy {
    int calculateScore(Dice[] dices, int round);
}