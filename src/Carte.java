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
    @Override
    public String toString(){
        return "Le " + this.title + " de " + this.couleur + " vaut " + this.point + " points!";
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
