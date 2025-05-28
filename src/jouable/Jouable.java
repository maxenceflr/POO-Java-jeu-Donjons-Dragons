package jouable;


import donjon.Position;
import stats.CaracteristiquesBase;

import java.util.List;

public abstract class Jouable
{
    protected CaracteristiquesBase m_caracteristiques;

    protected Position m_position;

    public abstract void attaquer(Jouable other);

    public abstract String getSymbole();


    public Position getPosition()
    {
        return  this.m_position;
    }


    public int getPvMax()
    {
        return m_caracteristiques.getPvMax();
    }

    public int getCurrentPv()
    {
        return m_caracteristiques.getCurrentPv();
    }

    public int getDexterite()
    {
        return m_caracteristiques.getDexterite();
    }

    public int getInitiative()
    {
        return m_caracteristiques.getInitiative();
    }

    public int getVitesse()
    {
        return m_caracteristiques.getVitesse();
    }

    public int getForce()
    {
        return m_caracteristiques.getForce();
    }

    public void setPvMax(int pv)
    {
        m_caracteristiques.setPvMax(pv);
    }

    public void setCurrentPv(int pv)
    {
        m_caracteristiques.setCurrentPv(pv);
    }

    public void setDexterite(int dex)
    {
        m_caracteristiques.setDexterite(dex);
    }

    public void setInitiative(int init)
    {
        m_caracteristiques.setInitiative(init);
    }

    public void setVitesse(int vit)
    {
        m_caracteristiques.setInitiative(vit);
    }

    public void setForce(int force)
    {
        m_caracteristiques.setForce(force);
    }

    public int getArmure()
    {
        return m_caracteristiques.getArmure();
    }

    public void setArmure(int armure)
    {
        m_caracteristiques.setArmure(armure);
    }

}
