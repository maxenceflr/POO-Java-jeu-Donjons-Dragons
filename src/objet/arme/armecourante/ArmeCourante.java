package objet.arme.armecourante;

import jouable.personnage.Personnage;
import objet.arme.Arme;
import partie.De;

public abstract class ArmeCourante extends Arme
{

    public ArmeCourante(De degats, int portee)
    {
        super(degats, portee);
    }

    public ArmeCourante()
    {
        super(new De(1, 6), 1);
    }

    public void equiper(Personnage perso)
    {
        perso.setArme(this);
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
