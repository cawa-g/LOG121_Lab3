package com.lab3.buncoplus;

import com.lab3.diceframework.*;

/**
 * Crée une instance de jeu de Bunco
 */
public class FabriqueBunco extends FabriqueDeJeu {

    private static final int NOMBRE_DE_DES = 6;

    public FabriqueBunco() {
        super();
    }

    @Override
    protected Des creerDes() {
        Des des = new Des();

        for (int index = 0; index < 3; index++) {
            des.ajouter(new De(6));
        }

        return des;
    }

    @Override
    protected Joueurs creerJoueurs(int nombreDeJoueurs) {
        Joueurs j = new Joueurs();

        for (int index = 0; index < nombreDeJoueurs; index++) {
            Des d = creerDes();
            j.ajouter(new Joueur(d));
        }
        return null;
    }
}
