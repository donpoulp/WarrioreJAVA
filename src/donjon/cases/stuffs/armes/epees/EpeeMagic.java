package donjon.cases.stuffs.armes.epees;

public class EpeeMagic extends Epees{

    //Constructeur qui reprend celui du parent(Epees) en spécifiant l'attribut type.
    public EpeeMagic() {
        super("Magic");
    }

    public String toString(){return this.arme + this.type ;}
}
