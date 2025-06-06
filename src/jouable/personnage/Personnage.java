package jouable.personnage;

import donjon.Donjon;
import donjon.Position;
import jouable.ActionResult;
import jouable.Jouable;
import jouable.personnage.classe.Classe;
import jouable.personnage.race.*;
import objet.Equipement;
import objet.arme.*;
import objet.armure.*;
import partie.De;
import stats.CaracteristiquesBase;
import affichage.AffichagePersonnage;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static jouable.ActionResult.*;

public class Personnage extends Jouable {

    private String m_nom;
    private Inventaire m_inventaire;
    private Optional<Arme> m_arme;
    private Optional<Armure> m_armure;
    private final Race m_race;
    private final Classe m_classe;

    public Personnage(String nom, Race race, Classe classe, CaracteristiquesBase carac) {/*constructeur pour les test*/
        m_nom = nom;
        m_race= race;
        m_classe = classe;
        m_inventaire = new Inventaire();
        m_arme = Optional.empty();
        m_armure= Optional.empty();
        m_caracteristiques = carac;

        m_classe.ajouterClasseInitPerso(this);
        //m_race.ajouterInitRacePerso(this);
    }


    public Personnage() {
        AffichagePersonnage af =new AffichagePersonnage();
        CaracteristiquesBase CA = new CaracteristiquesBase();
        m_nom = af.choisirNom();

        m_arme = Optional.empty();
        m_armure= Optional.empty();
        m_caracteristiques = CA;
        m_race= af.choisirRace(this);
        m_classe = af.choisirClasse();
        CA.ajouterClasseBonus(m_classe.getPvClasse());
        m_inventaire = new Inventaire();
        m_inventaire.setInventaire(m_classe.getListeEquipement());
        af.afficherCaracteristique(this);
    }

    public ActionResult attaquer(Position other, Donjon donjon)
    {
        De deAttaque = new De(1, 20);
        Jouable otherJouable = donjon.getJouableFromPosition(other);

        if (this.m_arme.isPresent())
        {
            if (Donjon.getDistance(donjon.getPositionFromJouable(this), other) <= m_arme.get().getPortee())
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

                System.out.println("Dé d'attaque: " + Integer.toString(somme_attaque));

                if (somme_attaque > otherJouable.getClasseArmure())
                {
                    int degats_arme = this.m_arme.get().getDeDegats().jeter() + m_arme.get().getBonusAttaque();
                    otherJouable.setCurrentPv(otherJouable.getCurrentPv() - degats_arme);
                    return  SUCCESS;
                }
                else
                {
                    return  FAILURE;
                }
            }
            else
            {
                return OUT_OF_REACH;
            }
        }

        return NO_WEAPON;
    }

    public ActionResult equiper(Equipement item)
    {
        if (this.m_inventaire.getInventaire().contains(item))
        {
            m_inventaire.getEquipement(item).equiper(this);
            m_inventaire.retirerEquipement(item);
            return SUCCESS;
        }
        else
        {
            return NO_ITEM;
        }
    }

    public ActionResult ramasser(Position pos, Donjon donjon) {
        if(donjon.getPositionsEquipement().containsEquipement(pos)) {
            this.m_inventaire.ajouterEquipement(donjon.getEquipementFromPosition(pos));
            donjon.getPositionsEquipement().retirerEquipement(pos);
            return SUCCESS;
        }
        return NO_ITEM;
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


    public String getSymbole() {
        if (this.m_nom.length() >= 3) {
            return this.m_nom.substring(0, 3);
        }
        else if (this.m_nom.length() >= 2){
            return this.m_nom+" "; // ou return nom + 1 espace pour  toujours 3 caractères
        }

        return this.m_nom+"  "; // ou return nom + 2 espace pour  toujours 3 caractères

    }

    public String getNom() {
        return m_nom;
    }

    public Classe getClasse(){
        return  this.m_classe;
    }
    public Race getRace(){
        return  this.m_race;
    }

    public Inventaire getInventaire()
    {
        return this.m_inventaire;
    }
    public String getStringArme()/*Renvoie les info sur l'arme que porte le personnage sous forme de string*/
    {
        if (m_arme.isPresent())
        {
            return "Arme portée: "+m_arme.toString()+"("+m_arme.toString();

        }
        else
        {
            return "Ne porte pas d'arme pour le moment";
        }
    }
    public String getStringArmure()/*Renvoie les infos sur l'armure que porte le personnage sous forme de string*/
    {
        if (m_arme.isPresent())
        {
            return "Armure porté: "+m_armure.toString();

        }
        else
        {
            return "Ne porte pas d'armure pour le moment";
        }
    }

    @Override
    public String toString() {
        return "Personnage: "+ this.getNom()+ "\nRace: " + m_race.toString()+"\nClasse: " + m_classe.toString() +
                "\nArme équipée: " + this.m_arme.get().getNomEquipement() +
                "\nArmure équipée: " + this.m_armure.get().getNomEquipement() +
                "\nStatistiques: \n" + this.m_caracteristiques.toString();
    }
}
