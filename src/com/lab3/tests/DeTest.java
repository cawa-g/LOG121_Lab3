
import com.lab3.diceframework.De;
import org.junit.Assert;
import org.junit.Test;

public class DeTest {

    @Test
    public void constructeur_nombreDeFacesNegatives_IllegalArgumentException(){

        CustomAsserts.LanceException(() -> new De(-1), IllegalArgumentException.class);
    }

    @Test
    public void constructeur_nombreDeFacesZero_IllegalArgument(){
        CustomAsserts.LanceException(() -> new De(0), IllegalArgumentException.class);
    }

    @Test
    public void constructeur_nombreDeFacesCorrecte_DeCreeAvecBonNombresDeFaces(){
        De de = new De(4);

        Assert.assertTrue(de.obtenirNombreDeFaces() == 4);
    }

    @Test
    public void rouler_valeurObtenueDansIntervalle() {
        int nombreDeFaces = 6;
        De de = new De(nombreDeFaces);
        de.rouler();

        Assert.assertTrue(1 <= de.obtenirValeur() && de.obtenirValeur() <= nombreDeFaces);
    }

    @Test
    public void compareTo_De1AvecPlusPetiteValeurQueDe2_Moins1() throws Exception {
        De de1 = new De(4);
        De de2 = new De(4);

        do{
            //Pas la meilleure option, mais le hasard va finir par faire que ça marche.
            de1.rouler();
            de2.rouler();
        }while(de1.obtenirValeur() >= de2.obtenirValeur());

        int valeurComparee = de1.compareTo(de2);

        Assert.assertTrue(valeurComparee == -1);
    }

    @Test
    public void compareTo_De1AvecValeurEgaleAuDe2_0() throws Exception {
        De de1 = new De(4);
        De de2 = new De(4);


        do{
            //Pas la meilleure option, mais le hasard va finir par faire que ça marche.
            de1.rouler();
            de2.rouler();
        }while(!de1.obtenirValeur().equals(de2.obtenirValeur()));

        int valeurComparee = de1.compareTo(de2);

        Assert.assertTrue(valeurComparee == 0);
    }

    @Test
    public void compareTo_De1AvecPlusGrandeValeurQueDe2_1() throws Exception {
        De de1 = new De(4);
        De de2 = new De(4);

        do{
            //Pas la meilleure option, mais le hasard va finir par faire que ça marche.
            de1.rouler();
            de2.rouler();
        }while(de1.obtenirValeur() <= de2.obtenirValeur());

        int valeurComparee = de1.compareTo(de2);

        Assert.assertTrue(valeurComparee == 1);
    }

    @Test
    public void compareTo_De2Null_IllegalArgumentException(){
        De de = new De(2);

        CustomAsserts.LanceException(() -> de.compareTo(null), IllegalArgumentException.class);
    }

    @Test
    public void obtenirValeur_DeJamaisLancee_IllegalStateException() throws Exception {
        De de = new De(4);

        CustomAsserts.LanceException(de::obtenirValeur, IllegalStateException.class);
    }

    @Test
    public void obtenirValeur_DeRoule_ObtientLaValeurDuDe(){
        De de = new De(4);

        de.rouler();

        Assert.assertTrue(de.obtenirValeur() <= 4 && de.obtenirValeur() >= 1);
    }

    @Test
    public void obtenirNombreDeFaces_DeInitialise_NombreDeFacesCorrect(){
        De de = new De(4);

        Assert.assertTrue(de.obtenirNombreDeFaces() == 4);
    }
}