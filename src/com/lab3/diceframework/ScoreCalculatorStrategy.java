package com.lab3.diceframework;

/**
 * Calcul un score en points en fonction de dés et du tour actuel
 */
public interface ScoreCalculatorStrategy {

    /**
     * Calcul un score en points en fonction de dés et du tour actuel
     * @param player Le joueur du tour
     * @param round Le tour pour lequel on veut calculer le score
     * @return Le score en points.
     */
    int calculateScore(Player player, int round);
}