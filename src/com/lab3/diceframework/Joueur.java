/******************************************************
 Cours:  LOG121
 Projet: Laboratoire #3
 Nom du fichier: com.lab3.diceframework.Joueur
 Date créé: 2015-03-05
 *******************************************************
 Historique des modifications
 2015-03-05 : Francis
 2015-03-08 : Olivier
 *******************************************************/

package com.lab3.diceframework;

/**
 * Un joueur de dés
 */
public class Joueur implements Comparable<Joueur> {

    private int score;
    private Des des;

    /**
     * Crée une instance de joueur
     * @param des Les dés du joueur
     */
    public Joueur(Des des){
        if(des == null){
            throw new IllegalArgumentException("Les dés sont null");
        }

        this.des = des;
    }

    /**
     * Compare un joueur avec un autre
     * @param o Dé à comparer
     * @return  -1 si le joueur "o" a un score plus élevé
     *          0 si le joueur "o" a le même score
     *          1 si le joueur "o" a un score plus faible
     */
    @Override
    public int compareTo(Joueur o) {
        if(o == null){
            throw new IllegalArgumentException("Le joueur o est null");
        }

        return ((Integer)this.score).compareTo(o.score);
    }

    /**
     *
     * @return Le score d'un joueur
     */
    public int obtenirScore(){
        return this.score;
    }

    /**
     * Le joueur roule tous ses dés
     * @return Les dés avec leurs valeurs actuelles
     */
    public Iterable<De> roulerDes(){
        des.forEach(De::rouler);
        return des;
    }

    /**
     * Incrémente le score du joueur de par un certain nombres de points
     * @param points Points à ajouter au score du joueur
     */
    public void incrementerScore(int points){
        if(points < 0){
            throw new IllegalArgumentException("Les points ne peuvent pas être inférieur à 1");
        }

        this.score += points;
    }
}
