package donjon;

import donjon.game.Game;

//    private T attribut;
//    MaClass(T monParam){
//        this.attribut=monParam;
//    }
//    public T getAttribut(){
//        return this.attribut;
//    }

//        MaClass<String> toto = new MaClass<String>("aaa");
//        toto.getAttribut();
//        MaClass<Integer> titi = new MaClass<Integer>(10);
//        titi.getAttribut();

//        ManipCollection essai = new ManipCollection();
//        essai.initList();
//        essai.searchByString("q");
//        essai.remove("y");

public class Main {
    public static void main(String[] args)  {
        Game jeu = new Game(); // On initie une variable jeu de type Menu qui prend comme valeur l'instanciation d'un nouveau Game
        jeu.menuPrincipal(); // Puis de ce nouveau menu, on appel la fonction menuPrincipal (qui se trouve dans le fichier Menu)

    }

    //Pour éviter l'utilisation du instanceof. faire des methods abstract dans perso avec en parametre une Epee ou une Eclairs.
    //Puis dans les classe Guerrier et Magicien appeler c'est method car ils héritent de personnage, pour dire ce qui va etre fait selon si c'est true ou false.
}
