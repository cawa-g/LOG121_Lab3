
import com.lab3.diceframework.De;
import com.lab3.diceframework.Des;
import com.lab3.diceframework.Joueur;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

/**
 * Created by francistoupin on 15-03-16.
 */
public class JoueurTest {

    private static Des collectionDeDes = new Des();

    @Test
    public void constructeur_DesNull_IllegalArgumentException() {
        CustomAsserts.LanceException(() -> new Joueur(null), IllegalArgumentException.class);
    }

    @Test
    public void constructeur_DesValides_JoueurCree() {
        Joueur joueur = new Joueur(this.collectionDeDes);

        Assert.assertNotNull(joueur.roulerDes());
    }

    @Test
    public void compareTo_JoueurNull_IllegalArgumentException() {

        CustomAsserts.LanceException(() -> new Joueur(this.collectionDeDes).compareTo(null), IllegalArgumentException.class);
    }

    @Test
    public void compareTo_JoueurOScorePlusBas_Moins1() {
        Joueur joueur1 = new Joueur(collectionDeDes);
        Joueur joueur2 = new Joueur(collectionDeDes);

        joueur1.incrementerScore(1);
        joueur2.incrementerScore(10);

        Assert.assertTrue(joueur1.compareTo(joueur2) == -1);
    }

    @Test
    public void compareTo_Joueur0ScorePlusHaut_1() {
        Joueur joueur1 = new Joueur(collectionDeDes);
        Joueur joueur2 = new Joueur(collectionDeDes);

        joueur1.incrementerScore(10);
        joueur2.incrementerScore(1);

        Assert.assertTrue(joueur1.compareTo(joueur2) == 1);
    }

    @Test
    public void compareTo_Joueur0ScoreEgal_0() {
        Joueur joueur1 = new Joueur(collectionDeDes);
        Joueur joueur2 = new Joueur(collectionDeDes);

        joueur1.incrementerScore(10);
        joueur2.incrementerScore(10);

        Assert.assertTrue(joueur1.compareTo(joueur2) == 0);
    }

    @Test
    public void obtenirScore_AucuneRondeJouee_0() {
        Joueur joueur1 = new Joueur(collectionDeDes);

        Assert.assertTrue(joueur1.obtenirScore() == 0);
    }

    @Test
    public void obtenirScore_ScoreAEteIncremente_ScoreValide() {
        Joueur joueur1 = new Joueur(collectionDeDes);
        joueur1.incrementerScore(1);

        Assert.assertTrue(joueur1.obtenirScore() == 1);
    }

    @Test
    public void roulerDes_LesDesAvecLeursNouvellesValeurs() {

        MockDe mockDe = new MockDe(6);
        MockDe mockDe2 = new MockDe(6);

        //Le dé va toujours retourné la valeur 3 maintenant, comme ça on le contrôle bien.
        mockDe.setObtenirValeurResult(new Integer[]{3});
        mockDe2.setObtenirValeurResult(new Integer[]{5});
        Des des = new Des();
        des.ajouter(mockDe);
        des.ajouter(mockDe2);

        Joueur joueur = new Joueur(des);
        Iterable<De> desRoules = joueur.roulerDes();

        Iterator<De> iterateur = desRoules.iterator();

        //Vérifier que les dés ont bien été roulés en vérifiant les valeurs obtenues.
        Assert.assertTrue(iterateur.next().obtenirValeur() == 3);
        Assert.assertTrue(iterateur.next().obtenirValeur() == 5);
    }

    @Test
    public void incrementerScore_ValeurInferieureAZero_IllegalArgumentException() {
        Joueur joueur1 = new Joueur(collectionDeDes);
        CustomAsserts.LanceException(() -> joueur1.incrementerScore(-1), IllegalArgumentException.class);
    }

    @Test
    public void incrementerScore_ValeurAuDessusDeZero_ScoreIncremente() {
        Joueur joueur1 = new Joueur(collectionDeDes);
        joueur1.incrementerScore(2);

        Assert.assertTrue(joueur1.obtenirScore() == 2);
    }

    @Test
    public void incrementerScore_ScoreAuDessusDeZero_ScorePeutEtreIncrementePlusieursFois() {
        Joueur joueur1 = new Joueur(collectionDeDes);
        joueur1.incrementerScore(2);
        joueur1.incrementerScore(2);

        Assert.assertTrue(joueur1.obtenirScore() == 2 + 2);
    }
}