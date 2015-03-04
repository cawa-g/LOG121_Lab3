package com.lab3.buncoplus;

import com.lab3.diceframework.De;
import com.lab3.diceframework.Des;
import com.lab3.diceframework.FabriqueDeJeu;
import com.lab3.diceframework.Joueur;

/**
 * Crée une instance de jeu de Bunco
 */
public class FabriqueBunco extends FabriqueDeJeu {

    public FabriqueBunco(int nombreDeJoueurs) {
        super(6, nombreDeJoueurs, new StrategieJeuBunco());
    }

    /**
     * Crée les dés pour un joueur
     * @return Les dés d'un joueur
     */
    @Override
    protected Des creerDesPourJoueurs() {
        Des des = new Des();

        for (int index = 0; index < 3; index++) {
            des.ajouter(new De(6));
        }

        return des;
    }

    /**
     * Crée un joueur
     * @param des Les dés du joueur
     * @return Un nouveau joueur
     */
    @Override
    protected Joueur creerJoueur(Des des) {
        return new Joueur(des);
    }
}
