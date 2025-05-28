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

    public String toString()
    {
        return "Longueur du Donjon: " + Integer.toString(m_longueur) + "cases."
                + "\nLargeur du Donjon: " + Integer.toString(m_largeur) + "cases.";
    }

    public String afficherHautDeCarte()
    {
        char[] alphabetMajuscule = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z'
        };

        String result = "    ";

        for (int i = 0; i < this.m_longueur; i++)
        {
            result += alphabetMajuscule[i] + " ";
        }

        result += "\n   *--";

        for (int i = 0; i < this.m_longueur; i++)
        {
            result += "---";
        }

        result += "*\n";

        return result;
    }

    public String afficherBasDeCarte()
    {
        String result = "  *--";

        for (int i = 0; i < this.m_longueur; i++)
        {
            result += "---";
        }

        result += "*\n    * Equipement  |  [ ] Obstacle  |";

        return result;
    }

    public String afficherDonjon()
    {
        String renduDonjon = "";
        Position currentPos = new Position();

        for(int i = 0; i < m_largeur; i++)
        {
            renduDonjon += Integer.toString(i) + "  |  ";

            for(int j = 0; j < m_longueur; j++)
            {
                currentPos.setX(j);
                currentPos.setY(i);

                if (this.m_positionsEquipement.containsEquipement(currentPos))
                {
                    renduDonjon += this.m_positionsEquipement.getPositions().get(currentPos).getSymbole() + "  ";
                }
                else if(this.m_positionsJouable.containsJouable(currentPos))
                {
                    renduDonjon += this.m_positionsJouable.getPositions().get(currentPos).getSymbole() + "  ";
                }
                else if(this.m_positionsObstacle.containsObstacle(currentPos))
                {
                    renduDonjon += "[ ]  ";
                }
                else
                {
                    renduDonjon += ".  ";
                }
            }
            renduDonjon += Integer.toString(i) + "|\n";
        }

        return renduDonjon;
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
