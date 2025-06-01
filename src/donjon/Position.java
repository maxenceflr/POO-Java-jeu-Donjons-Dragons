package donjon;

import java.util.Objects;

public class Position {
    private int m_x;
    private int m_y;

    public Position(int x, int y) {
        m_x = x;
        m_y = y;
    }

    public Position() {
        m_x = 0;
        m_y = 0;
    }

    public Position(Position other) {
        m_x = other.m_x;
        m_y = other.m_y;
    }

    public int getX() {
        return m_x;
    }

    public int getY() {
        return m_y;
    }

    public void setX(int m_x) {
        this.m_x = m_x;
    }

    public void setY(int m_y) {
        this.m_y = m_y;
    }


    @Override
    public boolean equals(Object other) {
        //Run Time Type Information!
        if (other == null || other.getClass() != getClass()) {
            return false;
        } else {
            Position conversion = (Position) other;
            return m_x == conversion.m_x && m_y == conversion.m_y;
        }
    }

    @Override
    public String toString()
    {
        return "(" + Integer.toString(m_x) + ", " + Integer.toString(m_y) + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(m_x + m_y); // génère un hash basé sur le champ name
    }
}