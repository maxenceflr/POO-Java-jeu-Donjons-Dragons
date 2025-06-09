package objet;

import donjon.Position;
import jouable.personnage.Personnage;
import objet.arme.armedeguerre.EpeeLongue;
import objet.armure.armurelourde.CoteMailles;

public abstract class Equipement
{
    public String getSymbole()
    {
        return "*";
    }
    public abstract void equiper(Personnage perso);
    public abstract void ajouterBonus(int bonus);
    public abstract String getNomEquipement();
    public abstract String getTypeClass();

    @Override
    public abstract boolean equals(Object other);
}
