package donjon;

public class Affichage implements AffichageDonjon{

    public String afficherHautDeCarte(Donjon donjon)
    {
        char[] alphabetMajuscule = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z'
        };

        String result = "    ";

        for (int i = 0; i < donjon.getLongueur(); i++)
        {
            result += alphabetMajuscule[i] + " ";
        }

        result += "\n   *--";

        for (int i = 0; i < donjon.getLongueur(); i++)
        {
            result += "---";
        }

        result += "*\n";

        return result;
    }

    public String afficherBasDeCarte(Donjon donjon)
    {
        String result = "  *--";

        for (int i = 0; i < donjon.getLongueur(); i++)
        {
            result += "---";
        }

        result += "*\n    * Equipement  |  [ ] Obstacle  |";

        return result;
    }

    public String afficherDonjon(Donjon donjon)
    {
        String renduDonjon = "";
        Position currentPos = new Position();

        for(int i = 0; i < donjon.getLargeur(); i++)
        {
            renduDonjon += Integer.toString(i) + "  |  ";

            for(int j = 0; j < donjon.getLargeur(); j++)
            {
                currentPos.setX(j);
                currentPos.setY(i);

                if (donjon.getPositionsEquipement().containsEquipement(currentPos))
                {
                    renduDonjon += donjon.getPositionsEquipement().getEquipementFromPosition(currentPos).getSymbole() + "  ";
                }
                else if(donjon.getPositionsJouables().containsJouable(currentPos))
                {
                    renduDonjon += donjon.getPositionsJouables().getPositions().get(currentPos).getSymbole() + "  ";
                }
                else if(donjon.getPositionsObstacle().containsObstacle(currentPos))
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
}
