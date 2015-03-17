package com.lab3.diceframework;

import java.util.Random;

/**
 * Un dé à jouer
 */
public class De implements Comparable<De>{

    private final static Random generateurAleatoire = new Random();
    private int nombreDeFaces;
    private Integer valeurActuelleDuDe;

    /**
     * Initialise un dé à jouer avec un certain nombre de faces
     * @param nombreDeFaces Nombre de faces du dé
     */
    public De(int nombreDeFaces) {
        if(nombreDeFaces < 1){
            throw new IllegalArgumentException("Le nombre de face ne peut pas être inférieure à 1");
        }

        this.nombreDeFaces = nombreDeFaces;
        this.valeurActuelleDuDe = null;
    }

    /**
    * Compare un dé avec un autre
    * @param o Dé à comparer
    * @return  -1 si le dé "o" a moins de faces
    *          0 si le dé "o" a le même nombre de faces
    *          1 si le dé "o" a plus de faces
    */
    @Override
    public int compareTo(De o) {
        if(o == null){
            throw new IllegalArgumentException("Le dé 0 est null");
        }

        return obtenirValeur().compareTo(o.obtenirValeur());
    }

    /**
     * Roule le dé
     */
    public void rouler(){
        valeurActuelleDuDe = generateurAleatoire.nextInt(nombreDeFaces) + 1;
    }

    /**
     *
     * @return La valeur actuelle du dé.
     */
    public Integer obtenirValeur(){
        if(valeurActuelleDuDe == null){
            throw new IllegalStateException("Le dé n'a jamais été lancé.");
        }

        return valeurActuelleDuDe;
    }

    /**
     *
     * @return le nombre du faces d'un dé
     */
    public Integer obtenirNombreDeFaces(){
        return nombreDeFaces;
    }
}