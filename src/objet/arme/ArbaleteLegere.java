package objet.arme;

import partie.De;

public class ArbaleteLegere extends ArmeDistance
{
    public ArbaleteLegere()
    {
        super(new De(1, 8), 16);
    }

    @Override
    public String toString() {
        return "ArbalèteLégère " + super.toString();
    }
}
