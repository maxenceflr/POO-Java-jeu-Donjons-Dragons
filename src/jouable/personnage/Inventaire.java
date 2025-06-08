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
    public Equipement getEquipement(int index) {
        if (index >= 0 && index < m_inventaire.size()) {
            return m_inventaire.get(index);
        } else {
            throw new IndexOutOfBoundsException("Indice d'équipement invalide : " + index);
        }
    }

    public void setInventaire(List<Equipement> equipements)
    {
        m_inventaire = equipements;
    }
    public int getNbEquipement() {
        return m_inventaire.size();
    }

    @Override
    public String toString()
    {
        String result = "";

        for (int i = 0; i < m_inventaire.size(); i++)
        {
            Equipement e = m_inventaire.get(i);

            result += "[" + Integer.toString(i+1) + "] " + e.getNomEquipement() + " ";
        }

        return  result;
    }
}
