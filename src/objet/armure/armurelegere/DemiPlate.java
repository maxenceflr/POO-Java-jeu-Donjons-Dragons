package objet.armure.armurelegere;

import objet.armure.armurelourde.Harnois;

public class DemiPlate extends ArmureLegere
{
    public DemiPlate()
    {
        super(10);
    }

    @Override
    public String getNomEquipement()
    {
        return "DemiPlate";
    }

    @Override
    public String toString()
    {
        return "Demi-plate : " + super.toString();
    }

    @Override
    public boolean equals(Object other) {
        //Run Time Type Information!
        if (other == null || other.getClass() != getClass()) {
            return false;
        } else {
            DemiPlate conversion = (DemiPlate) other;
            return m_classeArmure == conversion.m_classeArmure;
        }
    }
}
