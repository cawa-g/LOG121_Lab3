package com.lab3.diceframework;

import java.util.Iterator;

/**
 * Un joueur de dés
 */
public class Player implements Comparable<Player> {

    private int score;
    private Dices dices;

    /**
     * Crée une instance de joueur
     * @param dices Les dés du joueur
     */
    public Player(Dices dices){
        this.dices = dices;
    }

    /**
     * Compare un joueur avec un autre
     * @param o Dé à comparer
     * @return  -1 si le joueur "o" a un score plus élevé
     *          0 si le joueur "o" a le même score
     *          1 si le joueur "o" a un score plus faible
     */
    @Override
    public int compareTo(Player o) {
        return 0;
    }

    /**
     *
     * @return Le score d'un joueur
     */
    public int getScore(){
        return this.score;
    }

    /**
     * Le joueur roule tous ses dés
     * @return Les dés avec leurs valeurs actuelles
     */
    public Iterable<Dice> rollDices(){
        //todo : C'est triste retourner Iterator parce que les dés ne sont pas clônés, et que Iterator implémente "remove". Ça scrap l'encapsulation.

        dices.forEach(d -> d.roll());
        return dices;
    }

    /**
     * Incrémente le score du joueur de par un certain nombres de points
     * @param points Points à ajouter au score du joueur
     */
    public void incrementScore(int points){
        this.score += points;
    }

    /**
     * Ramène le score d'un joueur à 0.
     */
    public void resetScore(){
        //todo : Je mettrais ça dans un framework, mais on s'en sert pas ici.. or will we?? Da dammm
        score = 0;
    }
}
