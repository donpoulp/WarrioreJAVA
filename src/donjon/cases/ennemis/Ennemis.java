package donjon.cases.ennemis;

import donjon.cases.cases.Cases;
import donjon.game.PersoMort;
import donjon.personnages.Personnages;

import java.util.Scanner;

abstract public class Ennemis implements Cases {

    //La classe Ennemis hérite de cases et est aussi en abstract. Car elle-même est une classe parent de différents type d'ennemis.

    //Attributs commun de tous les types d'ennemis.
    private String race;
    private int life;
    private int attaque;

    //Constructeur commun pour chaque ennemis. Mis en protected pour que les classes enfants l'utilise.
    protected Ennemis(String race, int life, int attaque) {
        this.race= race;
        this.life = life;
        this.attaque = attaque;
    }

    public String toString(){return race;} //Method toString sert à retourner une valeur sous forme de chaîne de caractére

    //getters
    public String getRace() {
        return race;
    }
    public int getLife() {
        return life;
    }
    public int getAttaque() {
        return attaque;
    }

    //setters
    public void setRace(String race) {
        this.race = race;
    }
    public void setLife(int life) {
        this.life = life;
    }
    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    // Method interaction inité dans la classe case
    // On définit ici quelles interaction du personnage il va y avoir avec les ennemis.
    @Override
    public void interaction(Personnages current) throws PersoMort {
        if (current != null) {
            chooseUserWhileFight(current);
        }
    }

    public void chooseUserWhileFight(Personnages current){
        displayNameOfEnnemis();
        Scanner scanner = new Scanner(System.in);
        int fightChoice = scanner.nextInt();
        switch (fightChoice) {
            case 1:
                current.setFight(true);
                break;
            case 2:
                current.setFleeAway(true);
                break;
        }
    }

    private void displayNameOfEnnemis(){System.out.println("This " + this + " want to fight \n1-Fight\n2-Flee");}

    //method boolean qui retourne la vie de l'ennemi > 0 (valeur true)
    public boolean ennemyIsAlive(){
        return this.getLife() > 0;
    }

    //Method qui modifie la vie de l'ennemi en prenant le résultat de sa vie actuelle - les points d'attaque du personnage
    public void receiveAttack(Personnages current) {
        this.setLife(this.getLife() - current.getAttaque());
    }
}
