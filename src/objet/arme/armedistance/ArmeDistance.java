package objet.arme.armedistance;

import jouable.personnage.Personnage;
import objet.arme.Arme;
import partie.De;

public abstract class ArmeDistance extends Arme
{
    public ArmeDistance(De degats, int portee)
    {
        super(degats, portee);
    }

    public ArmeDistance()
    {
        super();
    }

    public void equiper(Personnage perso)
    {
        perso.setArme(this);
    }
    @Override
    public String toString()
    {
        return super.toString();
    }
}
