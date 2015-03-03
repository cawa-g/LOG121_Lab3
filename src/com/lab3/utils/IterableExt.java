package com.lab3.utils;

import java.util.Iterator;

/**
 * Created by francistoupin on 15-03-02.
 */
public final class IterableExt {
    private IterableExt(){}

    public final static <T> boolean all(final Iterable<T> iterable, final Lambda<Boolean,T> lambda){
        boolean allValid = true;
        Iterator<T> iterator = iterable.iterator();

        while(allValid == true && iterator.hasNext()){
            allValid = lambda.execute(iterator.next());
        }

        return allValid;
    }
}
