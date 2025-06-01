package objet.armure.armurelourde;

public class CoteMailles extends ArmureLourde
{
    public CoteMailles()
    {
        super(11);
    }

    @Override
    public String getNomEquipement()
    {
        return "Cotte de mailles";
    }

    @Override
    public String toString()
    {
        return "Côte de mailles : " + super.toString();
    }
}
