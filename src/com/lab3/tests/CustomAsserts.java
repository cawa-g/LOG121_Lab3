import org.junit.Assert;

/**
 * Created by francistoupin on 15-03-04.
 */
public final class CustomAsserts {

    public static <T extends Exception> void LanceException(Runnable expression, Class<T> exceptionAttendue){
        try{
            expression.run();
        } catch(Exception ex){
            if(ex.getClass().equals(exceptionAttendue)){
               return; //Le test a passé!
            }
        }

        Assert.fail("L'exception attendue : " + exceptionAttendue.getName() + " n'a pas été lancée.");
    }
}
