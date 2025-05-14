package objet.arme;

public abstract class ArmeCourante extends Arme
{

    public ArmeCourante(int degats, int portee)
    {
        super(degats, portee);
    }

    public ArmeCourante()
    {
        super(0, 1);
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
