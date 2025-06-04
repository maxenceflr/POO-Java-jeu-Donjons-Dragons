package donjon;

import java.util.List;

import affichage.AffichageDonjon;
import jouable.Jouable;
import jouable.personnage.Personnage;
import objet.Equipement;

public class Donjon
{
    private final int m_longueur;
    private final int m_largeur;
    private PositionsJouables m_positionsJouable;
    private PositionsEquipement m_positionsEquipement;
    private PositionsObstacle m_positionsObstacle;
    private final String m_nom;

    public Donjon(List<Personnage> listePersonnages)
    {
        AffichageDonjon af = new AffichageDonjon();
        af.commencerCreation();
        m_nom= af.demanderNomDonjon();
        m_longueur = af.demanderLongeur();
        m_largeur = af.demanderLargeur();
        m_positionsObstacle = af.PlacerObstacle(this);
        m_positionsEquipement = af.placerEquipement(this);
        m_positionsJouable = af.PlacerPersonnages(listePersonnages,this);
        System.out.println(m_positionsEquipement.toString());
        System.out.println(m_positionsObstacle.toString());
        af.afficherDonjon(this);

    }

    public Donjon(int longueur, int largeur, PositionsJouables jouable, PositionsEquipement equipement, PositionsObstacle obstacle)
    {
        m_longueur = longueur;
        m_largeur = largeur;
        m_positionsEquipement = equipement;
        m_positionsJouable = jouable;
        m_positionsObstacle = obstacle;
        m_nom="Donjon";
    }


    public Donjon(int longueur, int largeur)
    {
        this(longueur, largeur, new PositionsJouables(), new PositionsEquipement(), new PositionsObstacle());
    }



    public Donjon()
    {
        this(25,25);
    }
    public String getNom()
    {
        return m_nom;
    }


    public int getLargeur() {
        return m_largeur;
    }

    public int getLongueur() {
        return m_longueur;
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

    public boolean estPrise(Position position)
    {
        return m_positionsObstacle.containsObstacle(position) || m_positionsJouable.containsJouable(position) || m_positionsEquipement.containsEquipement(position);
    }

    public Position getPositionFromJouable(Jouable jouable)
    {
        return this.m_positionsJouable.getPositionJouable(jouable);
    }

    public Jouable getJouableFromPosition(Position position)
    {
        return this.getPositionsJouables().getJouableFromPosition(position);
    }

    public Equipement getEquipementFromPosition(Position position)
    {
        return this.getPositionsEquipement().getEquipementFromPosition(position);
    }

    public static double getDistance(Position p1, Position p2)
    {
            int x1 = p1.getX();
            int x2 = p2.getX();

            int y1 = p1.getY();
            int y2 = p2.getY();

            return Math.sqrt( ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)) );
    }

    public String toString()
    {
        return "Longueur du Donjon: " + Integer.toString(m_longueur) + "cases."
                + "\nLargeur du Donjon: " + Integer.toString(m_largeur) + "cases.";
    }
}
