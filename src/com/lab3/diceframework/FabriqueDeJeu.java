package com.lab3.diceframework;

/**
 * Created by francistoupin on 15-02-26.
 */
public abstract class FabriqueDeJeu {

    /*
     * todo : cette classe là est abbérante, sorry. Je vois mal comment implémenter le template, ça semble useless.
      * On checkera ça.
     */
    private int nombreDeTours;
    private int nombreDeJoueurs;
    private StrategieJeu strategieJeu;

    protected FabriqueDeJeu(int nombreDeTours, int nombreDeJoueurs, StrategieJeu strategieJeu){

        this.nombreDeTours = nombreDeTours;
        this.nombreDeJoueurs = nombreDeJoueurs;
        this.strategieJeu = strategieJeu;
    }

    protected abstract Des creerDesPourJoueurs();
    protected abstract Joueur creerJoueur(Des des);

    /**
     * VOMIS! (Non ok, faut changer ça) (C'est peut-être un peu mieux maintenant..)
     * @return
     */
    public Jeu creer(){
        Joueurs joueurs = new Joueurs();

        for (int index = 0; index < nombreDeJoueurs; index++) {
            Des desDuJoueur = creerDesPourJoueurs();
            joueurs.ajouter(creerJoueur(desDuJoueur));
        }

        return new Jeu(joueurs, nombreDeTours, strategieJeu);
    }
}
