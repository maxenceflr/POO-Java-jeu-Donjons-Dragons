package objet.arme;

import objet.armure.ArmureLourde;

public class CoteMailles extends ArmureLourde
{
    public CoteMailles()
    {
        super(11);
    }

    @Override
    public String toString()
    {
        return "Côte de mailles : " + super.toString();
    }
}
