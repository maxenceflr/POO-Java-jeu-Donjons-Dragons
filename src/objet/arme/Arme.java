package objet.arme;


import objet.Equipement;
import partie.De;

import java.util.function.DoubleConsumer;

public abstract class Arme extends Equipement
{
    protected int m_portee;
    protected De m_degats;

    public Arme(De degats, int portee)
    {
        m_degats = degats;
        m_portee = portee;
    }

    public Arme()
    {
        m_degats = new De();
        m_portee = 0;
    }

    public De getDeDegats()
    {
        return m_degats;
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
        return  "Dégâts : " + m_degats.toString() +
                ", Portée : " + Integer.toString(m_portee);
    }

}
