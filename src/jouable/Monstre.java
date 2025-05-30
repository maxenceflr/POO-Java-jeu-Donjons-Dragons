package jouable.personnage;

import donjon.Donjon;
import donjon.Position;
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

    public void attaquer(Position other, Donjon donjon)
    {
        De deAttaque = new De(1, 20);
        Jouable otherJouable = donjon.getJouableFromPostion(other);

        if (Donjon.getDistance(donjon.getPositionFromJouable(this), other) < this.m_portee)
        {
            int somme_attaque = m_degats.jeter();

            if (this.getForce() == 0)
            {
                somme_attaque += this.getDexterite();
            }
            else
            {
                somme_attaque += this.getForce();
            }

            if (somme_attaque > otherJouable.getClasseArmure())
            {
                otherJouable.setCurrentPv(otherJouable.getCurrentPv() - this.m_degats.jeter());
            }
        }
    }

    public String getSymbole()
    {
        return m_symbole;
    }

}
