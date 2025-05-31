package objet.armure;

import jouable.personnage.Personnage;
import objet.Equipement;

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

    @Override
    public String toString()
    {
        return  "Classe d'armure : " + Integer.toString(m_classeArmure);
    }

    public void equiper(Personnage perso)
    {
        perso.setClasseArmure(perso.getClasseArmure() + m_classeArmure);
        perso.setArmure(this);
    }
}
