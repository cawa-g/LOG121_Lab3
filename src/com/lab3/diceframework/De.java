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
        return o.obtenirValeur().compareTo(obtenirValeur());
    }

    /**
     * Roule le dé
     */
    public void rouler(){
        /*
        * todo : On ne retourne pas la valeur du dé parce qu'ainsi on peut créé un état pour le dé. (bon ou pas? à voir j'imagine)
         */

        valeurActuelleDuDe = generateurAleatoire.nextInt(nombreDeFaces) + 1;
    }

    /**
     *
     * @return La valeur actuelle du dé.
     */
    public Integer obtenirValeur(){
        return valeurActuelleDuDe;
    }
}