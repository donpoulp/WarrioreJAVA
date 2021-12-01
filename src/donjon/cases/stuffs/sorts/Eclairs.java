package donjon.cases.stuffs.sorts;


public class Eclairs extends Sort{

    //Constructeur permettant la modification du nom du sort à la création du personnage
    public Eclairs(String custom){
        super(custom,7);
    }

    //Constructeur appelant le constructeur parent en initialisant des valeurs propre au sort.
    public Eclairs(){
        super("Lightning",2);
    }

}
