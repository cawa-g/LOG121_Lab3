package com.lab3.buncoplus;

import com.lab3.diceframework.*;

public class StrategieJeuBunco implements StrategieJeu {

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

    private int obtenirOccurencesDuTourDansDes(Iterable<De> des, int tour){
        int occurenceDuTour = 0;
        for (De de : des){
            if(de.obtenirValeur() == tour){
                occurenceDuTour++;
            }
        }

        return occurenceDuTour;
    }

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
