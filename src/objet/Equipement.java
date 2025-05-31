package objet;

import jouable.personnage.Personnage;

public abstract class Equipement
{
    public String getSymbole()
    {
        return "*";
    }
    public abstract void equiper(Personnage perso);
    public abstract void ajouterBonus(int bonus);
}
