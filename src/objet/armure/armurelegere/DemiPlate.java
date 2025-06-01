package objet.armure.armurelegere;

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
}
