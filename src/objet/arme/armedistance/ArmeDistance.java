package objet.arme.armedistance;

import jouable.personnage.Personnage;
import objet.arme.Arme;
import objet.arme.armedeguerre.ArmeDeGuerre;
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
        if(perso.getArme().isPresent())
        {
            perso.getInventaire().ajouterEquipement(perso.getArme().get());
        }
        perso.setArme(this);
    }

    @Override
    public String toString()
    {
        return super.toString();
    }

    @Override
    public boolean equals(Object other)
    {
        if (other == null || other.getClass() != getClass()) {
            return false;
        } else {
            ArmeDistance conversion = (ArmeDistance) other;
            return m_portee == conversion.m_portee && m_degats.equals(conversion.m_degats);
        }
    }
}
