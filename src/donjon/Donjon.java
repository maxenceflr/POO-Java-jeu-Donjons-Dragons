package donjon;

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
}
