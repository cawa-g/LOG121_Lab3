package com.lab3.diceframework;

import java.util.Iterator;

/**
 * Calcul un score en points en fonction de dés et du tour actuel
 */
public interface ScoreCalculatorStrategy {

    /**
     * Calcul un score en points en fonction de dés et du tour actuel
     * @param dices Dés joués
     * @param round Le tour pour lequel on veut calculer le score
     * @return Le score en points.
     */
    int calculateScore(Iterator<Dice> dices, int round);
}