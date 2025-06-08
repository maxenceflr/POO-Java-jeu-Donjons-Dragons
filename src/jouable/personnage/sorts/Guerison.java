package jouable.personnage.sorts;

import jouable.ActionResult;
import jouable.Jouable;
import jouable.personnage.Personnage;
import partie.De;

import java.util.List;

public class Guerison implements Sorts{

    public String toString(){
        return "Guérison";
    }

    public ActionResult lancer(Personnage lanceur, Personnage cible, int pvSoigne)
    {
        cible.setCurrentPv(Math.min(cible.getCurrentPv() + pvSoigne, cible.getPvMax()));
        return ActionResult.SUCCESS;
    }
}
