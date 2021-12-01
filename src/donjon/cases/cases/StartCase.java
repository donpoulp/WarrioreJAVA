package donjon.cases.cases;

import donjon.game.PersoMort;
import donjon.personnages.Personnages;

public class StartCase implements Cases{

    // Classe StartCase crée pour reprendre le principe des jeux de plateaux avec une case ou se trouve tout les personnages au début.

    @Override
    public String toString() {
        return "Start Case";
    }

    @Override
    public void interaction(Personnages current) throws PersoMort {
        System.out.println("You are on start case.");
    }
}
