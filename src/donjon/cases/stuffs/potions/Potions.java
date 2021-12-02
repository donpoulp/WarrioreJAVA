package donjon.cases.stuffs.potions;

import donjon.cases.cases.Cases;
import donjon.menu.Menu;
import donjon.personnages.Magicien;
import donjon.personnages.Personnages;

public abstract class Potions implements Cases {
    //Class Potion héritant de la classe Case.

    //Attributs communs a toutes les potions.
    private String name;
    private int life;

    //Constructeur commun a toutes les potions
    protected Potions(String name,int life){
    this.name=name;
    this.life=life;
    }

    //Method toString retournant une valeur en chaîne de caractère.
    @Override
    public String toString() {
        return name;
    }

    //Getters
    public String getName() {
        return name;
    }
    public int getLife() {
        return life;
    }

    //Setters.
    public void setName(String name) {
        this.name = name;
    }
    public void setLife(int life) {
        this.life = life;
    }


    // interaction du personnage Magicien sur les cases ayant un objet Potions.
    @Override
    public void interaction(Personnages current) {

        if (current instanceof Magicien) {
            Magicien mage = (Magicien)current; //CAST pour spécifier que le personnage courant est un MAGICIEN.
            System.out.println("You find " + ((this instanceof Big)?"a big health potion!\n":"a little health potion"));
            int potion = Menu.getIntResult("Use potion ?\n" + " 1-Yes\n" + " 2-No");
            switch (potion) {
                case 1:
                    try {
                        mage.usePotion(this);
                        System.out.println("Your points of life is now at : "+mage.getVie());
                    }catch (VieMagicienException e){
                        System.out.println(e.getMessage() + mage.getVie());
                    }
                    break;
                case 2:
                    break;
            }

        } else {
            System.out.println("You need to be a wizard for use this potion.");
        }
    }
}
