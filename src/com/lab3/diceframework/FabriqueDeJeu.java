/******************************************************
 Cours:  LOG121
 Projet: Laboratoire #3
 Nom du fichier: com.lab3.diceframework.FabriqueDeJeu
 Date créé: 2015-03-05
 *******************************************************
 Historique des modifications
 2015-03-05 : Francis
 2015-03-09 : Alexandre
 *******************************************************/

package com.lab3.diceframework;

public abstract class FabriqueDeJeu {

    protected FabriqueDeJeu(){
    }

    public Jeu creer(int nombreDeTours, int nombreDeJoueurs, StrategieJeu strategieJeu){
        Joueurs j = creerJoueurs(nombreDeJoueurs);
        return new Jeu(j, nombreDeTours, strategieJeu);
    }

    protected abstract Des creerDes();
    protected abstract Joueurs creerJoueurs(int nombreDeJoueurs);
}
