package jouable.personnage.sorts;

import jouable.Jouable;
import jouable.personnage.Personnage;
import partie.De;

import java.util.List;

public class Guerison implements Sorts{

    public String toString(){
        return "Guérison";
    }

    public void lancer(Personnage lanceur, Personnage cible) {

        De de = new De(1, 10);

        int pvSoigne = de.jeter();

        cible.setCurrentPv(Math.min(cible.getCurrentPv() + pvSoigne, cible.getPvMax()));
    }
}
