package donjon;

public class Position {
    private int m_x;
    private int m_y;

    public Position(int x, int y)
    {
        m_x = x;
        m_y = y;
    }

    public Position()
    {
        m_x = 0;
        m_y = 0;
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
}
