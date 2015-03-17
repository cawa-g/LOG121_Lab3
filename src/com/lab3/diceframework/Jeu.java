/******************************************************
 Cours:  LOG121
 Projet: Laboratoire #3
 Nom du fichier: com.lab3.diceframework
 Date créé: 2015-03-05
 *******************************************************
 Historique des modifications
 2015-03-05 :
 *******************************************************/


package com.lab3.diceframework;

/**
 * Jeu de dés
 */
public class Jeu {
    private final Joueurs joueurs;
    private final int nombreDeTours;
    private final StrategieJeu strategieJeu;

    private int tourActuel;

    /**
     * Initialise une instance de Jeu
     * @param joueurs Joueurs du jeu
     * @param nombreDeTours Nombre de tours du jeu
     * @param strategieJeu Stratégie utilisée pour calculer les points par tour et le vainqueur
     */
    Jeu(Joueurs joueurs, int nombreDeTours, StrategieJeu strategieJeu){

        this.joueurs = joueurs;
        this.nombreDeTours = nombreDeTours;
        this.strategieJeu = strategieJeu;

        tourActuel = 1;
    }

    /**
     *
     * @return Les joueurs du jeu
     */
    public Iterable<Joueur> obtenirJoueurs(){
        return joueurs;
    }

    /**
     *
     * @return Le tour actuel
     */
    public int obtenirTour(){
        return tourActuel;
    }

    /**
     * Avance d'un tour et calcul le score de chaque joueur
     */
    public void calculerScoreTour() {
        if(estTermine()){
            throw new IllegalStateException("La partie est terminée");
        }

        strategieJeu.calculerScoreTour(this);
        tourActuel++;
    }

    /**
     * Trouve le joueur ayant le plus de points pour le qualifier de vainqueur
     * @return Le vainqueur
     */
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
