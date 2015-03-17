package com.lab3.buncoplus;

import com.lab3.diceframework.*;

/**
 * Crée une instance de jeu de Bunco
 */
public class FabriqueBunco extends FabriqueDeJeu {

    private static final int NOMBRE_DE_DES = 3;
    private static final int NOMBRE_DE_FACES = 6;

    /**
     * Initialise une instance de FabriqueBunco
     */
    public FabriqueBunco() {
        super();
    }

    /**
     * Crée les dés pour les joueurs
     * @return Les dés d'un joueur
     */
    @Override
    protected Des creerDes() {
        Des des = new Des();

        for (int index = 0; index < NOMBRE_DE_DES; index++) {
            des.ajouter(new De(NOMBRE_DE_FACES));
        }

        return des;
    }


    /**
     * Crée les joueurs du jeu
     * @param nombreDeJoueurs Nombre de joueurs à créer
     * @return
     */
    @Override
    protected Joueurs creerJoueurs(int nombreDeJoueurs) {
        Joueurs joueurs = new Joueurs();

        for (int index = 0; index < nombreDeJoueurs; index++) {
            Des des = creerDes();
            joueurs.ajouter(new Joueur(des));
        }
        return joueurs;
    }
}
