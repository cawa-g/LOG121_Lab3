/******************************************************
 Cours:  LOG121
 Projet: Laboratoire #3
 Nom du fichier: com.lab3.buncoplus.JeuTest
 Date créé: 2015-03-16
 *******************************************************
 Historique des modifications
 2015-03-16 : Francis
 *******************************************************/

import com.lab3.diceframework.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public class JeuTest {

    private final StrategieJeu strategieJeuMock = new StrategieJeu() {
        @Override
        public void calculerScoreTour(Jeu jeu) {
        }

        @Override
        public Joueur calculerLeVainqueur(Jeu jeu) {
            return null;
        }};

    private FabriqueDeJeu fabriqueMock = new FabriqueDeJeu() {
        @Override
        protected Des creerDes() {
            return new Des();
        }

        @Override
        protected Joueurs creerJoueurs(int nombreDeJoueurs) {
            Joueurs joueurs = new Joueurs();
            for (int indexAjout = 0; indexAjout < nombreDeJoueurs; indexAjout++) {
                joueurs.ajouter(new Joueur(creerDes()));
            }

            return joueurs;
        }
    };

    /**
     * On ne peut pas tester le constructeur, puisqu'il est package private, on va le tester via le factory
     */

    @Test
    public void construitViaFabrique_JeuBienInitialise(){

        Jeu jeu = fabriqueMock.creer(1, 1, strategieJeuMock);

        //Va nous servir à compter le nombre de joueurs
        Iterator<Joueur> joueurIterator = jeu.obtenirJoueurs().iterator();
        joueurIterator.next();

        //Il ne doit pas y avoir plus d'un joueur
        boolean nombreDeJoueurEstValide = !joueurIterator.hasNext();

        Assert.assertTrue(jeu.obtenirTour() == 1);
        Assert.assertTrue(nombreDeJoueurEstValide);
    }

    @Test
    public void obtenirJoueur_ObtientLesJoueurs(){
        fabriqueMock = new FabriqueDeJeu() {
            @Override
            protected Des creerDes() {
                return new Des();
            }

            @Override
            protected Joueurs creerJoueurs(int nombreDeJoueurs) {
                Joueurs joueurs = new Joueurs();
                Joueur joueur1 = new Joueur(creerDes());
                joueur1.incrementerScore(2);
                Joueur joueur2 = new Joueur(creerDes());
                joueur2.incrementerScore(3);

                joueurs.ajouter(joueur1);
                joueurs.ajouter(joueur2);

                return joueurs;
            }
        };

        Jeu jeu = fabriqueMock.creer(2, 1, strategieJeuMock);

        Iterator<Joueur> iterator = jeu.obtenirJoueurs().iterator();

        //Vérification des scores
        Assert.assertTrue(iterator.next().obtenirScore() == 2);
        Assert.assertTrue(iterator.next().obtenirScore() == 3);
    }

    @Test
    public void obtenirTour_SansAvoirJouer_TourEgal1(){
        Jeu jeu = fabriqueMock.creer(1, 1, strategieJeuMock);

        Assert.assertTrue(jeu.obtenirTour() == 1);
    }

    @Test
    public void obtenirTour_ApresAvoirJouer_TourEgal2(){
        Jeu jeu = fabriqueMock.creer(1, 3, strategieJeuMock);

        jeu.calculerScoreTour();
        Assert.assertTrue(jeu.obtenirTour() == 2);
    }

    @Test
    public void calculerScoreTour_PartieTerminee_IllegalStateException(){
        Jeu jeu = fabriqueMock.creer(1, 1, strategieJeuMock);

        //Fais avancer au tour suivant
        jeu.calculerScoreTour();

        CustomAsserts.LanceException(jeu::calculerScoreTour, IllegalArgumentException.class);
    }

    @Test
    public void calculerScoreTour_TourAJouer_AppelleLaStrategie(){

        StrategieJeuMock strategieJeuMockAppelle = new StrategieJeuMock();

        Jeu jeu = fabriqueMock.creer(2,1,strategieJeuMockAppelle);
        jeu.calculerScoreTour();

        Assert.assertTrue(strategieJeuMockAppelle.calculerScoreTourEstAppele);
    }

    @Test
    public void calculerLeVainceur_AppelleLaStrategie(){

        StrategieJeuMock strategieJeuMockAppelle = new StrategieJeuMock();

        Jeu jeu = fabriqueMock.creer(2,1,strategieJeuMockAppelle);
        jeu.calculerLeVainqueur();

        Assert.assertTrue(strategieJeuMockAppelle.calculerLeVainqueurEstAppele);
    }

    @Test
    public void estTermine_PartieAAtteintLeTourMaximum_True(){

        //On le définit à 1 tour
        Jeu jeu = fabriqueMock.creer(1, 1, strategieJeuMock);
        jeu.calculerScoreTour(); //Augmente le tour.

        Assert.assertTrue(jeu.estTermine());
    }

    @Test
    public void estTermine_PartieEnCours_False(){

        //On le définit à 3 tours
        Jeu jeu = fabriqueMock.creer(3, 1, strategieJeuMock);
        jeu.calculerScoreTour(); //Augmente le tour une fois.

        Assert.assertFalse(jeu.estTermine());
    }

    /**
     * Mock de la stratégie pour vérifier que ça a été appeler dans le jeu
     */
    class StrategieJeuMock implements StrategieJeu {

        public boolean calculerScoreTourEstAppele = false;
        public boolean calculerLeVainqueurEstAppele = false;

        @Override
        public void calculerScoreTour(Jeu jeu) {
            calculerScoreTourEstAppele = true;
        }

        @Override
        public Joueur calculerLeVainqueur(Jeu jeu) {
            calculerLeVainqueurEstAppele = true;
            return null;
        }
    }
}
