package objet.arme.armedeguerre;

import objet.arme.Arme;

import java.awt.*;

public class EpeeLongue extends ArmeDeGuerre
{
    public EpeeLongue()
    {
        super();
    }

    @Override
    public String getNomEquipement()
    {
        return "Epée longue";
    }

    @Override
    public String toString() {
        return "EpeeLongue : " + super.toString();
    }

    @Override
    public boolean equals(Object other) {
        //Run Time Type Information!
        if (other == null || other.getClass() != getClass()) {
            return false;
        } else {
            EpeeLongue conversion = (EpeeLongue) other;
            return m_portee == conversion.m_portee && m_degats.equals(conversion.m_degats)
                    && m_vitesse == conversion.m_vitesse && m_force == conversion.m_force;


        }
    }
}
