package donjon;

import java.util.ArrayList;

public class PositionsObstacle
{
    private ArrayList<Position> m_positionsObstacle;

    public PositionsObstacle()
    {
        m_positionsObstacle= new ArrayList<Position>();
    }

    public void ajouterObstacle(Position position)
    {
        m_positionsObstacle.add(position);
    }

    public ArrayList<Position> getPosition()
    {
        return m_positionsObstacle;
    }

    public boolean containsObstacle(Position position)
    {
        return m_positionsObstacle.contains(position);
    }

    @Override
    public String toString()
    {
        return "";
    }
}
