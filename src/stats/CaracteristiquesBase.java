package stats;

public class CaracteristiquesBase
{
    protected int m_force;
    protected int m_vitesse;
    protected int m_initiative;
    protected int m_dexterite;
    protected int m_currentPv;
    protected int m_pvMax;

    public CaracteristiquesBase(int force, int vitesse, int init, int dex, int pv)
    {
        m_force = force;
        m_vitesse = vitesse;
        m_initiative = init;
        m_dexterite = dex;
        m_currentPv = pv;
        m_pvMax = pv;
    }

    public int getForce()
    {
        return m_force;
    }

    public void setForce(int force)
    {
        m_force = force;
    }

    public int getVitesse()
    {
        return m_vitesse;
    }

    public void setVitesse(int vitesse)
    {
        m_vitesse = vitesse;
    }

    public int getInitiative()
    {
        return m_initiative;
    }

    public void setInitiative(int init)
    {
        m_initiative = init;
    }

    public int getDexterite()
    {
        return m_dexterite;
    }

    public void setDexterite(int dex)
    {
        m_dexterite = dex;
    }

    public int getPvMax()
    {
        return m_pvMax;
    }

    public int getCurrentPv()
    {
        return m_currentPv;
    }

    public void setCurrentPv(int pv)
    {
        m_currentPv = pv;
    }

    public void setPvMax(int pv)
    {
        m_pvMax = pv;
    }

    @Override
    public String toString()
    {
        return  "PV : " + Integer.toString(m_currentPv) + "/" + Integer.toString(m_pvMax) +
                "\nForce : " + Integer.toString(m_force) +
                "\nVitesse : " + Integer.toString(m_vitesse) +
                "\nDextérité : " + Integer.toString(m_dexterite) +
                "\nInitiative : " + Integer.toString(m_initiative);
    }
}
