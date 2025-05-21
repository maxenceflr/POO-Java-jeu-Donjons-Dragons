package objet.armure;

public class DemiPlate extends ArmureLegere
{
    public DemiPlate()
    {
        super(10);
    }

    @Override
    public String toString()
    {
        return "Demi-plate : " + super.toString();
    }
}
