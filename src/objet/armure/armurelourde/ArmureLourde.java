package objet.armure.armurelourde;

import jouable.personnage.Personnage;
import objet.armure.Armure;

public abstract class ArmureLourde extends Armure
{
    protected int m_vitesse;

    public ArmureLourde(int armure)
    {
        super(armure);
        m_vitesse = -4;
    }

    public ArmureLourde()
    {
        super();
        m_vitesse = -4;
    }

    @Override
    public void equiper(Personnage perso)
    {
        perso.setClasseArmure(perso.getClasseArmure() + this.m_classeArmure);
        perso.setArmure(this);
        perso.setVitesse(perso.getVitesse() - m_vitesse);
    }

    public int getVitesse() {
        return m_vitesse;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
