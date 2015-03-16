import com.lab3.diceframework.De;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

/**
 * Created by francistoupin on 15-03-16.
 */
class MockDe extends De implements Mock {
    /**
     * Initialise un dé à jouer avec un certain nombre de faces
     *
     * @param nombreDeFaces Nombre de faces du dé
     */
    public MockDe(int nombreDeFaces) {
        super(nombreDeFaces);
    }

    private Callable<Integer> callable;
    private Exception exceptionLancee;

    public void setObtenirValeurResult(Callable<Integer> callable){
        this.callable = callable;
    }

    @Override
    public Integer obtenirValeur(){
        try {
            return callable.call();
        } catch (Exception e) {
            throw new MockThrownException(e);
        }
    }

    @Override
    public void rouler(){
        return;
    }

    @Override
    public Exception obtenirException() {
        return exceptionLancee;
    }
}
