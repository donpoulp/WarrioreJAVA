package donjon.menu;

import donjon.Bdd;
import donjon.cases.stuffs.armes.epees.EpeeOneHand;
import donjon.cases.stuffs.boucliers.Wood;
import donjon.cases.stuffs.potions.Little;
import donjon.cases.stuffs.sorts.Eclairs;
import donjon.personnages.*;

import java.util.ArrayList;
import java.util.Scanner;


public class Menu  {
    //Attribut spécifique a la classe Menu
    private static final Scanner scanner = new Scanner(System.in);


    private static String getResult(String question) {
        System.out.println(question);
        return scanner.next();
    }

    public static int getIntResult(String question) {
        try {
            return Integer.parseInt(getResult(question));
        } catch (NumberFormatException e) {
            return getIntResult(question);
        }
    }

    private static String getStringResult(String question){
        String a = getResult(question);
        try{
            Integer.parseInt(a);
        }catch (NumberFormatException e){
            return a;
        }
        return getStringResult(question);
    }

    //Methods qui retourne l'instanciation d'un objet
    public static Guerrier createWarrior(){
        return new Guerrier();
    }
    public static Magicien createWizard(){
        return new Magicien();
    }

    //Method qui retourne les fonctionnalités du menu de création d'un personnage.
    public static void createCharacter(ArrayList<Guerrier> warriorsList, ArrayList<Magicien> wizardsList) {
        int create = getIntResult("Select character : \n1 for Warrior\n2 for Wizard\n3 for left the game"); //// On déclare la variable selector1 de type INT avec comme valeur l'attente d'un entier pour la variable clavier
        switch (create) { // On initialise un nouveau switch
            case 1: //Si la réponse est 1 alors on print une chaîne de caractére
                warriorSelect(warriorsList);
                break;
            case 2: //Si la réponse est 2 alors on print une chaîne de caractére
                wizardSelect(wizardsList);
                break;
            case 3: //Si la réponse est 3 alors on print une chaîne de caractére et on stop le programme
                System.out.println("Left the game");
                System.exit(0);
                break;
        }
    }

    //Method qui retourne les fonctionnalités si l'on choisi de crée un guerrier
    private static void warriorSelect(ArrayList<Guerrier> warriorsList) {
        Guerrier perso = createWarrior();
        System.out.println("Warrior selected");
        warriorsList.add(perso); //On ajoute ce nouveau Guerrier stocké dans la variable warrior a la liste warriorsList
        selection(perso, true); //On appel la méthode selection de la class Guerrier
    }

    //Method qui retourne les fonctionnalités si l'on choisi de crée un magicien
    private static void wizardSelect(ArrayList<Magicien> wizardsList) {
        Magicien perso = createWizard();
        System.out.println("Wizard selected");
        wizardsList.add(perso); //On ajoute ce nouveau Magicien stocké dans la variable wizard a la liste wizardsList
        selection(perso, false); //On appel la méthode selection de la class Magicien
    }



    private static void selection(Personnages perso, boolean isWarrior) {
        menuAfterSelection(perso, isWarrior);
    }

    public static Personnages getPersonnages(ArrayList<Guerrier> warriorsList, ArrayList<Magicien> wizardsList) {
        Personnages mySelect;
        System.out.println("Choose your character\n" + "1 for warrior\n" + "2 for wizard");
        mySelect = selectTypeOfCharacter(warriorsList,wizardsList);
        return mySelect;
    }

    //Method permettant de retourner un menu afin de selectionner le type de personnage que l'on veux créer.
    private static Personnages selectTypeOfCharacter(ArrayList<Guerrier> warriorsList, ArrayList<Magicien> wizardsList) {
        Personnages mySelect;
        int selectCharacter = scanner.nextInt();
        switch (selectCharacter) {
            case 1:
                mySelect = warriorSelected(warriorsList);
                break;
            case 2:
                mySelect = wizardSelected(wizardsList);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + selectCharacter);
        }
        return mySelect;
    }

    //Method qui retourne les fonctionnalités si l'on choisit de selectionner un guerrier pour jouer unbe partie
    private static Personnages warriorSelected(ArrayList<Guerrier> warriorsList) {
        Personnages mySelect;
        System.out.println("Select a warrior :\n");
        for (int i = 0; i < warriorsList.size(); i++) {
            System.out.println("Warrior : " + i + " : " + warriorsList.get(i));
        }
        System.out.println("Enter a number");
        int selectWarrior = scanner.nextInt();
        mySelect = warriorsList.get(selectWarrior);
        System.out.println("Your selection : " + mySelect);
        return mySelect;
    }

    //Method qui retourne les fonctionnalités si l'on choisit de selectionner un magicien pour jouer unbe partie
    private static Personnages wizardSelected(ArrayList<Magicien> wizardsList) {
        Personnages mySelect;

        System.out.println("Select a wizard ?");
        for (int i = 0; i < wizardsList.size(); i++) {
            System.out.println("Wizard : " + i + " : " + wizardsList.get(i));
        }
        System.out.println("Enter a number");
        int selectWizard = scanner.nextInt();
        mySelect = wizardsList.get(selectWizard);
        System.out.println("Your selection : " + mySelect);
        return mySelect;
    }

    //Method qui retourne la visibilité des listes de personnages guerrier et magicien.
    public static void showAllLists(ArrayList<Guerrier> warriorsList, ArrayList<Magicien> wizardsList) {
        System.out.println("All warriors : \n" + warriorsList + "\nAll wizards : \n" + wizardsList);
    }

    public static void deleteCharacter(){
        Bdd.getHeroes();
        System.out.println("Write id what you want to delete.");
        Scanner test = new Scanner(System.in);
        int id = test.nextInt();
        Bdd.delHeroes(id);
    }

    public static void searchByName(){
        Bdd.getHeroes();
        System.out.println("Write name what you want.");
        Scanner test = new Scanner(System.in);
        String name = test.nextLine();
        Bdd.verifyCharacterByName(name);
    }


    //Method qui retourne les fonctionnalités pour donne run nom au type de personnage choisit + menu proposant des choix a l'utilisateur.
    public static void menuAfterSelection(Personnages perso, boolean isWarrior) {
        boolean menuAfterSelectionCharacter = true;
        System.out.println("Enter name of the " + (isWarrior ? "warrior" : "wizard"));

        Scanner clavier = new Scanner(System.in);
        String name = clavier.nextLine();
        if (!name.equals("")) {
            perso.setName(name);
            if (isWarrior) {
                Bdd.addWarrior(null, "Guerrier", perso.getNom(), perso.getDeflife(), perso.getDefatk(), ((Guerrier) perso).getArme(), ((Guerrier) perso).getShield());
            }else{
                Bdd.addWizard(null, "Magicien", perso.getNom(), perso.getDeflife(), perso.getDefatk(), ((Magicien) perso).getSort(), ((Magicien) perso).getPhiltre());

            }
        }


        do{
            System.out.println("___________________________" + "\n" + "Change" + (isWarrior ? " warrior's" : " wizard's") + "attributes: \n1 for change parameters\n2 for show your character\n3 for back to the first menu" + "\n___________________________\n");

            int change = clavier.nextInt();
            clavier.nextLine();
            switch (change) {
                case 1:
                    setParameters(perso, isWarrior, clavier);
                    break;
                case 2:
                    showCharacter(perso, isWarrior);
                    break;
                case 3:
                    System.out.println("Principal menu");
                    menuAfterSelectionCharacter = false;
                    break;
            }
        }while (menuAfterSelectionCharacter);
    }

    //Method permettant d'appeler plusieurs methods à la suite pour modifier les spécificitées du personnage créer.
    private static void setParameters(Personnages perso, boolean isWarrior, Scanner clavier) {
        setLife(perso, isWarrior);
        setStrength(perso, isWarrior);
        setWeapon(perso, isWarrior);
        setSecondary(perso, isWarrior, clavier);
    }
    //Method permettant de changer les points de vie du personnage que l'on a créer.
    private static void setLife(Personnages perso, boolean isWarrior) {
        int life = getIntResult("Enter number for points of life " + (isWarrior ? "(between 5 and 10)" : "(between 3 and 6)"));
        if (isWarrior) {
            while (life < 5 || life > 10) {
                life= getIntResult("Enter a good value (between 5 and 10)");
            }
        }
        if (!isWarrior) {
            while (life < 3 || life > 6) {
                life= getIntResult("Enter a good value (between 3 and 6)");
            }
        }
        perso.setLife(life);
    }
    //Method permettant de changer les points de force du personnage que l'on a créer.
    private static void setStrength(Personnages perso, boolean isWarrior){
        int atkk = getIntResult("Enter number for attack's points" + ((isWarrior) ? "(between 5 and 10)" : "(between 8 and 15)"));
        if (isWarrior) {
            while (atkk < 5 || atkk > 10) {
                atkk= getIntResult("Enter a good value (between 5 and 10)");
            }
        }
        if (!isWarrior) {
            while (atkk < 8 || atkk > 15) {
                atkk= getIntResult("Enter a good value (between 8 and 15)");
            }
        }
        perso.setStrength(atkk);
    }
    //Method permettant de changer le nom de l'arme ou du sort selon le personnage que l'on a créer.
    private static void setWeapon(Personnages perso, boolean isWarrior) {
        String firstWeapon = getStringResult("Enter name for " + (isWarrior ? "weapon" : "sort") + " or press enter if you don't need");
        if (!firstWeapon.equals("")) {
            if (isWarrior) {
                ((Guerrier) perso).setWeapon(new EpeeOneHand(firstWeapon));
            } else {
                ((Magicien) perso).setSort(new Eclairs(firstWeapon));
            }
        }
    }
    //Method permettant de changer le nom du bouclier ou de la potion selon le personnage que l'on a créer.
    private static void setSecondary(Personnages perso, boolean isWarrior, Scanner clavier) {
        System.out.println("Enter name for " + (isWarrior ? "shield" : "potion") + " or press enter if you don't need");
        String secondWeapon = clavier.nextLine();
        if (!secondWeapon.equals("")) {
            if (isWarrior) {
                ((Guerrier) perso).setShield(new Wood(secondWeapon));
            } else {
                ((Magicien) perso).setPhiltre(new Little(secondWeapon));
            }
        }
    }

    //Method qui retourne les informations du personnages que l'on a créer.
    private static void showCharacter(Personnages perso, boolean isWarrior) {
        System.out.println("Your's modifications :" + " " + perso.getNom() + " " + "with " + perso.getVie() + " " + "points of life and" + " " + perso.getAttaque() + " points of attack." +
                (isWarrior ?" Weapon :"+ ((Guerrier) perso).getArme() + " with " + ((Guerrier) perso).getShield() + "\n____________________________" :  " Spell :"+((Magicien) perso).getSort() +"\n____________________________"));
    }

    //Method permettant la réinitialisation des stats de tous les personnages de chaque liste avevc des stats minimal par défaut.
    public static void resetStatListPerso(ArrayList<Guerrier> warriorsList, ArrayList<Magicien> wizardsList){
        if(!warriorsList.isEmpty()){
            for (Guerrier guerrier : warriorsList) {
                guerrier.setStrength(guerrier.getDefatk());
                guerrier.setLife(guerrier.getDeflife());
            }
        }else{
            for (Magicien magicien : wizardsList) {
                magicien.setStrength(magicien.getDefatk());
                magicien.setLife(magicien.getDeflife());
            }
        }
    }
}
