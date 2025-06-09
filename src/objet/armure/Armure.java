package objet.armure;

import jouable.personnage.Personnage;
import objet.Equipement;
import objet.arme.Arme;

public abstract class Armure extends Equipement
{
    protected int m_classeArmure;

    protected Armure(int armure)
    {
        m_classeArmure = armure;
    }

    protected Armure()
    {
        m_classeArmure = 0;
    }

    public int getArmure()
    {
        return m_classeArmure;
    }

    public void ajouterBonus(int bonus)
    {
        this.m_classeArmure += bonus;
    }
    public String getTypeClass()
    {
        return "p";//celui de Armure n'est jamais utilisé
    }

    @Override
    public String toString()
    {
        return  "(Classe d'armure : " + Integer.toString(m_classeArmure)+")";
    }

    public void equiper(Personnage perso)
    {
        if(perso.getArmure().isPresent())
        {
            perso.getInventaire().ajouterEquipement(perso.getArmure().get());
        }
        perso.setArmure(this);
        perso.setClasseArmure(m_classeArmure);
    }

    @Override
    public boolean equals(Object other) {
        //Run Time Type Information!
        if (other == null || other.getClass() != getClass()) {
            return false;
        } else {
            Armure conversion = (Armure) other;
            return m_classeArmure == conversion.m_classeArmure;
        }
    }
}
