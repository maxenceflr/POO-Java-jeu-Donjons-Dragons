package objet.arme;

public abstract class ArmeDeGuerre extends Arme
{
    protected int m_vitesse;
    protected int m_force;

    public ArmeDeGuerre(int degats, int portee, int vitesse, int force)
    {
        super(degats, portee);
        m_vitesse = vitesse;
        m_vitesse = force;
    }

    public ArmeDeGuerre()
    {
        super(0, 1);
        m_force = 4;
        m_vitesse = -2;
    }

    public int getVitesse()
    {
        return m_vitesse;
    }

    public void setVitesse(int vitesse)
    {
        m_vitesse = vitesse;
    }

    public int getForce()
    {
        return m_force;
    }

    public void setForce(int force)
    {
        m_force = force;
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
