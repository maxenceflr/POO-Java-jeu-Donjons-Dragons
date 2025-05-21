package objet.arme;


import objet.Equipement;

public abstract class Arme extends Equipement
{
    protected int m_degats;
    protected int m_portee;

    public Arme(int degats, int portee)
    {
        m_degats = degats;
        m_portee = portee;
    }

    public Arme()
    {
        m_degats = 0;
        m_portee = 0;
    }

    public int getDegats()
    {
        return m_degats;
    }

    public void setDegats(int degats)
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
        return  "Dégâts : " + Integer.toString(m_degats) +
                ", Portée : " + Integer.toString(m_portee);
    }
}
