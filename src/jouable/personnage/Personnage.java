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

    private  String m_nom;
    private List<Equipement> m_inventaire;
    private Optional<Arme> m_arme;
    private Optional<Armure> m_armure;
    private Race m_race;
    private Classe m_classe;
    private CaracteristiquesBase m_caracteristique;

    public Personnage(String nom,Race race, Classe classe, CaracteristiquesBase carac) {
        m_nom=nom;
        m_race= race;
        m_classe=classe;
        m_inventaire = new ArrayList<>();
        m_arme = Optional.empty();
        m_armure= Optional.empty();
        m_caracteristiques = carac;
        m_position = new Position(-1, -1);
    }



    public void equiperArme(Arme arme)
    {
        if (m_inventaire.contains(arme)) {
            if(m_arme.isEmpty())
            {
                m_arme = Optional.of(arme);
                m_inventaire.remove(arme);
            }
            else
            {
                m_inventaire.add(m_arme.get());
                m_arme = Optional.of(arme);
                m_inventaire.remove(arme);
            }
        }
    }

    public void equiperArmure(Armure armure)
    {
        if (m_inventaire.contains(armure)) {
            if(m_armure.isEmpty())
            {
                m_armure = Optional.of(armure);
                m_inventaire.remove(armure);
            }
            else
            {
                m_inventaire.add(m_armure.get());
                m_armure = Optional.of(armure);
                m_inventaire.remove(armure);
            }
        }
    }

    public void attaquer(Jouable other)
    {
        De deAttaque = new De(1, 20);

        if (this.m_arme.isPresent())
        {
            if (Donjon.getDistance(this, other) < m_arme.get().getPortee())
            {
                int somme_attaque = deAttaque.jeter();

                if(m_arme.get() instanceof ArmeCourante || m_arme.get() instanceof ArmeDeGuerre)
                {
                    somme_attaque += this.m_caracteristiques.getForce();
                }
                else
                {
                    somme_attaque += this.m_caracteristiques.getDexterite();
                }

                if (somme_attaque > other.getArmure())
                {
                    other.setCurrentPv(other.getCurrentPv() - this.m_arme.get().getDeDegat().jeter());
                }
            }
        }
    }

    public String getSymbole()
    {
      return this.m_nom.substring(0, 3);
    };

    public void ramasser(Equipement objet, Donjon donjon) {
        if (donjon.getPositionsEquipement().containsEquipement(this.getPosition()))
        {
            m_inventaire.add(objet);
            donjon.getPositionsEquipement().retirerEquipement(this.getPosition());
        }
    }

    public String getNom() {
        return m_nom;
    }
    @Override
    public String toString() {
        return "Personnage : "+ this.getNom()+ "\nRace : " + m_race.getRace()+"\nClasse : " + m_classe.getClasse();
    }
}
