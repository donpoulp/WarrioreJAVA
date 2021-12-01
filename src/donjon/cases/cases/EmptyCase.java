package donjon.cases.cases;

import donjon.game.PersoMort;
import donjon.personnages.Personnages;

public class EmptyCase implements Cases{

    //Classe EmptyCase crée pour initier un plateau avec un certains nombres de cases vides avant de placer les éléments sur celui-ci

    @Override
    public String toString() {
        return "Empty case";
    }

    @Override
    public void interaction(Personnages current) throws PersoMort {
            System.out.println("You are on empty case.");
    }
}
