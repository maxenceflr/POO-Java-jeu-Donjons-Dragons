package objet.arme;

public class ArcCourt extends ArmeDistance
{
    public ArcCourt()
    {
        super(0, 16);
    }

    @Override
    public String toString() {
        return "Arc Court : " + super.toString();
    }
}
