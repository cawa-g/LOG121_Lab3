package com.lab3.diceframework;

import java.util.Random;

/**
 * Un dé à jouer
 */
public class Dice implements Comparable<Dice>{

    private final static Random random = new Random();
    private int numberOfFaces;
    private Integer actualValue;

    /**
     * Initialise un dé à jouer avec un certain nombre de faces
     * @param numberOfFaces Nombre de faces du dé
     */
    public Dice(int numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
        this.actualValue = null;
    }

    /**
     * Compare un dé avec un autre
     * @param o Dé à comparer
     * @return  -1 si le dé "o" a moins de faces
     *          0 si le dé "o" a le même nombre de faces
     *          1 si le dé "o" a plus de faces
     */
    @Override
    public int compareTo(Dice o) {
        return ((Integer)o.getValue()).compareTo(getValue());
    }

    /**
     * Roule le dé
     */
    public void roll(){
        /*
        * todo : On ne retourne pas la valeur du dé parce qu'ainsi on peut créé un état pour le dé. (bon ou pas? à voir j'imagine)
         */

        actualValue = random.nextInt(numberOfFaces) + 1;
    }

    /**
     *
     * @return La valeur actuelle du dé.
     */
    public Integer getValue(){
        return actualValue;
    }
}