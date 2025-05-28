package jouable.personnage;

import donjon.Donjon;
import jouable.Jouable;
import partie.De;
import affichage.*;

public class Monstre extends Jouable {

    private De m_degats;
    private int m_portee;
    private String m_espece;
    private String m_symbole;

    public Monstre()
    {
        AffichageMonstre ar = new AffichageMonstre();
        m_degats = ar.choisirDegatAttaque();
        m_portee = ar.choisirPorterAttaque();
        m_espece = ar.choisirEspece();
        m_symbole = ar.choisirRepresentation();
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
