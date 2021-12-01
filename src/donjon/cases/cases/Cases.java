package donjon.cases.cases;

import donjon.game.PersoMort;
import donjon.personnages.Personnages;

public interface Cases {
    // L'interface n'est pas une classe est en abstract par défaut. abstract = ce qui fait que nous ne pouvons pas instancier d'objet Cases.
    // Method abstract qui concernera les interactions du personages avec les cases du plateau.

    //Method abstract par défaut. Cette méthod sera as implémenté a tout ce qui est liée à cette interface.
    void interaction(Personnages current) throws PersoMort;
}
