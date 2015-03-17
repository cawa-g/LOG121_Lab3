/******************************************************
 Cours:  LOG121
 Projet: Laboratoire #3
 Nom du fichier: com.lab3.buncoplus.MockDe
 Date créé: 2015-03-16
 *******************************************************
 Historique des modifications
 2015-03-16 : Francis
 *******************************************************/

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

    /**
     * Détermine les valeurs qui vont être retournée par le dé.
     * @param valeursHardcodee Valeurs qui vont être "brassés" par le dés.
     */
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
