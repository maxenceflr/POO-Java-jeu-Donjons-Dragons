package objet.arme;


import donjon.Position;
import objet.Equipement;
import partie.De;

import java.util.function.DoubleConsumer;

public abstract class Arme extends Equipement
{
    protected int m_portee;
    protected De m_degats;
    protected int m_bonusAttaque;

    public Arme(De degats, int portee)
    {
        m_degats = degats;
        m_portee = portee;
        m_bonusAttaque = 0;
    }

    public Arme()
    {
        m_degats = new De();
        m_portee = 0;
        m_bonusAttaque = 0;
    }

    public void ajouterBonus(int bonus)
    {
        this.m_bonusAttaque += bonus;
    }

    public De getDeDegats()
    {
        return m_degats;
    }

    public void setBonusAttaque(int bonus)
    {
        m_bonusAttaque = bonus;
    }

    public int getBonusAttaque()
    {
        return m_bonusAttaque;
    }

    public void setDeDegats(De degats)
    {
        m_degats = degats;
    }

    public int getPortee()
    {
        return m_portee;
    }

    public void setPortee(int portee)
    {
        m_portee = portee;
    }

    @Override
    public String toString()
    {
        return  "\nDégâts : " + m_degats.toString() +
                ", Portée : " + Integer.toString(m_portee);
    }

    @Override
    public boolean equals(Object other) {
        //Run Time Type Information!
        if (other == null || other.getClass() != getClass()) {
            return false;
        } else {
            Arme conversion = (Arme) other;
            return m_portee == conversion.m_portee && m_degats.equals(conversion.m_degats);
        }
    }

}
