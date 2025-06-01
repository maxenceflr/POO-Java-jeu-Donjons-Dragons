package objet.arme.armecourante;

public class Baton extends ArmeCourante
{
    public Baton()
    {
        super();
    }

    @Override
    public String getNomEquipement()
    {
        return "Bâton";
    }

    @Override
    public String toString()
    {
        return "Bâton : " + super.toString();
    }
}
