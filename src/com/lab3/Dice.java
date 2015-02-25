package com.lab3;

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
        return ((Integer)o.getActualValue()).compareTo(getActualValue());
    }

    /**
     * Roule le dé
     * @return La valeur de la face du dé
     */
    public void roll(){
        actualValue = random.nextInt(numberOfFaces + 1);
    }

    public int getActualValue(){
        return actualValue;
    }
}
