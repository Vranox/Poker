public class Carte {
    String title;
    int point;
    COULEUR couleur;

    public Carte(String input) {
        //Interprétation de la couleur de la carte entré en input
        String strCouleur =  input.substring(input.length()-2);
        switch (strCouleur) {
            case "Tr" -> this.couleur = COULEUR.TREFLE;
            case "Pi" -> this.couleur = COULEUR.PIQUE;
            case "Co" -> this.couleur = COULEUR.COEUR;
            case "Ca" -> this.couleur = COULEUR.CARREAU;
            default -> this.couleur = null;
        }
        //Interprétation de la valeur de la carte
        String valeurCarte = input.substring(0,input.length()-2);
        if(isNumeric(valeurCarte)){
            this.point = Integer.parseInt(valeurCarte);
            this.title = Integer.toString(this.point);
        }
        else{
            switch (valeurCarte) {
                case "A" -> {
                    this.point = 14;
                    this.title = "As";
                }
                case "R" -> {
                    this.point = 13;
                    this.title = "Roi";
                }
                case "D" -> {
                    this.point = 12;
                    this.title = "Dame";
                }
                case "V" -> {
                    this.point = 11;
                    this.title = "Valet";
                }
                default -> this.point = 0;
            }
        }


    }
    /*
    La méthode permet de comparer deux cartes entre elles et retourne :
        - 0 : si les deux cartes sont égales
        - 1 : si this est supérieur à la carte entrée en paramètre
        - 2 : si this est inférieur à la carte entrée en paramètre
     */
    public int compareTo(Carte carte2){
        if(this.point> carte2.point){
            return 1;
        } else if (this.point< carte2.point) {
            return 2;
        }
        else{
            return 0;
        }
    }
    @Override
    public String toString(){
        return this.title + " de " + this.couleur;
    }
    public boolean isNumeric(String string){
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
