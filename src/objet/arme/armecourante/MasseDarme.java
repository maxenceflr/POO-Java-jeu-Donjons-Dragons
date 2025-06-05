package objet.arme.armecourante;

public class MasseDarme extends ArmeCourante
{
    public MasseDarme()
    {
        super();
    }

    @Override
    public String getNomEquipement()
    {
        return "Masse d'arme";
    }

    @Override
    public String toString()
    {
        return "Masse d'arme : " + super.toString();
    }

    @Override
    public boolean equals(Object other)
    {
        //Run Time Type Information!
        if (other == null || other.getClass() != getClass()) {
            return false;
        } else {
            MasseDarme conversion = (MasseDarme) other;
            return m_portee == conversion.m_portee && m_degats.equals(conversion.m_degats);
        }
    }
}
