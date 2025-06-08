package jouable.personnage.sorts;

import jouable.ActionResult;
import jouable.Jouable;
import jouable.personnage.Personnage;
import objet.arme.Arme;

import java.util.List;

import static jouable.ActionResult.*;

public class ArmeMagique implements Sorts
{
    @Override
    public String toString(){
        return "Arme magique";
    }

    public ActionResult lancerSort( Personnage cible, Arme arme_cible)
    {
        if(cible.getArme().isPresent() && cible.getArme().get().equals(arme_cible))
        {
            cible.getArme().get().ajouterBonus(1);
            return SUCCESS;
        }
        else if(cible.getInventaire().getInventaire().contains(arme_cible))
        {
            cible.getInventaire().getEquipement(arme_cible).ajouterBonus(1);
            return SUCCESS;
        }
        return NO_ITEM;
    }
}
