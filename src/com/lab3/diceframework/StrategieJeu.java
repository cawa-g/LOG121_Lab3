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

    /**
     * Trouve le joueur vainqueur de la partie
     * @param jeu Le jeu
     * @return Le vainqueur
     */
    Joueur calculerLeVainqueur(Jeu jeu);
}