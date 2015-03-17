/******************************************************
 Cours:  LOG121
 Projet: Laboratoire #3
 Nom du fichier: com.lab3.buncoplus.StrategieJeuBunco
 Date créé: 2015-03-05
 *******************************************************
 Historique des modifications
 2015-03-07 : Francis
 2015-03-12 : Kelvin
 *******************************************************/

package com.lab3.buncoplus;

import com.lab3.diceframework.*;

/**
 * Implémente la stratégie de jeu du BuncoPlus
 */
public class StrategieJeuBunco implements StrategieJeu {

    /**
     * Calculer le score pour chaque joueur pour un tour
     * @param jeu L'instance de jeu pour laquel on calcule le score
     */
    @Override
    public void calculerScoreTour(Jeu jeu) {
        if(jeu == null){
            throw new IllegalArgumentException("Le jeu est null");
        }

        int score = 0;
        int occurenceDuTour;
        boolean doitPasserMain = false;

        for(Joueur joueur : jeu.obtenirJoueurs()) {

            do {
                Iterable<De> des = joueur.roulerDes();

                occurenceDuTour = obtenirOccurencesDuTourDansDes(des, jeu.obtenirTour());

                if (occurenceDuTour == 3) {
                    score += 21;
                    doitPasserMain = true;
                } else if (desTousEgaux(des)) {
                    score += 5;
                } else if (occurenceDuTour < 3 && occurenceDuTour > 0) {
                    score += occurenceDuTour;
                } else {
                    doitPasserMain = true;
                }
            } while (!doitPasserMain);

            joueur.incrementerScore(score);
        }

    }

    /**
     * Trouve le vainqueur de la partie
     * @param jeu Le jeu pour lequel on doit voir le vainqueur
     * @return Le joueur qui a gagné la partie
     */
    @Override
    public Joueur calculerLeVainqueur(Jeu jeu) {
        if(jeu == null){
            throw new IllegalArgumentException("Le jeu est null");
        }

        Iterable<Joueur> joueurs = jeu.obtenirJoueurs();

        Joueur meilleurJoueur = joueurs.iterator().next();

        for (Joueur joueur:joueurs){
            if (meilleurJoueur.obtenirScore()<joueur.obtenirScore()){
                meilleurJoueur=joueur;
            }
        }

        return meilleurJoueur;
    }

    /**
     * Obtient le nombre de fois que le numéro du tour correspond à une des faces des dés roulés.
     * @param des Les dés roulés
     * @param tour Le numéro du tour pour le calcul
     * @return Le nombre d'occurences du tour
     */
    private int obtenirOccurencesDuTourDansDes(Iterable<De> des, int tour){
        int occurenceDuTour = 0;
        for (De de : des){
            if(de.obtenirValeur() == tour){
                occurenceDuTour++;
            }
        }

        return occurenceDuTour;
    }

    /**
     * Détermine si tout les dés sont à la même face
     * @param des Dés à vérifier
     * @return true si tout les dés ont la même valeur
     */
    private boolean desTousEgaux(Iterable<De> des){

        De deDeComparaison = des.iterator().next();
        for (De de:des){
            if (!de.obtenirValeur().equals(deDeComparaison.obtenirValeur())){
                return false;
            }
        }

        return true;
    }
}
