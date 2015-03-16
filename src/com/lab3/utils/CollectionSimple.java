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

    /**
     * Retire la première instance de la valeur de la collection
     * @param valeur Valeur à retirer
     */
    public void retirer(T valeur){

        boolean valeurTrouvee = false;
        for(int indexARetirer = 0; indexARetirer < taille(); indexARetirer++){
            if(!valeurTrouvee){
                //Vérifier si on a trouver la première instance de la valeur à retirer
                valeurTrouvee = elements[indexARetirer].equals(valeur);
            } else {
                //On l'a trouvé, maintenant on décale les valeurs pour retirer la valeur recherchée.
                elements[indexARetirer] = elements[indexARetirer + 1];
            }
        }

        elements[taille()] = null;
        indexDeFin--;

        //todo : est-ce qu'on devrait diminuer l'array de taille si on arrive à un certain point?
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
            indexCourant++;
            return (T)elements[indexCourant];
        }
    }
}
