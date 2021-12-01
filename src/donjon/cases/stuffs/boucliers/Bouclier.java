package donjon.cases.stuffs.boucliers;


import donjon.cases.cases.Cases;
import donjon.game.PersoMort;
import donjon.menu.Menu;
import donjon.personnages.Guerrier;
import donjon.personnages.Personnages;

public abstract class Bouclier implements Cases {
    //Classe bouclier héritant de Case.

    //Attribut commun a tous les boucliers
    private int defense;
    private String bouclier;
    private int defPoints;

    //Constructeur commun a tous les boucliers.
    protected Bouclier(String bouclier,int defense,int defPoints) {
        this.bouclier= bouclier;
        this.defense = defense;
        this.defPoints = defPoints;

    }

    //Getters
    public int getDefense() {
        return defense;
    }
    public String getBouclier() {
        return bouclier;
    }
    public int getDefPoints() {
        return defPoints;
    }

    //Setters
    public void setDefense(int life) {
        this.defense = life;
    }
    public void setBouclier(String bouclier) {
        this.bouclier = bouclier;
    }
    public void setDefPoints(int defPoints) {
        this.defPoints = defPoints;
    }

    //Method toString sert à retourner une valeur sous forme de chaîne de caractére
    public String toString(){return getBouclier() + "("+getDefense()+" points of defense)";}


    // interaction du personnage Guerrier sur les cases avec des objet Bouclier.
    @Override
    public void interaction(Personnages current) throws PersoMort {
        if (current instanceof Guerrier) {
            Guerrier warrior = (Guerrier)current;
            System.out.println("You find " + ((this instanceof Iron)?"a iron shield!\n":"a wood shield!"));
            int shield = Menu.getIntResult("Get shield ?\n" + " 1-Yes\n" + " 2-No");
            switch (shield) {
                case 1:
                    warrior.useShield(this);
                    System.out.println("Your points of defense is now at : "+this.getDefense());
                    break;
                case 2:
                    break;
            }

        } else {
            System.out.println("You need to be a warrior for use this shield.");
        }
    }
}
