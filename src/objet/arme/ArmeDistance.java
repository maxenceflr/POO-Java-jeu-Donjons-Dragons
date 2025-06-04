package objet.arme;

import jouable.personnage.Personnage;
import partie.De;

public class ArmeDistance extends Arme
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
