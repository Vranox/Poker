import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ecrire un nombre: ");
            String input_Player1 = scanner.next();
            System.out.println(new Carte(input_Player1));
        }

    }
}
