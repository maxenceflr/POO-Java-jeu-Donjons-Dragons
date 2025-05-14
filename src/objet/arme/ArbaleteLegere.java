package objet.arme;

public class ArbaleteLegere extends ArmeDistance
{
    public ArbaleteLegere()
    {
        super(0, 16);
    }

    @Override
    public String toString() {
        return "ArbalèteLégère : " + super.toString();
    }
}
