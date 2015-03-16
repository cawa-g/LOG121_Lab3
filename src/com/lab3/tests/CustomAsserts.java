import org.junit.Assert;

/**
 * Created by francistoupin on 15-03-04.
 */
public final class CustomAsserts {

    public static <T extends Exception> void LanceException(Runnable expression, Class<T> exceptionAttendue){
        try{
            expression.run();

            Assert.fail("L'exception attendue : " + exceptionAttendue.getName() + " n'a pas été lancée.");
        } catch(Exception ex){
            if(ex.getClass().equals(exceptionAttendue)){
                //Le test a passé!
                return;
            }
            else if(ex instanceof MockThrownException) {
                Exception innerException = ((MockThrownException)ex).getInnerException();

                if(innerException.getClass().equals(exceptionAttendue)){
                    //Le test a réussi
                    return;
                }
            }

            throw ex;
        }
    }
}
