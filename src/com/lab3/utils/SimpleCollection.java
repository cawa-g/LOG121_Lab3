package com.lab3.utils;

import java.util.Iterator;

/**
 * Collection exposant les méthodes de base
 * @param <T> Élément de la liste
 */
public class SimpleCollection<T> implements Iterable<T>{
    private T[] elements;
    private int endIndex = 0;
    private final int initialSize;

    public SimpleCollection(){
        //50 est complètement arbitraire, semble être adéquat pour une collection.
        initialSize = 50;
        elements = (T[])new Object[initialSize];
    }

    /**
     * Ajoute à la collection
     * @param value Valeur à ajouter
     */
    public void add(T value){
        elements[endIndex] = value;
        endIndex++;

        // todo : overkill?
        // Si on arrive à la fin de l'array, il faut en augmenter la taille pour continuer de travailler.
        if(endIndex == elements.length - 1){
            T[] newArray = (T[])new Object[elements.length + initialSize];
            System.arraycopy(elements,0,newArray,0,elements.length);
            elements = newArray;
        }
    }

    /**
     * Retire la première instance de la valeur de la collection
     * @param value Valeur à retirer
     */
    public void remove(T value){

        boolean foundValue = false;
        for(int removeIndex = 0; removeIndex < size(); removeIndex++){
            if(!foundValue){
                //Vérifier si on a trouver la première instance de la valeur à retirer
                foundValue = elements[removeIndex].equals(value);
            } else {
                //On l'a trouvé, maintenant on décale les valeurs pour retirer la valeur recherchée.
                elements[removeIndex] = elements[removeIndex + 1];
            }
        }

        elements[size()] = null;
        endIndex--;

        //todo : est-ce qu'on devrait diminuer l'array de taille si on arrive à un certain point?
    }

    public int size(){
        return endIndex;
    }

    /**
     *
     * @return L'itérateur de la collection
     */
    @Override
    public Iterator<T> iterator() {
        return new SimpleCollectionIterator<>(this);
    }

    /**
     * Permet l'itération dans une SimpleCollection
     * @param <T> Typ d'élément de la liste
     */
    private class SimpleCollectionIterator<T> implements Iterator<T>{

        private int currentIndex = 0;
        private SimpleCollection<T> simpleCollection;

        /**
         * Crée une instace de SimpleCollectionIterator
         * @param simpleCollection Collection à itérer
         */
        SimpleCollectionIterator(SimpleCollection<T> simpleCollection){
            this.simpleCollection = simpleCollection;
        }

        /**
         *
         * @return true si l'itérateur a un prochain élément
         */
        @Override
        public boolean hasNext() {
            return currentIndex < simpleCollection.size();
        }

        /**
         *
         * @return Prochaine valeur de l'itérateur
         */
        @Override
        public T next() {
            currentIndex++;
            return simpleCollection.elements[currentIndex];
        }
    }
}
