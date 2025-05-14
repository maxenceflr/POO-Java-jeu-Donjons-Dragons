package objet.arme;

public class Fronde extends ArmeDistance
{
    public Fronde()
    {
        super(0, 6);
    }

    @Override
    public String toString() {
        return "Fronde : " + super.toString();
    }
}
