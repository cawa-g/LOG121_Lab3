package com.lab3.diceframework;

/**
 * Calcul un score en points en fonction de dés et du tour actuel
 */
public interface StrategieJeu {

    /**
     * Calcul un score en points en fonction de dés et du tour actuel
     * @param jeu Le joueur du tour
     * @return Le score en points.
     */
    int calculerScoreTour(Jeu jeu);

    Joueur calculerLeVainqueur(Jeu jeu);
}