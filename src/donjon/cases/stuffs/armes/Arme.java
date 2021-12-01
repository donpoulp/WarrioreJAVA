package donjon.cases.stuffs.armes;

import donjon.cases.cases.Cases;
import donjon.cases.stuffs.armes.epees.Epees;
import donjon.menu.Menu;
import donjon.personnages.Guerrier;
import donjon.personnages.Personnages;

abstract public class Arme implements Cases {
    //Classe Arme héritant de cases

    //Attributs commun de toutes les armes
    private String arme; // Attribut de la classe Arme
    private int attaque;


    //Constructeur commun de toutes les armes.
    //Appel le constructeur parent(Case) avec en argument l'ENUM des types de case.
    protected Arme(String name,int attaque){
        this.arme=name;
        this.attaque=attaque;
    }

    //Method toString retourne une valeur en chaîne de caractère.
    public String toString(){return arme;}

    //Getters
    public String getArme() {
        return arme;
    }
    public int getAttaque() {
        return attaque;
    }

    //Setters
    public void setArme(String arme) {
        this.arme = arme;
    }
    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    //Interaction du personnage selon le type d'arme et si Guerrier ou non
    @Override
    public void interaction(Personnages current) {
        if (current instanceof Guerrier) {
            Guerrier warrior = (Guerrier)current;
            System.out.println("You find " + ((this instanceof Epees)?"a sword!\n":"a mace"));
            int potion = Menu.getIntResult("Get this weapon ?\n" + " 1-Yes\n" + " 2-No");
            switch (potion) {
                case 1:
                        warrior.useWeapon(this);
                        System.out.println("Your attack is now at : "+warrior.getAttaque());
                    break;
                case 2:
                    break;
            }
        }else{
            System.out.println("You need to be a warrior for use this weapon.");
        }
    }

}
