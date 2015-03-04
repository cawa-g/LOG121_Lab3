package com.lab3.diceframework;

public class Jeu {
    private final Joueurs joueurs;
    private final int nombreDeTours;
    private final StrategieJeu strategieJeu;

    private int tourActuel;

    Jeu(Joueurs joueurs, int nombreDeTours, StrategieJeu strategieJeu){
        this.joueurs = joueurs;
        this.nombreDeTours = nombreDeTours;
        this.strategieJeu = strategieJeu;

        tourActuel = 0;
    }

    /**
     * Faire un tour dans le jeu. Chaque joueur va brasser les dés et additionner le résultat à son score total.
     */
    public void jouerUnTour(){
        if(estTermine()){
            throw new IllegalStateException("La partie est terminée");
        }

        for(Joueur joueur : joueurs){
            //todo : wut. voir plus bas?
            //strategieJeu.calculerScoreTour(joueur);
        }
        tourActuel++;
    }

    public void calculerScoreTour() {
        strategieJeu.calculerScoreTour(this);
    }

    public void calculerLeVainqueur(){
        strategieJeu.calculerLeVainqueur(this);
    }

    /**
     *
     * @return true si la ronde finale a été jouée
     */
    public boolean estTermine(){
        return tourActuel > nombreDeTours;
    }

    /**
     *
     * @return Le joueur ayant le plus haut score à la ronde actuelle.
     */
    public Joueur obtenirMeilleurJoueur(){
        Joueur meilleurJoueur = null;

        for(Joueur joueur : joueurs) {
            if (meilleurJoueur == null || joueur.obtenirScore() > meilleurJoueur.obtenirScore()){
                meilleurJoueur = joueur;
            }
        }

        return meilleurJoueur;
    }
}
