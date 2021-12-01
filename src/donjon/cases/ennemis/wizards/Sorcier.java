package donjon.cases.ennemis.wizards;

import donjon.cases.ennemis.Ennemis;

abstract public class Sorcier extends Ennemis {
    // Classe Sorcier héritant de Ennemis

    //Attributs commun a tous les sorciers.
    private String type;

    // Constructeur appelant celui du parent en prenant des valeurs communes
    //+ l'attribut commun.
    public Sorcier(String type){
        this("Wizard",9,2);
        this.type = type;
    }

    //Appel au constructeur parent(Ennemis)
    protected Sorcier(String race, int vie, int atk) {
        super(race,vie,atk);
    }

    //Metho toString retourne une valeur en chaîne de caractére.
    @Override
    public String toString() {
        return type + "Wizard";
    }
}
