package donjon;
import objet.Equipement;

import java.util.HashMap;

public class PositionsJouables
{
    private HashMap<Position, Equipement> m_positionsJouable;

    public PositionsJouables()
    {
        m_positionsJouable= new HashMap<Position, Equipement>();
    }

    public void ajouterJouable(Equipement equipement, Position position)
    {
        m_positionsJouable.put(position, equipement);
    }

    public boolean deplacerJouable(Equipement equipement, Position position)
    {
        if (!m_positionsJouable.containsKey(position))
        {
            this.ajouterJouable(equipement, position);
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean containsJouable(Position position)
    {
        return m_positionsJouable.containsKey(position);
    }

    public HashMap<Position, Equipement> getPositions()
    {
        return m_positionsJouable;
    }

    @Override
    public String toString()
    {
        return "";
    }
}
