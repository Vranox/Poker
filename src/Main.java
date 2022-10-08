import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Au tour du joueur 1 d'entrer une carte: ");
            String input_Player1 = scanner.next();
            System.out.println("Au tour du joueur 2 d'entrer une carte: ");
            String input_Player2 = scanner.next();
            switch (new Carte(input_Player1).compareTo(new Carte(input_Player2))){
                case 0 -> System.out.println("Les deux cartes ont la même valeur, c'est une égalité");
                case 1 -> System.out.println("Le vainqueur est le joueur 1");
                case 2 -> System.out.println("Le vainqueur est le joueur 2");
            }
        }

    }
}
