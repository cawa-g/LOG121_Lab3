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
        //todo : C'est triste retourner Iterator parce que les dés ne sont pas clônés, et que Iterator implémente "retirer". Ça scrap l'encapsulation.

        des.forEach(De::rouler);
        return des;
    }

    /**
     * Incrémente le score du joueur de par un certain nombres de points
     * @param points Points à ajouter au score du joueur
     */
    public void incrementerScore(int points){
        this.score += points;
    }
}
