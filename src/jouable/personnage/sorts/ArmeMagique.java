package jouable.personnage.sorts;

import jouable.Jouable;
import jouable.personnage.Personnage;
import objet.arme.Arme;

import java.util.List;

public class ArmeMagique implements Sorts
{
    @Override
    public String toString(){
        return "Arme magique";
    }

    public void lancer(Personnage lanceur, Personnage cible, Arme arme_cible)
    {
        if(cible.getArme().isPresent() && cible.getArme().get().equals(arme_cible))
        {
            cible.getArme().get().ajouterBonus(1);
        }
        else
        {
            cible.getInventaire().getEquipement(arme_cible).ajouterBonus(1);
        }
    }
}
