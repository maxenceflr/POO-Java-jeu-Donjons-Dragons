package donjon;

public class Position {
    private int m_x;
    private int m_y;

    public Position(int x, int y)
    {
        m_x = x;
        m_y = y;
    }

    public int getX() {
        return m_x;
    }

    public int getY() {
        return m_y;
    }
}
