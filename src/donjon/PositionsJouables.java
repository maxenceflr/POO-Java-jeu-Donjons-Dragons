package donjon;
import jouable.ActionResult;
import jouable.Jouable;
import objet.Equipement;
import partie.De;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jouable.ActionResult.*;


public class PositionsJouables
{
    private HashMap<Position, Jouable> m_positionsJouable;

    public PositionsJouables()
    {
        m_positionsJouable= new HashMap<Position, Jouable>();
    }

    public void ajouterJouable(Jouable jouable, Position position)
    {
        jouable.ajouterJouable(position, this);
        //m_positionsJouable.put(position, jouable);
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
    public int attaqueDuMj(Jouable j, De de)
    {
        int pv=j.getCurrentPv();
        int somme =de.jeter();
        System.out.println(j.toString());
        j.setCurrentPv(pv-somme);
        return somme;
    }


    public Jouable getJouableFromPosition(Position position)
    {
        return m_positionsJouable.get(position);
    }

    public ActionResult deplacerJouable(Jouable jouable, Position position, Donjon donjon)
    {
            Position positionJouable = new Position(this.getPositionJouable(jouable));

            if (!donjon.positionInDonjon(position))
            {
                return OUT_OF_BONDS;
            }
            else if (Donjon.getDistance(positionJouable, position) > (double)jouable.getVitesse() / 3) {
                return OUT_OF_REACH;
            }
            else if (donjon.getPositionsObstacle().containsObstacle(position))
            {
                return OBSTACLE;
            } else if (donjon.getPositionsJouables().containsJouable(position))
            {
                return OCCUPIED_POSITION;
            } else
            {

                this.m_positionsJouable.remove(positionJouable);
                this.ajouterJouable(jouable, position);
                return SUCCESS;
            }
    }


    public ActionResult deplacementMj(Jouable jouable, Position futurPosition, Donjon donjon) {
        PositionsJouables positionsJouables = donjon.getPositionsJouables();
        PositionsEquipement positionsEquipement = donjon.getPositionsEquipement();
        PositionsObstacle positionsObstacle = donjon.getPositionsObstacle();

        if (positionsJouables.containsJouable(futurPosition)) {
            return ActionResult.OCCUPIED_POSITION;
        }

        if (positionsEquipement.containsEquipement(futurPosition)) {
            return ActionResult.ITEM;
        }

        if (positionsObstacle.containsObstacle(futurPosition)) {
            return ActionResult.OBSTACLE;
        }


        Position posActuel =this.getPositionJouable(jouable);
        this.m_positionsJouable.remove(posActuel);
        positionsJouables.ajouterJouable(jouable, futurPosition);

        return ActionResult.SUCCESS;

    }


    public boolean containsJouable(Position position)
    {
        return m_positionsJouable.containsKey(position);
    }

    public HashMap<Position, Jouable> getPositions()
    {
        return m_positionsJouable;
    }

    public Jouable getJouableByIndex(int index) {
        int i = 0;
        for (Jouable jouable : m_positionsJouable.values()) {
            if (i == index) {
                return jouable;
            }
            i++;
        }
        return null; // ou tu peux lancer une exception si tu préfères
    }


    public int size() {
        return this.m_positionsJouable.size();
    }
    public List<Jouable> getListeJouables() {
        return new ArrayList<>(m_positionsJouable.values());
    }

    @Override
    public String toString()
    {
        String result = "";

        for (Map.Entry<Position, Jouable> elt : m_positionsJouable.entrySet()) {
            result += elt.getKey().toString() + " : " + elt.getValue().toString();
        }
        return result;
    }

}
