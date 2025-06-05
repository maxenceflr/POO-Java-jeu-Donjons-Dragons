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
        if(perso.getArmure().isPresent())
        {
            perso.getInventaire().ajouterEquipement(perso.getArmure().get());
        }

        perso.setClasseArmure(this.m_classeArmure);
        perso.setArmure(this);
        perso.setVitesse(perso.getVitesse() + m_vitesse);

    }

    public int getVitesse() {
        return m_vitesse;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object other)
    {
        //Run Time Type Information!
        if (other == null || other.getClass() != getClass()) {
            return false;
        } else {
            ArmureLourde conversion = (ArmureLourde) other;
            return m_classeArmure == conversion.m_classeArmure && m_vitesse == conversion.m_vitesse;
        }
    }
}
