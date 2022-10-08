import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        while(true){
            MainJoueur mainJoueur1 = new MainJoueur();
            MainJoueur mainJoueur2 = new MainJoueur();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Au tour du joueur 1 d'entrer sa main: ");
            int i=0;
            while(i<5){
                mainJoueur1.cartes.add(new Carte(scanner.next()));
                i++;
            }
            i=0;
            System.out.println("Au tour du joueur 2 d'entrer une carte: ");
            while(i<5){
                mainJoueur2.cartes.add(new Carte(scanner.next()));
                i++;
            }
            switch (mainJoueur1.compareTo(mainJoueur2)){
                case 0 -> System.out.println("Les deux cartes ont la même valeur, c'est une égalité");
                case 1 -> System.out.println("Le vainqueur est le joueur 1");
                case 2 -> System.out.println("Le vainqueur est le joueur 2");
            }
        }

    }
}
