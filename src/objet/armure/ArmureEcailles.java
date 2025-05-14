package objet.armure;

public class ArmureEcailles extends ArmureLegere
{
    public ArmureEcailles()
    {
        super(9);
    }

    @Override
    public String toString()
    {
        return "Armure d'écailles : " + super.toString();
    }
}
