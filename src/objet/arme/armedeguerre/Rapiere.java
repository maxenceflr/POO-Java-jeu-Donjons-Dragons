package objet.arme.armedeguerre;

import objet.arme.armedistance.ArbaleteLegere;

public class Rapiere extends ArmeDeGuerre
{
    public Rapiere()
    {
        super();
    }

    @Override
    public String getNomEquipement()
    {
        return "Rapière";
    }

    @Override
    public String toString() {
        return "Rapière : " + super.toString();
    }

    @Override
    public boolean equals(Object other) {
        //Run Time Type Information!
        if (other == null || other.getClass() != getClass()) {
            return false;
        } else {
            Rapiere conversion = (Rapiere) other;
            return m_portee == conversion.m_portee && m_degats.equals(conversion.m_degats) &&
                    m_vitesse == conversion.m_vitesse &&
                    m_force == conversion.m_force;
        }
    }
}
