package donjon.cases.stuffs.armes.epees;

public class EpeeOneHand extends Epees{
    //Constructeur qui reprend celui du parent(Epees) en spécifiant l'attribut type.
    public EpeeOneHand() {
        super("Little");
    }

    //Constrcuteur permettant de modifier le nom de l'arme par l'utilisateur lors de la création du personnage.
    public EpeeOneHand(String custom){
        super(custom);
    }
}
