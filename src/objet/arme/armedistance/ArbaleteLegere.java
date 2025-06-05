package objet.arme.armedistance;

import partie.De;

public class ArbaleteLegere extends ArmeDistance
{
    public ArbaleteLegere()
    {
        super(new De(1, 8), 16);
    }

    @Override
    public String getNomEquipement()
    {
        return "Arbalète Légère";
    }

    @Override
    public String toString() {
        return "ArbalèteLégère : " + super.toString();
    }

    @Override
    public boolean equals(Object other) {
        //Run Time Type Information!
        if (other == null || other.getClass() != getClass()) {
            return false;
        } else {
            ArbaleteLegere conversion = (ArbaleteLegere) other;
            return m_portee == conversion.m_portee && m_degats.equals(conversion.m_degats);
        }
    }
}
