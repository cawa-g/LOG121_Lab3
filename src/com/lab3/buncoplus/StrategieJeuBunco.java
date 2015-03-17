package com.lab3.buncoplus;

import com.lab3.diceframework.*;

public class StrategieJeuBunco implements StrategieJeu {

    @Override
    public void calculerScoreTour(Joueur joueur, int tour) {
        int score = 0;
        int occurenceDuTour = 0;

        boolean estBunco = false;

        do {
            Iterable<De>des = joueur.roulerDes();

            //todo : Arranger!
            occurenceDuTour = obtenirOccurencesDuTourDansDes(des,tour);
            De monDe = des.iterator().next();

            if (occurenceDuTour==3){
                score+=21;
                estBunco=true;
            }else if(occurenceDuTour<3){
                score+=occurenceDuTour;
            }else if (desTousEgaux(des)){
                score+=5;
            }else{
                estBunco=true;
            }


//            De de1 = des.iterator().next();
//
//            //todo : revoir le calcul avec les règles.
//            if(occurenceDuTour != 3){
//                score += occurenceDuTour;
//            } else if(de1.obtenirValeur() == tour) {
//                score += 21;
//                estBunco = true;
//            } else{
//                score += 5;
//            }

        } while(occurenceDuTour != 0 && !estBunco);

        //return score;
    }

    @Override
    public Joueur calculerLeVainqueur(Jeu jeu) {

        //todo : implémenter
        Joueurs joueurs = jeu.getJoueurs();

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
        boolean egaux = true;
        De tempo = des.iterator().next();
        for (De de:des){
            if (de.obtenirValeur()!=tempo.obtenirValeur()){
                egaux=false;
            }
        }

        return egaux;
    }
}
