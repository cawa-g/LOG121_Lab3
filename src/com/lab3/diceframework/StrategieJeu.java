package com.lab3.diceframework;

/**
 * Calcul un score en points en fonction de dés et du tour actuel
 */
public interface StrategieJeu {

    /**
     * Calcul un score en points en fonction de dés et du tour actuel
     * @param jeu Le jeu pour lequel il faut calculer le score d'un tour pour tout les joueurs
     */
    void calculerScoreTour(Jeu jeu);
    Joueur calculerLeVainqueur(Jeu jeu);
}