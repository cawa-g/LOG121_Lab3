/******************************************************
 Cours:  LOG121
 Projet: Laboratoire #3
 Nom du fichier: com.lab3.buncoplus.FabriqueBunco
 Date créé: 2015-03-05
 *******************************************************
 Historique des modifications
 2015-03-07 : Francis
 2015-03-12 : Alexandre
 *******************************************************/

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
     * @return Les joueurs créés
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
