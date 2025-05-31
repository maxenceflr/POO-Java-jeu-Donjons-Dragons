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

        System.out.println("L'obstacle a ete ajouter au "+ position.toString());
        m_positionsObstacle.add(position);
    }

    public void retirerObstacle(Position position)
    {
        m_positionsObstacle.remove(position);
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Positions des obstacles :\n");
        for (Position pos : m_positionsObstacle) {
            sb.append("Obstacle en position (" + pos.getX() + ", " + pos.getY() + ")\n");
        }
        return sb.toString();
    }


}
