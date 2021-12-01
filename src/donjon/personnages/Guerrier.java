package donjon.personnages;

import donjon.cases.ennemis.Ennemis;
import donjon.cases.stuffs.boucliers.Bouclier;
import donjon.cases.stuffs.armes.Arme;
import donjon.cases.stuffs.armes.epees.EpeeOneHand;
import donjon.cases.stuffs.boucliers.Wood;
import donjon.game.PersoMort;


public class Guerrier extends Personnages {
    //Class Guerrier hériant de Personnages.

    //Atrtibut commun a tous les guerriers.
    private EpeeOneHand arme; //Attributs de la classe Guerrier
    private Bouclier bouclier;

    //getter
    public Bouclier getShield(){return this.bouclier;}
    public EpeeOneHand getArme(){return this.arme;}

    //setter
    public void setWeapon(EpeeOneHand arme) {this.arme = arme;}
    public void setShield(Bouclier bouclier) {this.bouclier = bouclier;}

    //Constructeur parent(Personnages) avec des valeurs initier.
    public Guerrier() {
        super("Bob",5,5,15,10,5,5);
        this.arme = new EpeeOneHand();
        this.bouclier = new Wood();
    }

    //Method toString retournant une valeur en chaîne de caractère.
    public String toString() {
        return super.toString() +"Weapon : "+ getArme() +" with "+getShield()+",\n";
    }

    //Method pour modifier la force du Guerrier selon l'arme ramassée.
    public void useWeapon(Arme arme){
            this.setStrength(this.defatk + arme.getAttaque());
    }

    //Method pour modifier la defense du bouclier.
    public void useShield(Bouclier bouclier){
            bouclier.setDefense(bouclier.getDefPoints());
    }

    //Method recevoirAttaque d'un ennemi.
    public void receiveAttack(Ennemis ennemi) throws PersoMort {
        this.setLife(this.getVie() - (ennemi.getAttaque()- bouclier.getDefPoints()));
        if (!personnageIsAlive()){
            throw new PersoMort();
        }
    }
}
