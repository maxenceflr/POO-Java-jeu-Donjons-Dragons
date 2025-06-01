package objet.arme.armedistance;

import partie.De;

public class ArbaleteLegere extends ArmeDistance
{
    public ArbaleteLegere()
    {
        super(new De(1, 8), 16);
    }

    @Override
    public String getNomEquipement()
    {
        return "ArbalèteLégère";
    }

    @Override
    public String toString() {
        return "ArbalèteLégère : " + super.toString();
    }
}
