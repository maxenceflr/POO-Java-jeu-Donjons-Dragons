package objet.arme.armecourante;

import jouable.personnage.Personnage;
import objet.arme.Arme;
import objet.arme.armedeguerre.EpeeLongue;
import partie.De;

public abstract class ArmeCourante extends Arme
{

    public ArmeCourante(De degats, int portee)
    {
        super(degats, portee);
    }

    public ArmeCourante()
    {
        super(new De(1, 6), 1);
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
        //Run Time Type Information!
        if (other == null || other.getClass() != getClass()) {
            return false;
        } else {
            ArmeCourante conversion = (ArmeCourante) other;
            return m_portee == conversion.m_portee && m_degats.equals(conversion.m_degats);
        }
    }
}
