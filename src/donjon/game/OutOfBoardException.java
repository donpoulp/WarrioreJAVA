package donjon.game;

public class OutOfBoardException extends Exception{
    //Constructeur appelant le constructeur parent en initialisant une valeur en chaîne de caractère.
    public OutOfBoardException(){
        super("You WON!");
    }

}
