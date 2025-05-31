package jouable;

import affichage.AffichageMonstre;
import donjon.Donjon;
import donjon.Position;
import partie.De;
import stats.CaracteristiquesBase;


public class Monstre extends Jouable {

    private De m_degats;
    private int m_portee;
    private String m_espece;
    private String m_symbole;
    private CaracteristiquesBase m_caracteristique;

    public Monstre(De deDegats, int portee, String espece, String symbole, CaracteristiquesBase cara)
    {
        m_degats = deDegats;
        m_portee = portee;
        m_espece = espece;
        m_symbole = symbole;
        m_caracteristique=cara;
    }
    public Monstre()
    {
        AffichageMonstre af = new AffichageMonstre();
        m_espece = af.choisirEspece();
        m_symbole = af.choisirRepresentation();
        m_caracteristique=af.choisirCaracteristiques();
        m_degats = af.choisirDegatAttaque();
        m_portee = af.choisirPorterAttaque();
    }

    public static Monstre creerDragon()
    {
        return new Monstre(new De(1,12), 4, "Dragon", "}X{",new CaracteristiquesBase(12,12,12,12,12,12));
    }

    public static Monstre creerDemogorgon()
    {
        return new Monstre(new De(1,6), 1, "Démogorgon", "~X~",new CaracteristiquesBase(12,12,12,12,12,12));
    }

    public static Monstre creerGobelin()
    {
        return new Monstre(new De(1,2), 1, "Gobelin", "-X-",new CaracteristiquesBase(12,12,12,12,12,12));
    }

    public void attaquer(Position other, Donjon donjon)
    {
        De deAttaque = new De(1, 20);
        Jouable otherJouable = donjon.getJouableFromPosition(other);

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

    public String toString()
    {
        return "espèce: " + this.m_espece;
    }

}
