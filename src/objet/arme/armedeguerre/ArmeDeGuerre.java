package objet.arme.armedeguerre;

import jouable.personnage.Personnage;
import objet.arme.Arme;
import partie.De;

public abstract class ArmeDeGuerre extends Arme
{
    protected int m_vitesse;
    protected int m_force;

    public ArmeDeGuerre(De degats, int portee, int vitesse, int force)
    {
        super(degats, portee);
        m_vitesse = vitesse;
        m_vitesse = force;
    }

    public ArmeDeGuerre()
    {
        super(new De(1, 8), 1);
        m_force = 4;
        m_vitesse = -2;
    }

    public void equiper(Personnage perso)
    {
        perso.setArme(this);
        perso.setVitesse(perso.getVitesse() + this.m_vitesse);
        perso.setForce(perso.getForce() + this.m_force);
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
