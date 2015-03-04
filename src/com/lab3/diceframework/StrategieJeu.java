package com.lab3.diceframework;

/**
 * Calcul un score en points en fonction de dés et du tour actuel
 */
public interface StrategieJeu {

    /**
     * Calcul un score en points en fonction de dés et du tour actuel
     * @param joueur Le joueur du tour
     * @param round Le tour pour lequel on veut calculer le score
     * @return Le score en points.
     */
    int calculerScoreTour(Joueur joueur, int round);
}