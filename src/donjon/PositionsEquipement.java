package donjon;

import objet.Equipement;

import java.util.HashMap;

public class PositionsEquipement
{
    private HashMap<Position, Equipement> m_positionsEquipement;

    public PositionsEquipement()
    {
        m_positionsEquipement= new HashMap<Position, Equipement>();
    }

    public void ajouterEquipement(Equipement equipement, Position position)
    {
        m_positionsEquipement.put(position, equipement);
    }

    public boolean deplacerEquipement(Equipement equipement, Position position)
    {
        if (!m_positionsEquipement.containsKey(position))
        {
            this.ajouterEquipement(equipement, position);
            return true;
        }
        else
        {
            return false;
        }
    }

    public HashMap<Position, Equipement> getPositions()
    {
        return m_positionsEquipement;
    }

    public boolean containsEquipement(Position position)
    {
        return m_positionsEquipement.containsKey(position);
    }

    @Override
    public String toString()
    {
        return "";
    }
}
