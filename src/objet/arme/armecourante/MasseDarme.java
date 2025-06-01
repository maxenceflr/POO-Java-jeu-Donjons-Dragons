package objet.arme.armecourante;

public class MasseDarme extends ArmeCourante
{
    public MasseDarme()
    {
        super();
    }

    @Override
    public String getNomEquipement()
    {
        return "Masse d'arme";
    }

    @Override
    public String toString()
    {
        return "Masse d'arme : " + super.toString();
    }
}
