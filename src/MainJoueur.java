import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.lang.Math.abs;

public class MainJoueur {
    ArrayList<Carte> cartes = new ArrayList<>();
    int pointsMain = 0;
    MAINS plusForteCombinaison;
    ArrayList<Carte> resultCartes = new ArrayList<>();

    /*
    Retourne le carte valant le plus de point
     */
    public void carteLaPlusHaute(MainJoueur mainJoueur){
        int maxPointMain = 0;
        Carte carteLaPlusHaute = null;
        for (Carte i : mainJoueur.cartes) {
            if(i.point>maxPointMain){
                maxPointMain = i.point;
                carteLaPlusHaute = i;
            }
        }
        resultCartes = new ArrayList<>();
        resultCartes.add(carteLaPlusHaute);
        mainJoueur.plusForteCombinaison = MAINS.CARTEHAUTE;
        mainJoueur.pointsMain = maxPointMain;
    }

    /*
   La méthode permet de comparer deux mains entre elles et retourne :
       - 0 : si les deux mains sont égales
       - 1 : si this est supérieur à la main entrée en paramètre
       - 2 : si this est inférieur à la main entrée en paramètre
    */
    public int compareTo(MainJoueur mainJoueur2) throws Exception {
        //Check si un doublon est présent entre les deux mains
        isDoublon(mainJoueur2);
        isSuite(this);
        isSuite(mainJoueur2);

        isCombinaison(this);
        isCombinaison(mainJoueur2);
        if(pointsMain<14 && mainJoueur2.pointsMain<14){
            carteLaPlusHaute(this);
            carteLaPlusHaute(mainJoueur2);
        }

        if(pointsMain<1 && mainJoueur2.pointsMain<1){
            throw new Exception("Pas de résultat possible");
        }
        if(this.pointsMain == mainJoueur2.pointsMain){
            return 0;
        }
        else if(this.pointsMain > mainJoueur2.pointsMain){
            return 1;
        }
        else{
            return 2;
        }
    }

    private void isSuite(MainJoueur mainJoueur) {
        ArrayList<Carte> cartesTrie = cartes;
        ArrayList<Carte> cartesSuite = new ArrayList<>();
        Collections.sort(cartesTrie, Comparator.comparingInt(Carte::getPoint));
        int pointmax = 0;
        for(Carte i : cartesTrie) {
            for (Carte j : cartesTrie) {
                if(abs(i.point-j.point) == 1){
                    if(!cartesSuite.contains(i)){
                        if(pointmax<i.point)
                            pointmax = i.point;
                        cartesSuite.add(i);
                    }

                    if(!cartesSuite.contains(j)){
                        if(pointmax<j.point)
                            pointmax = j.point;
                        cartesSuite.add(j);
                        break;
                    }

                }
            }
        }
        if(cartesSuite.size()==5){
            mainJoueur.resultCartes = cartesSuite;
            mainJoueur.pointsMain = 79+pointmax;
            mainJoueur.plusForteCombinaison = MAINS.SUITE;
        }
    }

    private void isCombinaison(MainJoueur mainJoueur) {
        ArrayList<Carte> cartesCombinaison1 = new ArrayList<>();
        ArrayList<Carte> cartesCombinaison2 = new ArrayList<>();
        for(Carte i : mainJoueur.cartes){
            for(Carte j : mainJoueur.cartes){
                if(i.point == j.point && j.couleur!=i.couleur){
                    if(cartesCombinaison1.size()>1){
                        if(cartesCombinaison1.get(0).point == j.point && !cartesCombinaison1.contains(j)){
                            cartesCombinaison1.add(j);
                        }
                        else if(!cartesCombinaison2.contains(j)&&!cartesCombinaison1.contains(j)){
                            cartesCombinaison2.add(j);
                        }
                    }
                    else if(!cartesCombinaison1.contains(j)){
                        cartesCombinaison1.add(j);
                    }
                }
            }
        }
        if(cartesCombinaison1.size() == 2){
            //Si c'est une double paire
            if(cartesCombinaison2.size() ==2){
                int compare = cartesCombinaison1.get(0).compareTo(cartesCombinaison2.get(0));
                if(compare == 0 || compare == 1)
                    mainJoueur.pointsMain = cartesCombinaison1.get(0).point+39;
                else
                    mainJoueur.pointsMain = cartesCombinaison2.get(0).point+39;
                mainJoueur.plusForteCombinaison = MAINS.DOUBLE_PAIRE;
            }
            //Si c'est un full
            else if(cartesCombinaison2.size() ==3){
                mainJoueur.pointsMain = cartesCombinaison2.get(0).point+99;
                mainJoueur.plusForteCombinaison = MAINS.FULL;
            }
            //Si c'est une paire
            else{
                mainJoueur.pointsMain = cartesCombinaison1.get(0).point+19;
                mainJoueur.plusForteCombinaison = MAINS.PAIRE;
            }
        }
        else if(cartesCombinaison1.size() == 3){
            //Si c'est un full
            if(cartesCombinaison2.size() == 2){
                mainJoueur.pointsMain = cartesCombinaison1.get(0).point+99;
                mainJoueur.plusForteCombinaison = MAINS.FULL;
            }
            //Si c'est un brelan
            else {
                mainJoueur.pointsMain = cartesCombinaison1.get(0).point+59;
                mainJoueur.plusForteCombinaison = MAINS.BRELAN;
            }
        }
        //Si c'est un carré
        else if(cartesCombinaison1.size()==4){
            mainJoueur.pointsMain = cartesCombinaison1.get(0).point+119;
            mainJoueur.plusForteCombinaison = MAINS.CARRE;
        }
        cartesCombinaison1.addAll(cartesCombinaison2);
        mainJoueur.resultCartes = cartesCombinaison1;
    }

    private void isDoublon(MainJoueur mainJoueur2) throws Exception {
        for(Carte i : cartes){
            for(Carte j : mainJoueur2.cartes){
                if(i.point == j.point&&i.couleur.equals(j.couleur)){
                    throw new Exception("La carte " + i + " est en doublon entre les mains");
                }
            }
        }
    }
    public void ajouteCarte(Carte carte) throws Exception {
        for(Carte i : cartes){
            if(i.point == carte.point&&i.couleur.equals(carte.couleur)){
                throw new Exception("La carte " + i + " est déjà existante");
            }
        }
        this.cartes.add(carte);
    }

}
