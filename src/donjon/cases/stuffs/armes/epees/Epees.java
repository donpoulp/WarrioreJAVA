package donjon.cases.stuffs.armes.epees;

import donjon.cases.stuffs.armes.Arme;

abstract public class Epees extends Arme {
 //Classe Epee héritant de arme.

 //Attribut communs a toutes les épees.
 private String type;

 //Constructeur commun de toutes les epees utilisant le constructeur parent(arme) + attribut commun de epee
 protected Epees(String type){
  this("Sword",5);
  this.type = type;
 }

  //Constructeur par défaut de Epee en appelant le constructeur parent.
 protected Epees(String arme,int attaque) {
  super(arme, attaque);
 }

}

