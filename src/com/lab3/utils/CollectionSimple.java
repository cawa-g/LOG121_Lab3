package com.lab3.utils;

import java.util.Iterator;

/**
 * Collection exposant les méthodes de base
 * @param <T> Élément de la liste
 */
public class CollectionSimple<T> implements Iterable<T>{
    private T[] elements;
    private int indexDeFin = 0;
    private final int tailleInitiale;

    public CollectionSimple(){
        //50 est complètement arbitraire, semble être adéquat pour une collection.
        tailleInitiale = 50;
        elements = (T[])new Object[tailleInitiale];
    }

    /**
     * Ajoute à la collection
     * @param valeur Valeur à ajouter
     */
    public void ajouter(T valeur){
        elements[indexDeFin] = valeur;
        indexDeFin++;

        // todo : overkill?
        // Si on arrive à la fin de l'array, il faut en augmenter la taille pour continuer de travailler.
        if(indexDeFin == elements.length - 1){
            T[] nouveauTableau = (T[])new Object[elements.length + tailleInitiale];
            System.arraycopy(elements,0,nouveauTableau,0,elements.length);
            elements = nouveauTableau;
        }
    }

    public int taille(){
        return indexDeFin;
    }

    /**
     *
     * @return L'itérateur de la collection
     */
    @Override
    public Iterator<T> iterator() {
        return new IterateurCollectionSimple<T>();
    }

    /**
     * Permet l'itération dans une SimpleCollection
     * @param <T> Typ d'élément de la liste
     */
    private class IterateurCollectionSimple<T> implements Iterator<T>{

        private int indexCourant = 0;

        /**
         *
         * @return true si l'itérateur a un prochain élément
         */
        @Override
        public boolean hasNext() {
            return indexCourant < taille();
        }

        /**
         *
         * @return Prochaine valeur de l'itérateur
         */
        @Override
        public T next() {
            T element = (T)elements[indexCourant];
            indexCourant++;

            return element;
        }
    }
}
