import com.lab3.diceframework.De;

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
        return valeursHardcodee[indexLancement];
    }
}
