import com.lab3.buncoplus.*;
import com.lab3.diceframework.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by francistoupin on 15-03-16.
 */
public class StrategieJeuBuncoTest {

    private StrategieJeuBunco strategieJeuBunco = new StrategieJeuBunco();

    @Test
    public void calculerScoreTour_JeuNull_InvalidArgumentException(){
        CustomAsserts.LanceException(() -> strategieJeuBunco.calculerScoreTour(null), IllegalArgumentException.class);
    }

    @Test
    public void calculerScoreTour_AucuneOccurenceDuTourDansLesDes_0PointsEtPasse(){
        Integer[][] valeursDesDes = {
                {2},
                {3},
                {4}
        };

        Des des = creerDesTruques(6, valeursDesDes);
        FabriqueBunco mockFabriqueJeuBunco = new FabriqueBunco(){
            @Override
            public Des creerDes(){
                return des;
            }
        };

        //On passe la stratégie ici mais elle ne sera pas utilisée..
        Jeu jeuBunco = mockFabriqueJeuBunco.creer(6,1,strategieJeuBunco);

        strategieJeuBunco.calculerScoreTour(jeuBunco);

        Joueur joueur = jeuBunco.obtenirJoueurs().iterator().next();

        Assert.assertTrue(joueur.obtenirScore() == 0);
    }

    @Test
    public void calculerScoreTour_UneOccurenceDuTourDansLesDes_1PointParTourEtRejoue(){
        Integer[][] valeursDesDes = {
                {1,2,4}, //Il y a un 1, qui correspond au tour, on va donc avoir un point
                {2,1,5}, //Il y a un 1 (Test qu'on rejoue)
                {2,2,6}
        };

        Des des = creerDesTruques(6, valeursDesDes);
        FabriqueBunco mockFabriqueJeuBunco = new FabriqueBunco(){
            @Override
            public Des creerDes(){
                return des;
            }
        };

        //On passe la stratégie ici mais elle ne sera pas utilisée..
        Jeu jeuBunco = mockFabriqueJeuBunco.creer(6,1,strategieJeuBunco);

        strategieJeuBunco.calculerScoreTour(jeuBunco);

        Joueur joueur = jeuBunco.obtenirJoueurs().iterator().next();

        Assert.assertTrue(joueur.obtenirScore() == 2);
    }

    @Test
    public void calculerScoreTour_DeuxOccurencesDuTourDansLesDes_2PointsEtRejoue(){
        Integer[][] valeursDesDes = {
                {1,2,4}, //Il y a deux 1, qui correspond au tour, on va donc avoir deux points
                {2,1,5}, //Il y a un 1 (Test qu'on rejoue)
                {1,2,6}
        };

        Des des = creerDesTruques(6, valeursDesDes);
        FabriqueBunco mockFabriqueJeuBunco = new FabriqueBunco(){
            @Override
            public Des creerDes(){
                return des;
            }
        };

        //On passe la stratégie ici mais elle ne sera pas utilisée..
        Jeu jeuBunco = mockFabriqueJeuBunco.creer(6,1,strategieJeuBunco);

        strategieJeuBunco.calculerScoreTour(jeuBunco);

        Joueur joueur = jeuBunco.obtenirJoueurs().iterator().next();

        Assert.assertTrue(joueur.obtenirScore() == 3);
    }

    @Test
    public void calculerScoreTour_TroisFoisLaMemeFacePasDuTourCourant_5PointsEtRejoue(){
        Integer[][] valeursDesDes = {
                {3,2,3}, //Trois 3, donc 5 points
                {3,1,4}, //Il y a un 1, donc un point (Test qu'on rejoue)
                {3,2,5}
        };

        Des des = creerDesTruques(6, valeursDesDes);
        FabriqueBunco mockFabriqueJeuBunco = new FabriqueBunco(){
            @Override
            public Des creerDes(){
                return des;
            }
        };

        //On passe la stratégie ici mais elle ne sera pas utilisée..
        Jeu jeuBunco = mockFabriqueJeuBunco.creer(6,1,strategieJeuBunco);

        strategieJeuBunco.calculerScoreTour(jeuBunco);

        Joueur joueur = jeuBunco.obtenirJoueurs().iterator().next();

        Assert.assertTrue(joueur.obtenirScore() == 6);
    }

    @Test
    public void calculerScoreTour_TroisFoisLaMemeFaceDuTour_21PointsEtPasse(){
        Integer[][] valeursDesDes = {
                {1}, //Bunco!
                {1},
                {1}
        };

        Des des = creerDesTruques(6, valeursDesDes);
        FabriqueBunco mockFabriqueJeuBunco = new FabriqueBunco(){
            @Override
            public Des creerDes(){
                return des;
            }
        };

        //On passe la stratégie ici mais elle ne sera pas utilisée..
        Jeu jeuBunco = mockFabriqueJeuBunco.creer(6,1,strategieJeuBunco);

        strategieJeuBunco.calculerScoreTour(jeuBunco);

        Joueur joueur = jeuBunco.obtenirJoueurs().iterator().next();

        Assert.assertTrue(joueur.obtenirScore() == 21);
    }

    @Test
    public void calculerLeVainceur_JeuNull_IllegalArgumentException(){
        CustomAsserts.LanceException(() -> strategieJeuBunco.calculerLeVainqueur(null), IllegalArgumentException.class);
    }

    @Test
    public void calculerLeVainceur_Joueur1ALeScoreLePlusHaut_Joueur1Gagne(){

        //Ce joueur devrait gagner avec un score de 21
        Integer[][] valeursDesDesJoueur1 = {
                {1,3,2,3,1,4},
                {1,4,4,5,2,5},
                {1,5,5,6,3,2}
        };

        //Score de 0
        Integer[][] valeursDesDesJoueur2 = {
                {3,3,2,3,1,4},
                {2,4,4,5,2,5},
                {4,5,5,6,3,2}
        };

        Des desJoueur1 = creerDesTruques(6, valeursDesDesJoueur1);
        Des desJoueur2 = creerDesTruques(6, valeursDesDesJoueur2);

        FabriqueBunco mockFabriqueJeuBunco = new FabriqueBunco(){

            private boolean estPourJoueur1 = true;

            @Override
            public Des creerDes(){
                if(estPourJoueur1){
                    estPourJoueur1 = false;
                    return desJoueur1;
                } else{
                    return desJoueur2;
                }

            }
        };

        //On passe la stratégie ici mais elle ne sera pas utilisée..
        Jeu jeuBunco = mockFabriqueJeuBunco.creer(6,1,strategieJeuBunco);

        while(!jeuBunco.estTermine()){
            jeuBunco.calculerScoreTour();
        }

        Joueur vainqueur = jeuBunco.calculerLeVainqueur();

        Assert.assertTrue(vainqueur.obtenirScore() == 21);
    }

    private Des creerDesTruques(int nombreDeFaces, Integer[][] valeursDesDesParTours){
        Des des = new Des();

        for (int indexCreation = 0; indexCreation < valeursDesDesParTours.length; indexCreation++) {

            MockDe mockDe = new MockDe(nombreDeFaces);
            mockDe.setObtenirValeurResult(valeursDesDesParTours[indexCreation]);
            des.ajouter(mockDe);
        }

        return des;
    }
}
