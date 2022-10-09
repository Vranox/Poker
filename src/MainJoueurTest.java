import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainJoueurTest {

    @org.junit.jupiter.api.Test
    void compareToWinPlayer2() throws Exception {
        MainJoueur mainJoueur1 = new MainJoueur();
        mainJoueur1.cartes.add(new Carte("5Tr"));
        mainJoueur1.cartes.add(new Carte("6Tr"));
        mainJoueur1.cartes.add(new Carte("10Ca"));
        mainJoueur1.cartes.add(new Carte("5Co"));
        mainJoueur1.cartes.add(new Carte("RCo"));
        MainJoueur mainJoueur2 = new MainJoueur();
        mainJoueur2.cartes.add(new Carte("10Tr"));
        mainJoueur2.cartes.add(new Carte("3Ca"));
        mainJoueur2.cartes.add(new Carte("5Pi"));
        mainJoueur2.cartes.add(new Carte("10Pi"));
        mainJoueur2.cartes.add(new Carte("ACo"));
        assertEquals(2,mainJoueur1.compareTo(mainJoueur2));
    }
    @Test
    void compareToWinPlayer1() throws Exception {
        MainJoueur mainJoueur1 = new MainJoueur();
        mainJoueur1.cartes.add(new Carte("5Tr"));
        mainJoueur1.cartes.add(new Carte("6Tr"));
        mainJoueur1.cartes.add(new Carte("ACa"));
        mainJoueur1.cartes.add(new Carte("5Co"));
        mainJoueur1.cartes.add(new Carte("RCo"));
        MainJoueur mainJoueur2 = new MainJoueur();
        mainJoueur2.cartes.add(new Carte("10Tr"));
        mainJoueur2.cartes.add(new Carte("3Ca"));
        mainJoueur2.cartes.add(new Carte("5Pi"));
        mainJoueur2.cartes.add(new Carte("10Pi"));
        mainJoueur2.cartes.add(new Carte("RCo"));
        assertEquals(1,mainJoueur1.compareTo(mainJoueur2));
    }
    @Test
    void compareToEquals() throws Exception {
        MainJoueur mainJoueur1 = new MainJoueur();
        mainJoueur1.cartes.add(new Carte("5Tr"));
        mainJoueur1.cartes.add(new Carte("6Tr"));
        mainJoueur1.cartes.add(new Carte("10Ca"));
        mainJoueur1.cartes.add(new Carte("5Co"));
        mainJoueur1.cartes.add(new Carte("RCo"));
        MainJoueur mainJoueur2 = new MainJoueur();
        mainJoueur2.cartes.add(new Carte("10Tr"));
        mainJoueur2.cartes.add(new Carte("3Ca"));
        mainJoueur2.cartes.add(new Carte("5Pi"));
        mainJoueur2.cartes.add(new Carte("10Pi"));
        mainJoueur2.cartes.add(new Carte("RCo"));
        assertEquals(0,mainJoueur1.compareTo(mainJoueur2));
    }
}