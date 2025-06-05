package objet.arme.armecourante;

public class Baton extends ArmeCourante
{
    public Baton()
    {
        super();
    }

    @Override
    public String getNomEquipement()
    {
        return "Bâton";
    }

    @Override
    public String toString()
    {
        return "Bâton : " + super.toString();
    }

    @Override
    public boolean equals(Object other)
    {
        //Run Time Type Information!
        if (other == null || other.getClass() != getClass()) {
            return false;
        } else {
            Baton conversion = (Baton) other;
            return m_portee == conversion.m_portee && m_degats.equals(conversion.m_degats);
        }
    }
}
