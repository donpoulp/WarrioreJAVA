package donjon.cases.ennemis.gobelins;

import donjon.cases.ennemis.Ennemis;

abstract public class Gobelins extends Ennemis {
    //Classe Gobelins héritant de la classe Ennemis.

    //Attribut commun a tous les gobelins.
    private String type;

    //Constructeur communs des gobelins utilisant le constructeur parent(Ennemis) en indiquant des valeurs communes.
    //+ l'attribut commun a tous les gobelins.
    protected Gobelins(String type){
        this("Gobelin",6,1);
        this.type = type;
    }

    //Constructeur parent
    protected Gobelins(String race, int vie, int atk) {
        super(race,vie,atk);
    }

    //Method toString qui retourne une valeur en chaîne de caractére.
    @Override
    public String toString() {
        return type + "Goblin";
    }
}
