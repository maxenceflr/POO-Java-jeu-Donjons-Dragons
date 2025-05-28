package donjon;

import jouable.Jouable;

public class Donjon
{
    private final int m_longueur;
    private final int m_largeur;
    private PositionsJouables m_positionsJouable;
    private PositionsEquipement m_positionsEquipement;
    private PositionsObstacle m_positionsObstacle;

    public Donjon(int longueur, int largeur, PositionsJouables jouable, PositionsEquipement equipement, PositionsObstacle obstacle)
    {
        m_longueur = longueur;
        m_largeur = largeur;
        m_positionsEquipement = equipement;
        m_positionsJouable = jouable;
        m_positionsObstacle = obstacle;
    }

    public Donjon(int longueur, int largeur)
    {
        this(longueur, largeur, new PositionsJouables(), new PositionsEquipement(), new PositionsObstacle());
    }

    public Donjon()
    {
        this(25,25);
    }

    public boolean estPrise(Position position)
    {
        return m_positionsObstacle.containsObstacle(position) || m_positionsJouable.containsJouable(position) || m_positionsEquipement.containsEquipement(position);
    }

    public String toString()
    {
        return "Longueur du Donjon: " + Integer.toString(m_longueur) + "cases."
                + "\nLargeur du Donjon: " + Integer.toString(m_largeur) + "cases.";
    }

    public int getLargeur() {
        return m_largeur;
    }

    public int getLongueur() {
        return m_longueur;
    }

    public static double getDistance(Jouable j1, Jouable j2)
    {
            int x1 = j1.getPosition().getX();
            int x2 = j2.getPosition().getX();

            int y1 = j1.getPosition().getY();
            int y2 = j2.getPosition().getY();

            return Math.sqrt( ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)) );
    }

    public PositionsJouables getPositionsJouables() {
        return m_positionsJouable;
    }

    public PositionsEquipement getPositionsEquipement() {
        return m_positionsEquipement;
    }

    public PositionsObstacle getPositionsObstacle() {
        return m_positionsObstacle;
    }
}
