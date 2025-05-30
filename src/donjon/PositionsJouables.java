package donjon;
import jouable.Jouable;
import objet.Equipement;

import java.util.HashMap;
import java.util.Map;

public class PositionsJouables
{
    private HashMap<Position, Jouable> m_positionsJouable;

    public PositionsJouables()
    {
        m_positionsJouable= new HashMap<Position, Jouable>();
    }

    public void ajouterJouable(Jouable jouable, Position position)
    {
        m_positionsJouable.put(position, jouable);
    }

    public Position getPositionJouable(Jouable jouable)
    {
        for (Map.Entry<Position, Jouable> elt : m_positionsJouable.entrySet())
        {
            if (elt.getValue() == jouable)
            {
                return elt.getKey();
            }
        }

        return new Position(-1, -1);
    }

    public Jouable getJouableFromPosition(Position position)
    {
        return m_positionsJouable.get(position);
    }

    public boolean deplacerJouable(Jouable jouable, Position position)
    {
        if (!m_positionsJouable.containsKey(position))
        {
            this.ajouterJouable(jouable, position);
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

    public HashMap<Position, Jouable> getPositions()
    {
        return m_positionsJouable;
    }

    @Override
    public String toString()
    {
        return "";
    }

}
