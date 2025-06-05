package objet.armure;

import objet.armure.ArmureLourde;

public class Harnois extends ArmureLourde
{
    public Harnois()
    {
        super(12);
    }

    @Override
    public String toString()
    {
        return "Harnois " + super.toString();
    }
}
