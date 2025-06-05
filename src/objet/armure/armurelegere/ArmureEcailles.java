package objet.armure.armurelegere;

public class ArmureEcailles extends ArmureLegere
{
    public ArmureEcailles()
    {
        super(9);
    }

    @Override
    public String getNomEquipement()
    {
        return "Armure d'écailles";
    }

    @Override
    public String toString()
    {
        return "Armure d'écailles : " + super.toString();
    }

    @Override
    public boolean equals(Object other) {
        //Run Time Type Information!
        if (other == null || other.getClass() != getClass()) {
            return false;
        } else {
            ArmureEcailles conversion = (ArmureEcailles) other;
            return m_classeArmure == conversion.m_classeArmure;
        }
    }
}
