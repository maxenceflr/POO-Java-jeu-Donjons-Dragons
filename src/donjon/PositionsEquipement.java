package donjon;

import objet.Equipement;

import java.util.Map;
import java.util.Set;
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

    public Equipement getEquipementFromPosition(Position position)
    {
        return m_positionsEquipement.get(position);
    }

    public void retirerEquipement(Position position)
    {
        m_positionsEquipement.remove(position);
    }

    public HashMap<Position, Equipement> getPositionsEquipement()
    {
        return m_positionsEquipement;
    }

    public boolean containsEquipement(Position position)
    {
        return m_positionsEquipement.containsKey(position);
    }
    public Set<Position> getCasesOccupees()
    {
        return m_positionsEquipement.keySet();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Positions des équipements :\n");

        for (Map.Entry<Position, Equipement> entry : m_positionsEquipement.entrySet()) {
            sb.append("Position ").append(entry.getKey())
                    .append(" → Equipement : ").append(entry.getValue())
                    .append("\n");
        }

        return sb.toString();
    }
}
