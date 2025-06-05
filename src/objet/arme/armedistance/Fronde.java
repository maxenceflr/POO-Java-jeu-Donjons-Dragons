package objet.arme.armedistance;

import objet.arme.Arme;
import partie.De;

public class Fronde extends ArmeDistance
{
    public Fronde()
    {
        super(new De(1, 4), 6);
    }

    @Override
    public String getNomEquipement()
    {
        return "Fronde";
    }

    @Override
    public String toString() {
        return "Fronde : " + super.toString();
    }

    @Override
    public boolean equals(Object other) {
        //Run Time Type Information!
        if (other == null || other.getClass() != getClass()) {
            return false;
        } else {
            Fronde conversion = (Fronde) other;
            return m_portee == conversion.m_portee && m_degats.equals(conversion.m_degats);
        }
    }
}
