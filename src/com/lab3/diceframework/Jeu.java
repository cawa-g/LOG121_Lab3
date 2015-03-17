package com.lab3.diceframework;

import sun.plugin.dom.exception.InvalidStateException;

public class Jeu {
    private final Joueurs joueurs;
    private final int nombreDeTours;
    private final StrategieJeu strategieJeu;

    private int tourActuel;

    Jeu(Joueurs joueurs, int nombreDeTours, StrategieJeu strategieJeu){
        this.joueurs = joueurs;
        this.nombreDeTours = nombreDeTours;
        this.strategieJeu = strategieJeu;

        tourActuel = 1;
    }

    public Iterable<Joueur> obtenirJoueurs(){
        return joueurs;
    }

    public int obtenirTour(){
        return tourActuel;
    }

    public void calculerScoreTour() {
        if(estTermine()){
            throw new InvalidStateException("La partie est terminée");
        }

        strategieJeu.calculerScoreTour(this);
        tourActuel++;
    }

    public Joueur calculerLeVainqueur(){
        return strategieJeu.calculerLeVainqueur(this);
    }

    /**
     *
     * @return true si la ronde finale a été jouée
     */
    public boolean estTermine(){
        return tourActuel > nombreDeTours;
    }
}
