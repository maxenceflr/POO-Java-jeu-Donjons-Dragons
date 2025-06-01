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
}
