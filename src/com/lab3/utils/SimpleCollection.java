package com.lab3.utils;

import java.util.Iterator;

//todo : Oops, ça doit être un array au lieu de nodes

/**
 * Collection exposant les méthodes de base
 * @param <T> Élément de la liste
 */
public class SimpleCollection<T> implements Iterable<T>{
    private Node head;

    /**
     * Ajoute à la collection
     * @param value Valeur à ajouter
     */
    public void add(T value){
        Node<T> node = new Node(value);
        node.setNext(head);

        head = node;
    }

    /**
     * Retire la première instance de la valeur de la collection
     * @param value Valeur à retirer
     */
    public void remove(T value){
        Iterator<T> iterator = new SimpleLinkedListIterator(this);
        T nodeValue = null;
        while(iterator.hasNext() && nodeValue != value){
            nodeValue = iterator.next();
        }

        iterator.remove();
    }

    /**
     *
     * @return L'itérateur de la collection
     */
    @Override
    public Iterator<T> iterator() {
        return new SimpleLinkedListIterator<>(this);
    }

    private class Node<T> {
        private T value;
        private Node<T> next;

        Node(T value) {
            this.value = value;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private class SimpleLinkedListIterator<T> implements Iterator<T>{

        private Node<T> previous;
        private Node<T> current;

        SimpleLinkedListIterator(SimpleCollection<T> linkedList){
            this.current = linkedList.head;
            this.previous = null;
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public T next() {
            previous = current;
            current = current.next;
            return current.value;
        }

        @Override
        public void remove(){
            Node<T> next = current.next;
            previous.next = next;
            current = previous;
        }
    }
}
