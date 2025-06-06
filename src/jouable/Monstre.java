package jouable;

import affichage.AffichageMonstre;
import donjon.Donjon;
import donjon.Position;
import partie.De;
import stats.CaracteristiquesBase;

import static jouable.ActionResult.*;


public class Monstre extends Jouable {

    private De m_degats;
    private int m_portee;
    private String m_espece;
    private String m_symbole;

    public Monstre(De deDegats, int portee, String espece, String symbole, CaracteristiquesBase cara)
    {
        m_degats = deDegats;
        m_portee = portee;
        m_espece = espece;
        m_symbole = symbole;
        m_caracteristiques=cara;
        AffichageMonstre af =new AffichageMonstre();

    }
    public Monstre()
    {
        AffichageMonstre af = new AffichageMonstre();
        int choix = af.choisirEspece();

        if (choix == 1) {
            Monstre gob = creerGobelin();
            copierDepuis(gob);
        } else if (choix == 2) {
            Monstre dragon = creerDragon();
            copierDepuis(dragon);
        } else if (choix == 3) {
            Monstre demo = creerDemogorgon();
            copierDepuis(demo);
        } else {
            m_espece = af.choisirEspecePersonaliser();
            m_symbole = af.choisirRepresentation();
            m_degats = af.choisirDegatAttaque();
            m_caracteristiques = af.choisirCaracteristiques();
            m_portee = af.choisirPorterAttaque();
        }
        af.afficherCaracteristiaque(this);
    }

    private void copierDepuis(Monstre autre) {
        this.m_degats = autre.m_degats;
        this.m_portee = autre.m_portee;
        this.m_espece = autre.m_espece;
        this.m_symbole = autre.m_symbole;
        this.m_caracteristiques = autre.m_caracteristiques;
    }

    public static Monstre creerDragon()
    {
        return new Monstre(new De(1,12), 4, "Dragon", "}X{",new CaracteristiquesBase(12,12,12,12,12,30));
    }

    public static Monstre creerDemogorgon()
    {
        return new Monstre(new De(1,6), 1, "Démogorgon", "~X~",new CaracteristiquesBase(12,12,12,12,12,12));
    }

    public static Monstre creerGobelin()
    {
        return new Monstre(new De(1,2), 1, "Gobelin", "-X-",new CaracteristiquesBase(12,12,12,12,12,12));
    }

    public AttackResult attaquer(Position other, Donjon donjon)
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
                int degats = this.m_degats.jeter();
                otherJouable.setCurrentPv(otherJouable.getCurrentPv() - degats);

                return new AttackResult(SUCCESS, somme_attaque,degats);
            }

            return new AttackResult(FAILURE, somme_attaque, -1) ;
        }

        return new AttackResult(OUT_OF_REACH, -1, -1);
    }


    public String getSymbole()
    {
        return m_symbole;
    }
    public String getNomArmure()
    {
        switch (this.m_caracteristiques.getArmure()) {
            case 9:
                return "Armure d'Ecailles";
            case 10:
                return "Armure Demi-Plate";
            case 11:
                return "Cote de Mailles";
            case 12:
                return "Harnois";
            default:
                return "Armure inconnu avec un protection de : " + this.m_caracteristiques.getArmure();
        }
    }
    public String getStringArmure()/*Renvoie les infos sur l'armure que porte le personnage sous forme de string*/ {

        return "Défense de l'armure: " + m_caracteristiques.getArmure();
    }
    public String getNom()
    {
        return m_espece;
    }

    public String toString()
    {
        return "Espèce: " + this.m_espece + "\nDégâts: " + this.m_degats.toString() +
                "\nPortée: " + Integer.toString(m_portee) + "\nSymbole: " + this.m_symbole +
                "\nStatistiques:\n" + this.m_caracteristiques.toString();
    }

}
