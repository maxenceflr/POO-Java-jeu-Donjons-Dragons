package objet.armure.armurelourde;

import objet.arme.armedeguerre.EpeeLongue;

public class CoteMailles extends ArmureLourde
{
    public CoteMailles()
    {
        super(11);
    }

    @Override
    public String getNomEquipement()
    {
        return "Cotte de mailles";
    }

    @Override
    public String toString()
    {
        return "Côte de mailles : " + super.toString();
    }

    @Override
    public boolean equals(Object other) {
        //Run Time Type Information!
        if (other == null || other.getClass() != getClass()) {
            return false;
        } else {
            CoteMailles conversion = (CoteMailles) other;
            return m_classeArmure == conversion.m_classeArmure && m_vitesse == conversion.m_vitesse;
        }
    }
}
