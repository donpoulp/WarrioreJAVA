package donjon.personnages;

import donjon.cases.stuffs.armes.epees.EpeeOneHand;
import donjon.cases.stuffs.boucliers.Wood;
import donjon.cases.stuffs.potions.Little;
import donjon.cases.stuffs.potions.Potions;
import donjon.cases.stuffs.potions.VieMagicienException;
import donjon.cases.stuffs.sorts.Eclairs;
import donjon.cases.stuffs.sorts.Sort;

public class Magicien extends Personnages { //Attributs de la classe Guerrier
    //Class héritant de la classe Personnages.

    //Attribut commun au magicien.
    private Eclairs sort;
    private Little philtre;

    //getter
    public Eclairs getSort() {return this.sort;}
    public Little getPhiltre() {return this.philtre;}

    //setter
    public void setSort(Eclairs sort) {this.sort=sort;}
    public void setPhiltre(Little philtre) {this.philtre = philtre;}

    // Constructeur appelant parent(Personnages) en initialisant des valeurs.
    public Magicien() {
        super("Magicien", 3, 8,6,15,8,3);
        this.sort = new Eclairs();
        this.philtre = new Little();
    }

    public Magicien(String nom, int v, int f,String nameSort, String secondArme){
        super(nom,v,f,15,10,5,5);
        if(nameSort.equals("Lightning")){
            this.sort = new Eclairs();
        }
        if(secondArme.equals(" Little health potion")){
            this.philtre = new Little();
        }
    }

    // Method servant a faire des actions quand le personnage prend une potions lors de la partie.
    public void usePotion(Potions potion) throws VieMagicienException {
        if (this.getVie() + potion.getLife() > this.maxlife) {
            this.setLife(this.maxlife);
            throw new VieMagicienException();
        }else{
            this.setLife(this.getVie()+ potion.getLife());
        }
    }

    //Method servant a adapter la force du personnage selon le sort ramassé.
    public void useSpell(Sort spell){
        this.setStrength(this.defatk + spell.getAtk());
    }

    //Method toString retournant une valeur en chaîne de caractère
//    public String toString() {
//        return super.toString() + "Spell : "+getSort()+"\n____________________________\n";
//    }


}
