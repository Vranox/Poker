import java.util.ArrayList;

public class MainJoueur {
    ArrayList<Carte> cartes = new ArrayList<>();
    Carte carteLaPlusHaute;


    /*
   La méthode permet de comparer deux mains entre elles et retourne :
       - 0 : si les deux mains sont égales
       - 1 : si this est supérieur à la main entrée en paramètre
       - 2 : si this est inférieur à la main entrée en paramètre
    */
    public Carte carteLaPlusHaute(){
        int maxPointMain = 0;
        for (Carte i : this.cartes) {
            if(i.point>maxPointMain){
                maxPointMain = i.point;
                carteLaPlusHaute = i;
            }
        }
        return  carteLaPlusHaute;
    }
    public int compareTo(MainJoueur mainJoueur2){
        if(this.carteLaPlusHaute().point == mainJoueur2.carteLaPlusHaute().point){
            return 0;
        } else if (this.carteLaPlusHaute().point > mainJoueur2.carteLaPlusHaute().point) {
            return 1;
        }
        else {
            return 2;
        }
    }

}
