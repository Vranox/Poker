import java.util.ArrayList;

public class MainJoueur {
    ArrayList<Carte> cartes = new ArrayList<>();

    /*
   La méthode permet de comparer deux mains entre elles et retourne :
       - 0 : si les deux mains sont égales
       - 1 : si this est supérieur à la main entrée en paramètre
       - 2 : si this est inférieur à la main entrée en paramètre
    */
    public int compareTo(MainJoueur mainJoueur2){
        int maxPointMain1 = 0;
        int maxPointMain2 = 0;
        for (Carte i : this.cartes) {
            if(i.point>maxPointMain1){
                maxPointMain1 = i.point;
            }
        }
        for (Carte i : mainJoueur2.cartes) {
            if(i.point>maxPointMain2){
                maxPointMain2 = i.point;
            }
        }
        if(maxPointMain1 == maxPointMain2){
            return 0;
        } else if (maxPointMain1>maxPointMain2) {
            return 1;
        }
        else {
            return 2;
        }
    }

}
