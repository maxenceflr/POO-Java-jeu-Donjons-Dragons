package stats;

public class CaracteristiqueMonstre extends CaracteristiquesBase
{

    private int m_classeArmure;

    public CaracteristiqueMonstre(Integer force, Integer vitesse, Integer init, Integer dex, Integer pv, Integer armure)
    {
        super(force, vitesse, init, dex, pv);
        m_classeArmure = armure;
    }

    public int getArmure()
    {
        return m_classeArmure;
    }

    public void setArmure(int armure)
    {
        m_classeArmure = armure;
    }

    @Override
    public String toString()
    {
        return  super.toString() + "\nArmure : " + Integer.toString(m_classeArmure);
    }
}
