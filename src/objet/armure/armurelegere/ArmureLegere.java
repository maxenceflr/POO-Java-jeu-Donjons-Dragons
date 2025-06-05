package objet.armure.armurelegere;

import objet.armure.Armure;
import objet.armure.armurelourde.Harnois;

public abstract class ArmureLegere extends Armure
{

    public ArmureLegere()
    {
        super();
    }

    public ArmureLegere(int armure)
    {
        super(armure);
    }


    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object other) {
        //Run Time Type Information!
        if (other == null || other.getClass() != getClass()) {
            return false;
        } else {
            ArmureLegere conversion = (ArmureLegere) other;
            return m_classeArmure == conversion.m_classeArmure;
        }
    }
}
