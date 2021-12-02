package donjon.game;

import donjon.Bdd;
import donjon.cases.ennemis.Ennemis;
import donjon.menu.Menu;
import donjon.personnages.Personnages;
import donjon.personnages.Guerrier;
import donjon.personnages.Magicien;

import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    //Attribut spécifique a la class GAME
    private final Plateau plateau;
    private final Scanner scanner;
    private final ArrayList<Guerrier> warriorsList;
    private final ArrayList<Magicien> wizardsList;

    //Constructeur lors de l'instanciation d'une nouvelle game
    public Game(){
        this.plateau = new Plateau();
        this.scanner = new Scanner(System.in);

        this.warriorsList = Bdd.getWarrior();
        this.wizardsList = Bdd.getWizard();
    }

    //Method qui retourne une "interaction" avec l'utilisateur en lui proposant un menu avec plusieurs choix.
    public void menuPrincipal() {
        boolean selectMenuPrincipal = true; // On initie une variable selectCondition de type boolean avec la valeur TRUE
         do{ // On initialise une boucle WHILE
            int createCharacter = Menu.getIntResult("Principal menu :\n1-Create a character\n2-Show all characters\n3-Delete character\n4-Verify existence of character\n5-Start game\n6-Left the game"); // On déclare la variable selector de type INT avec comme valeur l'attente d'un entier pour la variable scanner
            switch (createCharacter) { // On initialise un switch avec la variable selector (qui est un INT)
                case 1: //Si l'utilisateur tape 1 alors on déclare une nouvelle variable clavier de type Scanner avec comme valeur un nouveau Scanner
                    Menu.createCharacter(warriorsList,wizardsList);
                    break;
                case 2: //Si la réponse est 2 au switch SELECTOR alors on print une chaîne de caractére qui montre les données stockées dans les deux list des personnages
                    Menu.showAllLists(warriorsList,wizardsList);
                    break;
                case 3:
                    Menu.deleteCharacter();
                    break;
                case 4:
                    Menu.searchByName();
                    break;
                case 5: //Si la réponse est 3 alors on appel la method start()
                    startGame();
                    break;
                case 6: //Si la réponse est 4 alors on print une chaîne de caractére, la condition du while est passer à false et le programme s'arrête.
                    selectMenuPrincipal = false;
                    break;
            }
        }while(selectMenuPrincipal);
    }

    //Method qui retourne les fonctionnalités quand l'utilisateur choisis de lancée une pârtie.
    private void startGame() {
        Personnages mySelect;

        if (warriorsList.isEmpty() && wizardsList.isEmpty()) {
            System.out.println("Lists of characters are empty");
        } else {
            mySelect = Menu.getPersonnages(warriorsList,wizardsList);
            try {
                play(mySelect);
            }catch (OutOfBoardException | PersoMort e){
                System.out.println(e.getMessage());
                Menu.resetStatListPerso(warriorsList,wizardsList);
            }
        }
    }

    //Method qui retourne des fonctionalités quand la partie est lancée après avoir selectionner un personnage au préalable.
    public void play(Personnages mySelect) throws OutOfBoardException, PersoMort {
        int positionJoueur = 0;

        System.out.println("Game is starting\n" + mySelect.getNom() + " is on case : " + positionJoueur + "/" + plateau.sizePlateau());
        System.out.println(plateau.caseInfo(positionJoueur));

        while (plateau.sizePlateau() > positionJoueur && mySelect.getVie() > 0) {

            boolean continu = false;

            if (mySelect.isFleeAway()){
                positionJoueur -= (Math.random() * 6) + 1;
                displayCharacterPositionAndInteract(mySelect,positionJoueur);
                mySelect.setFleeAway(false);
            }


            System.out.println("Roll?\n  1-Yes\n  2-No");
            int response = scanner.nextInt();
            switch (response) {
                case 1:
                    continu = true;
                    break;
                case 2:
                    System.exit(0);
                    break;
            }

            if (continu) {
                positionJoueur += (Math.random() * 6) + 1;
                if (positionJoueur >= plateau.sizePlateau()) {
                    throw new OutOfBoardException();
                }
            }
            if (mySelect.getVie() <= 0){
                throw new PersoMort();
            }
            displayCharacterPositionAndInteract(mySelect,positionJoueur);
            if (mySelect.isFight()){
                fight((Ennemis) plateau.getObject(positionJoueur), mySelect);
                mySelect.setFight(false);
            }
        }
    }

    //Method qui retourne l'interaction du joueur selon la case ou il se trouve.
    private void displayCharacterPositionAndInteract(Personnages mySelect, int positionJoueur) throws PersoMort {
        System.out.println("Now " + mySelect.getNom() + " is on : " + positionJoueur + "/" + plateau.sizePlateau() + "\n" + plateau.caseInfo(positionJoueur));
            this.plateau.interaction(positionJoueur, mySelect);
    }

    //Method qui retourne les fonctionanlités de combat entre les ennemis et le personnages.
    private void fight(Ennemis ennemi, Personnages current) throws PersoMort {
        while (ennemi.getLife() > 0) {
            ennemi.receiveAttack(current);
            System.out.println( ennemi.getRace()+" have now : " + ennemi.getLife() + " points of life");
            if (ennemi.ennemyIsAlive()){
                System.out.println("This "+ennemi.getRace()+" is now attacking you");
                current.receiveAttack(ennemi);
                System.out.println("This "+ennemi.getRace()+" hit "+current.getNom() + " and you have now : " + current.getVie() + " points of life");
                ennemi.chooseUserWhileFight(current);
            }
        }
        System.out.println("This "+ennemi.getRace() + " is dead!\nYou has still : "+current.getVie()+" points of life.");
    }
}
