package com.lab3.utils;

/**
 * Created by francistoupin on 15-03-04.
 */
public final class TestUtils {

    public interface Lambda{
        void execute();
    }

    public static <T extends Exception> boolean LanceException(Lambda lambdaQuiDevraitLancer, Class<T> exceptionAttendue){
        try{
            lambdaQuiDevraitLancer.execute();

            return false;
        } catch(Exception ex){
            if(ex.getClass().equals(exceptionAttendue)){
                return true;
            } else{
                throw ex;
            }
        }
    }
}
