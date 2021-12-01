package donjon.cases.stuffs.sorts;

import donjon.cases.cases.Cases;
import donjon.menu.Menu;
import donjon.personnages.Magicien;
import donjon.personnages.Personnages;

public abstract class Sort implements Cases {
    //Classe Sort hériant de la classe Case.

    //Attribut commun aux sorts.
    private String name; // Attribut de la classe Sort
    private int atk;

    //Constructeur commun des sorts
    protected Sort(String name, int atk) {
        this.name= name;
        this.atk= atk;
    }

    //Method toString retournant une valeur en chaîne de caractère.
    @Override
    public String toString() {
        return getName() + ", attack of this spell: " + getAtk();
    }

    //Getters
    public String getName() {
        return name;
    }
    public int getAtk() {
        return atk;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setAtk(int atk) {
        this.atk = atk;
    }

    //Interaction du personnage Magicien avec les cases ayant un objets Sort.
    @Override
    public void interaction(Personnages current) {
        if (current instanceof Magicien) {
            Magicien mage = (Magicien) current; //CAST pour spécifier que le personnage courant est un MAGICIEN.
            System.out.println("You find " + ((this instanceof Eclairs)?"a light!\n":"a fireball"));
            int spell = Menu.getIntResult("Get this spell ?\n" + " 1-Yes\n" + " 2-No");
            switch (spell) {
                case 1:
                    mage.useSpell(this);
                    System.out.println("Your attack is now at : "+mage.getAttaque());
                    break;
                case 2:
                    break;
            }
        }else{
            System.out.println("You need to be a wizard for use this spell.");
        }
    }
}
