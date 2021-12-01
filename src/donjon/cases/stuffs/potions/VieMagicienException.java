package donjon.cases.stuffs.potions;

public class VieMagicienException extends Exception{
    //Constructeur appelant simplement le constructeur parent avec une chaîne de caractère comme valeur.
    public VieMagicienException(){
        super("You don't use this potion in entire potential, because your life is too big.\nYour points of life is now at : ");
    }
}
