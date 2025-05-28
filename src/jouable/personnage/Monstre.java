package jouable.personnage;

import donjon.Donjon;
import jouable.Jouable;
import partie.De;

public class Monstre extends Jouable {

    private De m_degats;
    private int m_portee;
    private String m_espece;
    private String m_symbole;

    public Monstre(De deDegats, int portee, String espece, String symbole)
    {
        m_degats = deDegats;
        m_portee = portee;
        m_espece = espece;
        m_symbole = symbole;
    }

    public void attaquer(Jouable other)
    {
        if (Donjon.getDistance(this, other) < this.m_portee)
        {
            int somme_attaque = m_degats.jeter();

            if (this.getForce() == 0)
            {

            }
        }
    }

    public String getSymbole()
    {
        return m_symbole;
    }

}
