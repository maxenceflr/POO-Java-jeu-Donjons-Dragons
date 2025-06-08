package jouable;


import donjon.Donjon;
import donjon.Position;
import donjon.PositionsJouables;
import objet.armure.*;
import stats.CaracteristiquesBase;

import java.util.List;

public abstract class Jouable
{
    protected CaracteristiquesBase m_caracteristiques;

    public abstract AttackResult attaquer(Position position, Donjon donjon);

    public abstract void ajouterJouable(Position position, PositionsJouables listeJouables);

    public abstract void setId(Integer id);

    public abstract void setSymbole(String symbole);

    public abstract String getSymbole();

    public abstract String toString();
    public abstract String getNom();

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
        m_caracteristiques.setVitesse(vit);
    }

    public void setForce(int force)
    {
        m_caracteristiques.setForce(force);
    }

    public int getClasseArmure()
    {
        return m_caracteristiques.getArmure();
    }

    public void setClasseArmure(int class_armure)
    {
        m_caracteristiques.setArmure(class_armure);
    }


}
