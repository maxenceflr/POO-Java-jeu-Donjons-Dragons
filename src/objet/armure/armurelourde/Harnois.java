package objet.armure.armurelourde;

public class Harnois extends ArmureLourde
{
    public Harnois()
    {
        super(12);
    }

    @Override
    public String getNomEquipement()
    {
        return "Harnois";
    }

    @Override
    public String toString()
    {
        return "Harnois : " + super.toString();
    }

    @Override
    public boolean equals(Object other) {
        //Run Time Type Information!
        if (other == null || other.getClass() != getClass()) {
            return false;
        } else {
            Harnois conversion = (Harnois) other;
            return m_classeArmure == conversion.m_classeArmure && m_vitesse == conversion.m_vitesse;
        }
    }
}
