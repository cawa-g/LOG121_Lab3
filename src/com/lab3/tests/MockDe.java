import com.lab3.diceframework.De;

import java.util.concurrent.Callable;

/**
 * Created by francistoupin on 15-03-16.
 */
class MockDe extends De {
    /**
     * Initialise un dé à jouer avec un certain nombre de faces
     *
     * @param nombreDeFaces Nombre de faces du dé
     */
    public MockDe(int nombreDeFaces) {
        super(nombreDeFaces);
    }

    private Integer[] valeursHardcodee;
    private int indexLancement = -1;

    public void setObtenirValeurResult(Integer[] valeursHardcodee){
        this.valeursHardcodee = valeursHardcodee;
    }

    @Override
    public void rouler(){
        indexLancement++;
    }

    @Override
    public Integer obtenirValeur(){
        Integer valeur = valeursHardcodee[indexLancement];
        return valeur;
    }
}
