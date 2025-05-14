package objet.armure;

public class ArmureLourde extends Armure
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

    public int getVitesse() {
        return m_vitesse;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
