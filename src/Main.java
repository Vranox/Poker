import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

            MainJoueur mainJoueur1 = new MainJoueur();
            MainJoueur mainJoueur2 = new MainJoueur();
            Scanner scanner = new Scanner(System.in);
            int result;
            System.out.println("Au tour du joueur 1 d'entrer sa main: ");
            /*int i=0;
            while(i<5){
                try{
                    mainJoueur1.ajouteCarte(new Carte(scanner.next()));
                }
                catch (Exception mauvaisInput){
                    System.out.println(mauvaisInput.getMessage()+ ", veuillez réessayer");
                    i--;
                }
                i++;
            }
            i=0;
            System.out.println("Au tour du joueur 2 d'entrer une carte: ");
            while(i<5){
                try{
                    mainJoueur2.ajouteCarte(new Carte(scanner.next()));
                }
                catch (Exception mauvaisInput){
                    System.out.println(mauvaisInput.getMessage()+ ", veuillez réessayer");
                    i--;
                }
                i++;
            }*/
            mainJoueur1.ajouteCarte(new Carte("7tr"));
            mainJoueur1.ajouteCarte(new Carte("5tr"));
            mainJoueur1.ajouteCarte(new Carte("3tr"));
            mainJoueur1.ajouteCarte(new Carte("4tr"));
            mainJoueur1.ajouteCarte(new Carte("6tr"));
            mainJoueur2.ajouteCarte(new Carte("10tr"));
            mainJoueur2.ajouteCarte(new Carte("Atr"));
            mainJoueur2.ajouteCarte(new Carte("Rtr"));
            mainJoueur2.ajouteCarte(new Carte("Dtr"));
            mainJoueur2.ajouteCarte(new Carte("Vtr"));
            try{
                result = mainJoueur1.compareTo(mainJoueur2);
                switch (result){
                    case 0 -> System.out.println("Egalité de " + mainJoueur1.plusForteCombinaison + " avec les cartes : "+mainJoueur1.resultCartes+ " et " + mainJoueur2.resultCartes);
                    case 1 -> System.out.println("Le vainqueur est le joueur 1 avec un" + mainJoueur1.plusForteCombinaison+" avec: " + mainJoueur1.resultCartes);
                    case 2 -> System.out.println("Le vainqueur est le joueur 2 avec un" + mainJoueur2.plusForteCombinaison+" avec: " + mainJoueur2.resultCartes);
                }
                System.out.println("Points joueur1 = "+mainJoueur1.pointsMain);
                System.out.println("Mains joueur1 = "+mainJoueur1.resultCartes);
                System.out.println("Points joueur2 = "+mainJoueur2.pointsMain);
                System.out.println("Mains joueur2 = "+mainJoueur2.resultCartes);
            }
            catch(Exception doublons){
                System.out.println(doublons.getMessage());
            }

        

    }
}
