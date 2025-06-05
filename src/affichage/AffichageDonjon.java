package affichage;
import donjon.*;
import jouable.Monstre;
import jouable.personnage.Personnage;
import objet.arme.*;
import objet.arme.armecourante.*;
import objet.arme.armedeguerre.*;
import objet.arme.armedistance.*;
import objet.armure.armurelegere.*;
import objet.armure.armurelourde.*;
import java.util.Set;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class AffichageDonjon implements AffichageDonjonInterface {


    private Scanner scanner = new Scanner(System.in);

    public static void afficherDonjon(Donjon donjon) {
        char[] alphabetMajuscule = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z'
        };

        String result = "      ";

        for (int i = 0; i < donjon.getLongueur(); i++) {
            result += alphabetMajuscule[i] + "  ";
        }

        result += "\n   *--";

        for (int i = 0; i < donjon.getLongueur(); i++) {
            result += "---";
        }

        result += "*";

        System.out.println(result);

        String renduDonjon = "";
        Position currentPos = new Position();

        for (int i = 0; i < donjon.getLargeur(); i++) {
            currentPos.setY(i);

            if (i > 9)
            {
                renduDonjon += Integer.toString(i) + " | ";
            }
            else
            {
                renduDonjon += Integer.toString(i) + "  | ";
            }

            for (int j = 0; j < donjon.getLongueur(); j++) {
                currentPos.setX(j);



                if (donjon.getPositionsJouables().containsJouable(currentPos))
                {
                    renduDonjon += donjon.getPositionsJouables().getPositions().get(currentPos).getSymbole();
                }
                else if (donjon.getPositionsEquipement().containsEquipement(currentPos))
                {
                    renduDonjon += " " + donjon.getPositionsEquipement().getEquipementFromPosition(currentPos).getSymbole() + " ";
                } else if (donjon.getPositionsObstacle().containsObstacle(currentPos))
                {
                    renduDonjon += "[ ]";
                } else {
                    renduDonjon += " . ";
                }
            }
            renduDonjon += " |\n";
        }

        System.out.print(renduDonjon);

        String res = "   *--";

        for (int i = 0; i < donjon.getLongueur(); i++) {
            res += "---";
        }

        res += "*\n    * Equipement  |  [ ] Obstacle  |";

        System.out.println(res);
    }
    public void commencerCreation()
    {
        System.out.println("Creation d'un nouveu donjon");
    }
    public String demanderNomDonjon()
    {
        System.out.println("Quel est le nom de ce donjon?( ex: Donjon du l'aube");
        String nom = scanner.nextLine();
        return nom;
    }

    public int demanderLargeur() {
        int largeur;
        do {
            System.out.print("Veuillez entrer une largeur entre 15 et 25 : ");
            largeur = scanner.nextInt();
        } while (largeur < 15 || largeur > 25);
        return largeur;
    }


    public int demanderLongeur() {
        int longeur;
        do {
            System.out.print("Veuillez entrer une longueur entre 15 et 25 : ");
            longeur = scanner.nextInt();
        } while (longeur < 15 || longeur > 25);
        return longeur;
    }


    public Position demanderPositionObstacle(Donjon donjon, PositionsObstacle PO) {
        int largeurDonjon = donjon.getLargeur();
        int longeurDonjon = donjon.getLongueur();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Demande de la longeur (ligne)
            int longeur;
            do {
                System.out.print("Veuillez entrer la ligne (entre 1 et " + longeurDonjon + ") : ");
                longeur = scanner.nextInt();
            } while (longeur < 1 || longeur > longeurDonjon);

            // Demande de la largeur (colonne) sous forme de lettre
            char maxLettre = (char) ('A' + largeurDonjon - 1);
            char lettreColonne;
            while (true) {
                System.out.print("Veuillez entrer la colonne (lettre entre A et " + maxLettre + ") : ");
                String saisie = scanner.next().toUpperCase();
                if (saisie.length() == 1) {
                    lettreColonne = saisie.charAt(0);
                    if (lettreColonne >= 'A' && lettreColonne <= maxLettre)
                        break;
                }
                System.out.println("Entrée invalide. Réessayez.");
            }

            int colonne = lettreColonne - 'A' + 1;

            Position pos = new Position(longeur, colonne);

            if (PO.containsObstacle(pos)) {
                System.out.println("Cette position est déjà occupée par un Obstacle.");
            } else {
                return pos;  // Position libre
            }
        }
    }

    public PositionsObstacle PlacerObstacle(Donjon donjon) {
        PositionsObstacle PO = new PositionsObstacle();
        boolean continuer = true;
        Scanner scanner = new Scanner(System.in);

        while (continuer) {
            System.out.println("Que souhaitez-vous faire ?");
            System.out.println("1 - Ajouter un obstacle");
            System.out.println("2 - Terminer");

            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    Position nouvPos = demanderPositionObstacle(donjon, PO);
                    PO.ajouterObstacle(nouvPos);
                    break;

                case 2:
                    continuer = false;
                    break;

                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    break;
            }
        }
        return PO;
    }


    public Position demanderPositionEquipement(Donjon donjon, PositionsEquipement PE) {
        int largeurDonjon = donjon.getLargeur();
        int longeurDonjon = donjon.getLongueur();

        while (true) {
            // Demande de la longeur (ligne)
            int longeur;
            do {
                System.out.print("Veuillez entrer la ligne (entre 1 et " + longeurDonjon + ") : ");
                longeur = scanner.nextInt();
            } while (longeur < 1 || longeur > longeurDonjon);

            // Demande de la largeur (colonne) sous forme de lettre
            char maxLettre = (char) ('A' + largeurDonjon - 1);
            char lettreColonne;
            while (true) {
                System.out.print("Veuillez entrer la colonne (lettre entre A et " + maxLettre + ") : ");
                String saisie = scanner.next().toUpperCase();
                if (saisie.length() == 1) {
                    lettreColonne = saisie.charAt(0);
                    if (lettreColonne >= 'A' && lettreColonne <= maxLettre)
                        break;
                }
                System.out.println("Entrée invalide. Réessayez.");
            }

            int colonne = lettreColonne - 'A' + 1;

            Position pos = new Position(longeur, colonne);

            if (PE.containsEquipement(pos)) {
                System.out.println("Cette position est déjà occupée par un équipement.");
            } else if (donjon.getPositionsObstacle().containsObstacle(pos)) {
                System.out.println("Cette position est un obstacle, veuillez choisir une autre position.");
            } else {
                return pos;  // Position libre
            }
        }
    }

    public PositionsEquipement placerEquipement(Donjon donjon) {
        PositionsEquipement PE = new PositionsEquipement();
        boolean continuer = true;

        while (continuer) {
            System.out.println("Que souhaitez-vous faire ?");
            System.out.println("1 - Ajouter une arme");
            System.out.println("2 - Ajouter une armure");
            System.out.println("3 - Terminer");

            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("Quel type d'arme souhaitez-vous ?");
                    System.out.println("1 - Arme Courante");
                    System.out.println("2 - Arme de Guerre");
                    System.out.println("3 - Arme à Distance");

                    int choix2 = scanner.nextInt();
                    switch (choix2) {
                        case 1: // Arme courante
                            System.out.println("Laquelle de ces armes souhaitez-vous ?");
                            System.out.println("1 - Baton");
                            System.out.println("2 - Masse d'Arme");
                            int choix3 = scanner.nextInt();
                            switch (choix3) {
                                case 1: {
                                    Baton arme = new Baton();
                                    Position pos = demanderPositionEquipement(donjon, PE);
                                    PE.ajouterEquipement(arme, pos);
                                    break;
                                }
                                case 2: {
                                    MasseDarme arme = new MasseDarme();
                                    Position pos = demanderPositionEquipement(donjon, PE);
                                    PE.ajouterEquipement(arme, pos);
                                    break;
                                }
                                default:
                                    System.out.println("Choix invalide pour arme courante.");
                                    break;
                            }
                            break;

                        case 2: // Arme de guerre
                            System.out.println("Laquelle de ces armes souhaitez-vous ?");
                            System.out.println("1 - Rapière");
                            System.out.println("2 - Epée Longue");
                            choix3 = scanner.nextInt();
                            switch (choix3) {
                                case 1: {
                                    Rapiere arme = new Rapiere();
                                    Position pos = demanderPositionEquipement(donjon, PE);
                                    PE.ajouterEquipement(arme, pos);
                                    break;
                                }
                                case 2: {
                                    EpeeLongue arme = new EpeeLongue();
                                    Position pos = demanderPositionEquipement(donjon, PE);
                                    PE.ajouterEquipement(arme, pos);
                                    break;
                                }

                                default:
                                    System.out.println("Choix invalide pour arme de guerre.");
                                    break;
                            }
                            break;

                        case 3: // Arme à distance
                            System.out.println("Laquelle de ces armes souhaitez-vous ?");
                            System.out.println("1 - Arc Court");
                            System.out.println("2 - Fronde");
                            System.out.println("3 - Arbalète Légère");
                            choix3 = scanner.nextInt();
                            switch (choix3) {
                                case 1: {
                                    ArcCourt arme = new ArcCourt();
                                    Position pos = demanderPositionEquipement(donjon, PE);
                                    PE.ajouterEquipement(arme, pos);
                                    break;
                                }
                                case 2: {
                                    Fronde arme = new Fronde();
                                    Position pos = demanderPositionEquipement(donjon, PE);
                                    PE.ajouterEquipement(arme, pos);
                                    break;
                                }
                                case 3: {
                                    ArbaleteLegere arme = new ArbaleteLegere();
                                    Position pos = demanderPositionEquipement(donjon, PE);
                                    PE.ajouterEquipement(arme, pos);
                                    break;
                                }
                                default:
                                    System.out.println("Choix invalide pour arme à distance.");
                                    break;
                            }
                            break;

                        default:
                            System.out.println("Choix invalide pour type d'arme.");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("Quel type d'armure souhaitez-vous ?");
                    System.out.println("1 - Armure légère");
                    System.out.println("2 - Armure lourde");

                    int choixArmure = scanner.nextInt();
                    switch (choixArmure) {
                        case 1:
                            System.out.println("Choisissez l'armure légère :");
                            System.out.println("1 - Armure d'écailles");
                            System.out.println("2 - Demi-plate");
                            int choixArmureLegere = scanner.nextInt();
                            switch (choixArmureLegere) {
                                case 1: {
                                    ArmureEcailles armure = new ArmureEcailles();
                                    Position pos = demanderPositionEquipement(donjon, PE);
                                    PE.ajouterEquipement(armure, pos);
                                    break;
                                }
                                case 2: {
                                    DemiPlate armure = new DemiPlate();
                                    Position pos = demanderPositionEquipement(donjon, PE);
                                    PE.ajouterEquipement(armure, pos);
                                    break;
                                }
                                default:
                                    System.out.println("Choix invalide pour armure légère.");
                                    break;
                            }
                            break;

                        case 2:
                            System.out.println("Choisissez l'armure lourde :");
                            System.out.println("1 - Cotte de mailles");
                            System.out.println("2 - Harnois");
                            int choixArmureLourde = scanner.nextInt();
                            switch (choixArmureLourde) {
                                case 1: {
                                    CoteMailles armure = new CoteMailles();
                                    Position pos = demanderPositionEquipement(donjon, PE);
                                    PE.ajouterEquipement(armure, pos);
                                    break;
                                }
                                case 2: {
                                    Harnois armure = new Harnois();
                                    Position pos = demanderPositionEquipement(donjon, PE);
                                    PE.ajouterEquipement(armure, pos);
                                    break;
                                }
                                default:
                                    System.out.println("Choix invalide pour armure lourde.");
                                    break;
                            }
                            break;

                        default:
                            System.out.println("Choix invalide pour type d'armure.");
                            break;
                    }
                    break;

                case 3:
                    continuer = false;
                    break;

                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    break;
            }
        }
        return PE;
    }

    public PositionsJouables PlacerPersonnages(List<Personnage> perso, Donjon donjon) {
        PositionsJouables PJ = new PositionsJouables();
        while(true)
        {
            Monstre momo = new Monstre();
            System.out.println("Où voulez-vous le placer ?");
            Position pos = demanderPositionPersonnage(donjon, PJ); // On suppose que cette méthode existe et vérifie les collisions

            PJ.ajouterJouable(momo,pos); // On l'ajoute à la liste des positions jouables
            System.out.println("Voulez-vous ajouter un autre Monstre?(oui/non)");
            String reponse = scanner.nextLine().trim().toLowerCase();

            if (!reponse.equals("oui")||!reponse.equals("o")) {
                break; // sort de la boucle si la réponse n'est pas "oui"
            }



        }

        for (int i = 0; i < perso.size(); i++) {
            Personnage p = perso.get(i);
            System.out.println("Où voulez-vous placer " + p.getNom() + " ?");

            Position pos = demanderPositionPersonnage(donjon, PJ); // On suppose que cette méthode existe et vérifie les collisions

            PJ.ajouterJouable(p,pos); // On l'ajoute à la liste des positions jouables
        }

        return PJ;
    }


    public Position demanderPositionPersonnage(Donjon donjon, PositionsJouables PJ) {
        int largeurDonjon = donjon.getLargeur();
        int longeurDonjon = donjon.getLongueur();


        while (true) {
            // Demande de la longeur (ligne)
            int longeur;
            do {
                System.out.print("Veuillez entrer la ligne (entre 1 et " + longeurDonjon + ") : ");
                longeur = scanner.nextInt();
            } while (longeur < 1 || longeur > longeurDonjon);

            // Demande de la largeur (colonne) sous forme de lettre
            char maxLettre = (char) ('A' + largeurDonjon - 1);
            char lettreColonne;
            while (true) {
                System.out.print("Veuillez entrer la colonne (lettre entre A et " + maxLettre + ") : ");
                String saisie = scanner.next().toUpperCase();
                if (saisie.length() == 1) {
                    lettreColonne = saisie.charAt(0);
                    if (lettreColonne >= 'A' && lettreColonne <= maxLettre)
                        break;
                }
                System.out.println("Entrée invalide. Réessayez.");
            }

            int colonne = lettreColonne - 'A' + 1;

            Position pos = new Position(longeur, colonne);

            if (PJ.containsJouable(pos)) {
                System.out.println("Cette position est déjà occupée par un Personnage.");
            } else if (donjon.getPositionsEquipement().containsEquipement(pos)) {
                System.out.println("Cette position est déjà occupée par un équipement.");
            } else if (donjon.getPositionsObstacle().containsObstacle(pos)) {
                System.out.println("Cette position est un obstacle, veuillez choisir une autre position.");
            } else {
                return pos;  // Position libre
            }
        }
    }
}


