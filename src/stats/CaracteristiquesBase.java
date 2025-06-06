package stats;

import partie.De;

public class CaracteristiquesBase
{
    protected int m_force;
    protected int m_vitesse;
    protected int m_initiative;
    protected int m_dexterite;
    protected int m_currentPv;
    protected int m_pvMax;
    protected int m_armure;

    public CaracteristiquesBase(int force, int vitesse, int init, int dex, int pv, int armure)/*constructeur pour monstre (on choisit les stat*/
    {
        m_force = force;
        m_vitesse = vitesse;
        m_initiative = init;
        m_dexterite = dex;
        m_currentPv = pv;
        m_pvMax = pv;
        m_armure = armure;
    }
    public CaracteristiquesBase()/*constructeur pour les personage qui est aleatoire*/
    {
        De dee =new De(4,4);
        m_force = dee.jeter()+3;
        m_vitesse = dee.jeter()+3;
        m_initiative = dee.jeter()+3;
        m_dexterite = dee.jeter()+3;
        m_currentPv = 0;
        m_pvMax = 0;/*sera initialiser par la classe*/
        m_armure = 0;
    }


    /*public CaracteristiquesBase()
    {
        this(0,0,0,0,0,0);
    }*/

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

    public int getArmure()
    {
        return m_armure;
    }

    public void setArmure(int armure)
    {
        m_armure = armure;
    }
    public void ajouterClasseBonus(int pv)
    {
        this.setPvMax(pv);
        this.setCurrentPv(pv);
    }

    @Override
    public String toString()
    {
        return  "PV : " + Integer.toString(m_currentPv) + "/" + Integer.toString(m_pvMax) +
                "\nForce : " + Integer.toString(m_force) +
                "\nVitesse : " + Integer.toString(m_vitesse) +
                "\nDextérité : " + Integer.toString(m_dexterite) +
                "\nInitiative : " + Integer.toString(m_initiative) +
                "\nArmure : " + Integer.toString(m_armure) + "\n";
    }
}


