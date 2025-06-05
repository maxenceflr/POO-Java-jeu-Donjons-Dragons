package objet.arme.armedistance;

import partie.De;

public class ArcCourt extends ArmeDistance
{
    public ArcCourt()
    {
        super(new De(1, 6), 16);
    }

    @Override
    public String getNomEquipement()
    {
        return "Arc court";
    }


    @Override
    public String toString() {
        return "Arc Court : " + super.toString();
    }

    @Override
    public boolean equals(Object other) {
        //Run Time Type Information!
        if (other == null || other.getClass() != getClass()) {
            return false;
        } else {
            ArcCourt conversion = (ArcCourt) other;
            return m_portee == conversion.m_portee && m_degats.equals(conversion.m_degats);
        }
    }
}
