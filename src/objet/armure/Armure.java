package objet.armure;

import objet.Equipement;

public class Armure extends Equipement
{
    private int m_classeArmure;

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

    @Override
    public String toString()
    {
        return  "Classe d'armure : " + Integer.toString(m_classeArmure);
    }
}
