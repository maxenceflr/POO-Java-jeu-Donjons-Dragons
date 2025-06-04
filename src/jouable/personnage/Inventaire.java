package jouable.personnage;

import objet.Equipement;
import objet.arme.Arme;
import objet.armure.Armure;

import java.util.ArrayList;
import java.util.List;

public class Inventaire {

    private List<Equipement> m_inventaire;

    public Inventaire()
    {
        m_inventaire = new ArrayList<>();
    }

    public Inventaire(List<Equipement> inventaire)
    {
        m_inventaire = inventaire;
    }

    public List<Equipement> getInventaire()
    {
        return m_inventaire;
    }

    public void ajouterEquipement(Equipement item)
    {
        m_inventaire.add(item);
    }

    public void retirerEquipement(Equipement item)
    {
        m_inventaire.remove(item);
    }

    public Equipement getEquipement(Equipement item)
    {
        return m_inventaire.get(m_inventaire.indexOf(item));
    }

    public void setInventaire(List<Equipement> equipements)
    {
        m_inventaire = equipements;
    }
    @Override
    public String toString()
    {
        String inventaire= "L'inventaire est composé de:\n\n";
        String armes = "Armes :\n";
        String armures = "Armures :\n";

        for (int i = 0; i < m_inventaire.size(); i++) {
            Equipement e = m_inventaire.get(i);

            if (e instanceof Arme) {
                armes += "- " + e + "\n";
            } else if (e instanceof Armure) {
                armures += "- " + e + "\n";
            }
        }

        return inventaire+armes + armures;
    }
}
