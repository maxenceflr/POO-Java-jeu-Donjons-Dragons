package jouable.personnage.sorts;

import jouable.Jouable;
import jouable.personnage.Personnage;
import partie.De;

import java.util.List;

public class Guerison implements Sorts{

    public String toString(){
        return "Guérison";
    }

    @Override
    public void utiliser(Personnage lanceur, List<Jouable> cibles) {

        De de = new De(1, 10);
        int pvSoigne = de.jeter();
        Jouable cible =  cibles.getFirst();

        if (cible.getCurrentPv() + pvSoigne >= cible.getPvMax())
        {
            cible.setCurrentPv(cible.getPvMax());
        }
        else
        {
            cible.setCurrentPv(cible.getCurrentPv() + pvSoigne);
        }
    }
}
