import org.junit.Assert;

/**
 * Created by francistoupin on 15-03-04.
 */
public final class CustomAsserts {

    public interface Lambda{
        void execute();
    }

    public static <T extends Exception> void LanceException(Lambda lambdaQuiDevraitLancer, Class<T> exceptionAttendue){
        try{
            lambdaQuiDevraitLancer.execute();

            Assert.fail("L'exception attendue : " + exceptionAttendue.getName() + " n'a pas été lancée.");
        } catch(Exception ex){
            if(ex.getClass().equals(exceptionAttendue)){
                //Le test a passé!
            } else{
                throw ex;
            }
        }
    }
}
