package com.lab3.buncoplus;

import com.lab3.diceframework.De;
import com.lab3.diceframework.Joueur;
import com.lab3.diceframework.StrategieJeu;

/**
 * Created by francistoupin on 15-03-02.
 */
public class StrategieJeuBunco implements StrategieJeu {

    @Override
    public int calculerScoreTour(Joueur joueur, final int tour) {
        int score = 0;
        int occurenceDuTour = 0;

        boolean estBunco = false;

        do {
            Iterable<De> des = joueur.roulerDes();

            occurenceDuTour = obtenirOccurencesDuTourDansDes(des, tour);
            De de1 = des.iterator().next();

            //todo : revoir le calcul avec les règles.
            if(occurenceDuTour != 3){
                score += occurenceDuTour;
            } else if(de1.obtenirValeur() == tour) {
                score += 21;
                estBunco = true;
            } else{
                score += 5;
            }

        } while(occurenceDuTour != 0 && !estBunco);

        return score;
    }

    private int obtenirOccurencesDuTourDansDes(Iterable<De> des, int tour){
        int occurenceDuTour = 0;
        for (De de : des){
            if(de.equals(tour)){
                occurenceDuTour++;
            }
        }

        return occurenceDuTour;
    }
}
