package donjon.cases.stuffs.potions;

public class Little extends Potions {
    //Constructeur permettant la modification du nom de la potion à la création du personnage.
    public Little(String custom) {
        super(custom, 2);
    }

    //Constructeur parent en initiant des valeurs propre au potions enfants.
    public Little() {
        super(" Little health potion", 2);
    }

}
