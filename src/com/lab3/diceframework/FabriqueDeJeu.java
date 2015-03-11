package com.lab3.diceframework;

public abstract class FabriqueDeJeu {

    protected FabriqueDeJeu(){
    }

    public Jeu creer(int nombreDeTours, int nombreDeJoueurs, StrategieJeu strategieJeu){
        Joueurs j = creerJoueurs(nombreDeJoueurs);
        creerDes();
        return new Jeu(j, nombreDeTours, strategieJeu);
    }

    protected abstract Des creerDes();
    protected abstract Joueurs creerJoueurs(int nombreDeJoueurs);
}
