package donjon.personnages;

import donjon.cases.ennemis.Ennemis;
import donjon.game.PersoMort;

abstract public class Personnages {
    //Class Personnage abstract pour ne pas pouvoir instancier d'objet personnages. Et pouvoir instancier que les enfant de cette classe.

    //Attribut commun a tout les personnages.
    private String nom;
    private int vie;
    protected int attaque;
    protected int maxlife;
    protected int maxatk;
    protected int defatk;
    protected int deflife;
    private boolean fleeAway;
    private boolean isFight;

    //Constructeur commun de tous les personnages
    protected Personnages(String nom, int vie, int attaque, int maxlife, int maxatk, int defatk, int deflife) {
        this.nom = nom;
        this.vie = vie;
        this.attaque = attaque;
        this.maxlife = maxlife;
        this.maxatk = maxatk;
        this.defatk = defatk;
        this.deflife = deflife;
    }

    //getter
    public String getNom(){ return this.nom;}
    public int getVie() {return vie;}
    public int getAttaque() {return attaque;}
    public int getDefatk() {return defatk;}
    public int getDeflife(){return deflife;}
    public boolean isFleeAway() {return fleeAway;}
    public boolean isFight() {return isFight;}

    //setter
    public void setName(String nom) {this.nom = nom; }
    public void setLife(int vie) {this.vie = vie;}
    public void setStrength(int attaque) {this.attaque = attaque;}
    public void setDefatk(int defatk){this.defatk = defatk;}
    public void setFleeAway(boolean fleeAway) {this.fleeAway = fleeAway;}
    public void setFight(boolean fight) {isFight = fight;}

    //Method toString retournant une valeur en chaîne de caractère.
    @Override
    public String toString() {
        return this.getNom() + " " + this.getVie() + " " + "points of life and" + " " + this.getAttaque() + " points of attack. ";
    }

    //Method de type boolean retournant une valeur en true.
    protected boolean personnageIsAlive(){
        return this.getVie() > 0;
    }

    //Method de reception d'une attaque d'un ennemi.
    public void receiveAttack(Ennemis ennemi) throws PersoMort {
            this.setLife(this.getVie() - ennemi.getAttaque());
        if (!personnageIsAlive()){
            throw new PersoMort();
        }
    }
}
