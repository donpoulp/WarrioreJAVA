package donjon.cases.stuffs.armes.massues;

import donjon.cases.stuffs.armes.Arme;

abstract public class Massues extends Arme {
    //Classe Massues héritant de Arme

    //Attributs communs des massues
    private String type;

    //Constructeur commun des massue utilisant le constructeur parent + l'attribut type
    protected Massues(String type){
        this("Mace",3);
        this.type = type;
    }

    //Constructeur commun des massue en utilisant le constructeur parent.
    protected Massues(String arme, int attaque) {
        super(arme, attaque);
    }


}
