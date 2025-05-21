package jouable.personnage;

import jouable.Jouable;
import jouable.personnage.classe.Classe;
import jouable.personnage.race.*;
import objet.Equipement;
import objet.arme.*;
import objet.armure.*;
import stats.CaracteristiquesBase;

import java.util.ArrayList;
import java.util.List;

public class Personnage extends Jouable {
    protected String m_nom;
    protected List<Equipement> m_invetaire;
    protected Arme m_arme;
    protected Armure m_armure;
    protected Race m_race;
    protected Classe m_classe;
    protected CaracteristiquesBase m_caracteristique;

    public Personnage(String nom,Race race,Classe classe) {
        m_nom=nom;
        m_race= race;
        m_classe=classe;
        m_invetaire= new ArrayList<>();
        m_arme=null;
        m_armure=null;
        CaracteristiquesBase caracteristique=new CaracteristiquesBase();
        m_caracteristique= race.ajouterCaracteristique(caracteristique);

    }

    public void equiperArme( Arme arme)
    {
        m_arme=arme;
    }
    public void equiperArmure( Arme arme)
    {
        m_arme=arme;
    }
    public void ramasser(Equipement objet) {
        m_invetaire.add(objet);
    }
    public String getNom() {
        return m_nom;
    }
    @Override
    public String toString() {
        return "Le perssonage "+this.getNom()+"\nDe la race des :"+m_race.getRace()+"\nDe la classe des: "+m_classe.getClasse();
    }
}
