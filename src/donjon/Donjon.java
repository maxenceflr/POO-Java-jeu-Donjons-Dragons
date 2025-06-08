package donjon;

import java.util.List;

import affichage.AffichageDonjon;
import jouable.ActionResult;
import jouable.Jouable;
import jouable.Monstre;
import jouable.personnage.Personnage;
import objet.Equipement;
import objet.arme.armecourante.MasseDarme;
import objet.arme.armedeguerre.Rapiere;
import objet.armure.armurelegere.ArmureEcailles;
import objet.armure.armurelegere.DemiPlate;

import static jouable.ActionResult.*;
import static jouable.Monstre.creerGobelin;

public class Donjon
{
    private final int m_longueur;
    private final int m_largeur;
    private PositionsJouables m_positionsJouable;
    private PositionsEquipement m_positionsEquipement;
    private PositionsObstacle m_positionsObstacle;
    private String m_nom;

    public Donjon(List<Personnage> listePersonnages)
    {
        AffichageDonjon af = new AffichageDonjon();

        if(af.commencerCreation()==1) {
            m_nom = af.demanderNomDonjon();
            m_longueur = af.demanderLongeur();
            m_largeur = af.demanderLargeur();
            m_positionsObstacle = af.PlacerObstacle(this);
            m_positionsEquipement = af.placerEquipement(this);
            m_positionsJouable = af.PlacerPersonnages(listePersonnages, this);
            System.out.println(m_positionsEquipement.toString());
            System.out.println(m_positionsObstacle.toString());
            af.afficherDonjon(this);
        }
        else {
            Donjon donjonPrefait;

            switch (af.demanderChoixDonjon()) {
                case 1:
                    donjonPrefait = creerDonjonRichesse(listePersonnages);
                    break;
                case 2:
                    donjonPrefait = creerLabyrinthe(listePersonnages);
                    break;
                case 3:
                    donjonPrefait= creerDonjonDesGobelins(listePersonnages);
                default:
                    donjonPrefait= creerDonjonDesGobelins(listePersonnages);
            }

            // Copier les champs du donjon préfait dans this
            this.m_nom = donjonPrefait.m_nom;
            this.m_longueur = donjonPrefait.m_longueur;
            this.m_largeur = donjonPrefait.m_largeur;
            this.m_positionsJouable = donjonPrefait.m_positionsJouable;
            this.m_positionsEquipement = donjonPrefait.m_positionsEquipement;
            this.m_positionsObstacle = donjonPrefait.m_positionsObstacle;
        }

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
    public static Donjon creerDonjonRichesse(List<Personnage> listePersonnages) {

        Donjon donjon = new Donjon(15, 21); // Dimensions du donjon

        int x = 1;
        int y = 2;
        donjon.m_nom="Donjon de la Richesse";

        for (Personnage p : listePersonnages) {
            Position posPersonnage = new Position(x, y);
            Position posArme = new Position(x-1, y-1);
            Position posArmur = new Position(x, y-1);
            donjon.getPositionsJouables().ajouterJouable(p, posPersonnage);
            donjon.getPositionsEquipement().ajouterEquipement(new Rapiere(),posArme);
            donjon.getPositionsEquipement().ajouterEquipement(new ArmureEcailles(),posArmur);

            x += 2;
            y += 2;
        }

        Position posMonstre = new Position(7, 1);
        Monstre gobelin=creerGobelin();
        donjon.getPositionsJouables().ajouterJouable(gobelin,posMonstre);
        return donjon;
    }
    public Donjon creerLabyrinthe(List<Personnage> listePersonnages)
    {
        {
            int largeur = 21;
            int longueur = 15;

            PositionsJouables positionsJouables = new PositionsJouables();
            PositionsEquipement positionsEquipement = new PositionsEquipement();
            PositionsObstacle positionsObstacle = new PositionsObstacle();

            Donjon donjon = new Donjon(longueur, largeur, positionsJouables, positionsEquipement, positionsObstacle);
            donjon.m_nom="Donjon du Labyrinthe";

            int x = 1;
            for (Personnage p : listePersonnages) {
                Position pos = new Position(x, 0);
                positionsJouables.ajouterJouable(p, pos);
                x += 1;
            }

            Position posMonstre = new Position(longueur - 2, largeur / 2);
            Monstre gobelin = creerGobelin();
            positionsJouables.ajouterJouable(gobelin, posMonstre);

            for (int i = 1; i < largeur; i++) {
                positionsObstacle.ajouterObstacle(new Position(0, i));
                positionsObstacle.ajouterObstacle(new Position(longueur - 1, i));
            }


            for (int i = 2; i < longueur - 2; i += 2) {
                positionsObstacle.ajouterObstacle(new Position(i, 5));
                positionsObstacle.ajouterObstacle(new Position(i, 10));
                positionsObstacle.ajouterObstacle(new Position(i, 15));
            }

            return donjon;
        }
    }
    public static Donjon creerDonjonDesGobelins(List<Personnage> listePersonnages) {
        int largeur = 17;
        int longueur = 11;

        PositionsJouables positionsJouables = new PositionsJouables();
        PositionsEquipement positionsEquipement = new PositionsEquipement();
        PositionsObstacle positionsObstacle = new PositionsObstacle();

        Donjon donjon = new Donjon(longueur, largeur, positionsJouables, positionsEquipement, positionsObstacle);
        donjon.m_nom = "Donjon des Gobelins";

        int y = 1;
        for (Personnage p : listePersonnages) {
            positionsJouables.ajouterJouable(p, new Position(0, y));
            y += 2;
        }


        int[][] positionsGobelins = {
                {3, 5}, {5, 7}, {7, 3}, {9, 10}
        };

        for (int[] pos : positionsGobelins) {
            Monstre gobelin = creerGobelin();
            positionsJouables.ajouterJouable(gobelin, new Position(pos[0], pos[1]));
        }

        positionsEquipement.ajouterEquipement(new MasseDarme(), new Position(2, 2));
        positionsEquipement.ajouterEquipement(new DemiPlate(), new Position(8, 4));




        int[][] murs = {
                {3, 3}, {3, 4}, {4, 4},
                {6, 6}, {7, 6}, {7, 5},
                {8, 9}, {8, 10}, {9, 10}
        };

        for (int[] m : murs) {
            positionsObstacle.ajouterObstacle(new Position(m[0], m[1]));
        }

        return donjon;
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
    public ActionResult ajoutObstacleMj(Position pos)
    {
        PositionsJouables positionJ =this.getPositionsJouables();
        if(positionJ.containsJouable(pos))
        {
            PositionsEquipement positionE =this.getPositionsEquipement();
            if(positionE.containsEquipement(pos))
            {
                PositionsObstacle positionsO = this.getPositionsObstacle();
                if(positionsO.containsObstacle(pos))
                {
                    positionsO.ajouterObstacle(pos);
                    return SUCCESS;
                }
                return OBSTACLE;
            }
            return ITEM;

        }
        return OCCUPIED_POSITION;

    }

    public String toString()
    {
        return "Longueur du Donjon: " + Integer.toString(m_longueur) + "cases."
                + "\nLargeur du Donjon: " + Integer.toString(m_largeur) + "cases.";
    }
}
