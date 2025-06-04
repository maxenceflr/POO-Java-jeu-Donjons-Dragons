package objet.arme;

import partie.De;

public class ArcCourt extends ArmeDistance
{
    public ArcCourt()
    {
        super(new De(1, 6), 16);
    }

    @Override
    public String toString() {
        return "Arc Court " + super.toString();
    }
}
