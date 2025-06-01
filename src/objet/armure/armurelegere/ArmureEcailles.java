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
}
