package objet.arme.armedistance;

import partie.De;

public class Fronde extends ArmeDistance
{
    public Fronde()
    {
        super(new De(1, 4), 6);
    }

    @Override
    public String getNomEquipement()
    {
        return "Fronde";
    }

    @Override
    public String toString() {
        return "Fronde : " + super.toString();
    }
}
