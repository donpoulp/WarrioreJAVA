package donjon.game;

import donjon.cases.cases.Cases;
import donjon.cases.cases.EmptyCase;
import donjon.cases.cases.StartCase;
import donjon.cases.ennemis.dragons.LightningDragon;
import donjon.cases.ennemis.gobelins.GobelinGeant;
import donjon.cases.ennemis.gobelins.GobelinMalefique;
import donjon.cases.ennemis.gobelins.GobelinMutant;
import donjon.cases.ennemis.dragons.FireDragon;
import donjon.cases.ennemis.dragons.IceDragon;
import donjon.cases.ennemis.dragons.WaterDragon;
import donjon.cases.ennemis.gobelins.GobelinNain;
import donjon.cases.ennemis.wizards.Gandalf;
import donjon.cases.ennemis.wizards.Saruman;
import donjon.cases.ennemis.wizards.Sauron;
import donjon.cases.ennemis.wizards.Voldemort;
import donjon.cases.stuffs.armes.epees.EpeeLong;
import donjon.cases.stuffs.armes.epees.EpeeMagic;
import donjon.cases.stuffs.armes.epees.EpeeOneHand;
import donjon.cases.stuffs.armes.massues.MassueLegere;
import donjon.cases.stuffs.armes.massues.MassueLourde;
import donjon.cases.stuffs.armes.massues.MassueMagik;
import donjon.cases.stuffs.boucliers.Iron;
import donjon.cases.stuffs.boucliers.Wood;
import donjon.cases.stuffs.potions.Big;
import donjon.cases.stuffs.potions.Little;
import donjon.cases.stuffs.sorts.Eclairs;
import donjon.cases.stuffs.sorts.Fireball;
import donjon.personnages.Personnages;

import java.util.ArrayList;
import java.util.Collections;

public class Plateau{
    //Attribut spécifique a la classe plateau
    private ArrayList<Cases> plateau = new ArrayList<>();

    //Constructeur servant a l'instanciation d'un plateau.
    public Plateau(){
        initPlateau();
    }

    //Method qui initialise un plateau et est utilisée dans le constructeur.
    public void initPlateau() {
        for (int i = 0; i < 64; i++) {
            plateau.add(new EmptyCase());
        }
        allPlace();
    }

    //Methode qui retourne la taille du plateau.
    public int sizePlateau(){
        return plateau.size();
    }

    //Method qui retourne une chaîne de caractère en utilisant la method toString a la suite du get index du plateau.
    public String caseInfo(int i){
        return plateau.get(i).toString();
    }

    //Method retournant une interaction selon l'index du plateau et le personnages
    public void interaction(int i, Personnages current) throws PersoMort {
        plateau.get(i).interaction(current);
    }

    //Method qui retourne l'objet selon l'index du plateau.
    public Object getObject(int i){return plateau.get(i);}

    //Method généraliste qui appel toutes les fonctions ou l'on initialise des objets à des index précis du tableau.
    //Cette méthod est aussi appelé dans le constructeur avoir avoir former un plateau de case vide.
    public void allPlace(){
        startPlace();
        dragonPlace();
        wizardPlace();
        gobelinsPlace();
        macePlace();
        swordPlace();
        eclairPlace();
        fireballPlace();
        standardPotionPlace();
        bigPotionPlace();
        ironShieldPlace();
        woodShieldPlace();
        swap();
    }

    //Methods pour initialiser différents objets à différents index du plateau.
    public void startPlace(){
        plateau.set(0, new StartCase());
    }

    public void dragonPlace(){
        plateau.set(45,new IceDragon());
        plateau.set(52,new WaterDragon());
        plateau.set(56,new FireDragon());
        plateau.set(62,new LightningDragon());
    }
    public void wizardPlace(){
        plateau.set(10,new Gandalf());
        plateau.set(20,new Sauron());
        plateau.set(25,new Saruman());
        plateau.set(32,new Voldemort());
        plateau.set(35,new Gandalf());
        plateau.set(36,new Voldemort());
        plateau.set(37,new Saruman());
        plateau.set(40,new Voldemort());
    }
    public void gobelinsPlace(){
        plateau.set(3,new GobelinMalefique());
        plateau.set(6,new GobelinNain());
        plateau.set(9,new GobelinGeant());
        plateau.set(12,new GobelinMutant());
        plateau.set(15,new GobelinGeant());
        plateau.set(18,new GobelinNain());
        plateau.set(21,new GobelinMutant());
        plateau.set(24,new GobelinMalefique());
    }
    public void macePlace(){
        plateau.set(18,new MassueLegere());
        plateau.set(21,new MassueLourde());
        plateau.set(24,new MassueLegere());
        plateau.set(27,new MassueLourde());
        plateau.set(30,new MassueMagik());
    }
    public void swordPlace(){
        plateau.set(19,new EpeeMagic());
        plateau.set(26,new EpeeOneHand());
        plateau.set(42,new EpeeLong());
        plateau.set(53,new EpeeMagic());
    }
    public void eclairPlace(){
        plateau.set(1,new Eclairs());
        plateau.set(4,new Eclairs());
        plateau.set(8,new Eclairs());

    }
    public void fireballPlace(){
        plateau.set(48,new Fireball());
        plateau.set(49,new Fireball());
    }
    public void standardPotionPlace(){
        plateau.set(7,new Little());
        plateau.set(13,new Little());
        plateau.set(31,new Little());
        plateau.set(33,new Little());
        plateau.set(39,new Little());
        plateau.set(43,new Little());
    }
    public void bigPotionPlace(){
        plateau.set(28,new Big());
        plateau.set(41,new Big());
    }
    public void ironShieldPlace(){
        plateau.set(17,new Iron());
        plateau.set(23,new Iron());
        plateau.set(27,new Iron());
    }
    public void woodShieldPlace(){
        plateau.set(44,new Wood());
        plateau.set(47,new Wood());
        plateau.set(30,new Wood());
    }

    //Method permettant de melanger le plateau pour en voir un différent à chaque partie lancée.
    public void swap(){
        for (int i=0;i<100;i++) {
            int firstIndex = (int) ((Math.random() * 62) + 1);
            int secondIndex = (int) ((Math.random() * 62) + 1);
            Collections.swap(plateau, firstIndex, secondIndex);
        }
    }
}
