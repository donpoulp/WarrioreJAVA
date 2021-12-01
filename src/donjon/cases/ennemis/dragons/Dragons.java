package donjon.cases.ennemis.dragons;

import donjon.cases.ennemis.Ennemis;


abstract public class Dragons extends Ennemis {
    //Classe dragon hérite d'Ennemis et est aussi abstract car il y a plusieurs types de dragons.

    //Attribut commun a tous les dragons.
    private String element;

    //Constructeurs commun a tous les dragons qui reprend le constrcuteur parent avec des valeurs communes.
    // + l'attribut commun des dragons qui est l'element.
    protected Dragons(String element){
        this("Dragon",15,4);
        this.element = element;
    }

    //Constructeur parent (Ennemis)
    protected Dragons(String race, int life, int attaque) {
        super(race,life,attaque);
    }

    //Methode toString qui retourne une valeur en chaîne de caractére.
    @Override
    public String toString() {
        return element + "Dragon";
    }

}
