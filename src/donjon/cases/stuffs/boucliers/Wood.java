package donjon.cases.stuffs.boucliers;


public class Wood extends Bouclier{
    //Constructeur parent en initiant des valeurs propre au bouclier enfants.
    public Wood() {
        super(" WoodShield",1,1);
    }

    //Constructeur parent avec possibilité de changer le nom du bouclier lors de la création du personnage.
    public Wood(String custom) {
        super(custom, 1,1);
    }

    public String toString(){return this.bouclier;}
}
