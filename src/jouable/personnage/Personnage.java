package jouable.personnage;

import donjon.Donjon;
import donjon.Position;
import jouable.Jouable;
import jouable.personnage.classe.Classe;
import jouable.personnage.race.*;
import objet.Equipement;
import objet.arme.*;
import objet.armure.*;
import partie.De;
import stats.CaracteristiquesBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Personnage extends Jouable {

    private final String m_nom;
    private Inventaire m_inventaire;
    private Optional<Arme> m_arme;
    private Optional<Armure> m_armure;
    private final Race m_race;
    private final Classe m_classe;

    public Personnage(String nom, Race race, Classe classe, CaracteristiquesBase carac) {
        m_nom = nom;
        m_race= race;
        m_classe = classe;
        m_inventaire = new Inventaire();
        m_arme = Optional.empty();
        m_armure= Optional.empty();
        m_caracteristiques = carac;
    }

    public void attaquer(Position other, Donjon donjon)
    {
        De deAttaque = new De(1, 20);
        Jouable otherJouable = donjon.getJouableFromPosition(other);

        if (this.m_arme.isPresent())
        {
            if (Donjon.getDistance(donjon.getPositionFromJouable(this), other) < m_arme.get().getPortee())
            {
                int somme_attaque = deAttaque.jeter() + m_arme.get().getBonusAttaque();

                if(m_arme.get().getPortee() < 2)
                {
                    somme_attaque += this.m_caracteristiques.getForce();
                }
                else
                {
                    somme_attaque += this.m_caracteristiques.getDexterite();
                }

                if (somme_attaque > otherJouable.getClasseArmure())
                {
                    otherJouable.setCurrentPv(otherJouable.getCurrentPv() - (this.m_arme.get().getDeDegats().jeter() + m_arme.get().getBonusAttaque()));
                }
            }
        }
    }

    public void equiper(Equipement item)
    {
        m_inventaire.getEquipement(item).equiper(this);
        m_inventaire.retirerEquipement(item);
    }

    public void ramasser(Position pos, Donjon donjon) {
        this.m_inventaire.ajouterEquipement(donjon.getEquipementFromPosition(pos));
        donjon.getPositionsEquipement().retirerEquipement(pos);
    }

    public void setArmure(Armure armure) {
        m_armure = Optional.of(armure);
    }

    public void setArme(Arme arme) {
        m_arme = Optional.of(arme);
    }

    public Optional<Armure> getArmure() {
        return m_armure;
    }
    public Optional<Arme> getArme() {
        return m_arme;
    }

    public String getSymbole()
    {
      return this.m_nom.substring(0, 3);
    };

    public String getNom() {
        return m_nom;
    }

    public Classe getClasse(){
        return  this.m_classe;
    }

    public Inventaire getInventaire()
    {
        return this.m_inventaire;
    }

    @Override
    public String toString() {
        return "Personnage : "+ this.getNom()+ "\nRace : " + m_race.toString()+"\nClasse : " + m_classe.toString();
    }
}
