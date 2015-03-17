import org.junit.Assert;

/**
 * Assertions personnalisée
 */
public final class CustomAsserts {

    /**
     * Vérifie qu'une méthode lance une exception
     * @param expression L'expression qui devrait lancé l'exception
     * @param exceptionAttendue Le type d'exception attendue
     * @param <T> Le type d'exception attendue
     */
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
