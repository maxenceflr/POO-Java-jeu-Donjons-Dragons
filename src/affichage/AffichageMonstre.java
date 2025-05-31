package affichage;

import jouable.personnage.AffichagePersonnageInterface;

import java.util.Scanner;
import partie.*;
import stats.CaracteristiquesBase;

public class AffichageMonstre{
    public static String choisirEspece() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Entrez l'espece de votre Monstre (puis appuyez sur Entrée) : ");
            String nom = scanner.nextLine().trim();

            if (!nom.isEmpty()) {
                return nom;
            } else {
                System.out.println("L' espece ne peut pas être vide. Appuyez sur Entrée après avoir saisi un nom.");
            }
        }
    }
    public static String choisirRepresentation() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Entrez la représentation de votre Monstre sur le plateau (3 caractères max) : ");
            String nom = scanner.nextLine().trim();

            if (!nom.isEmpty() && nom.length() <= 3) {
                return nom;
            } else if (nom.isEmpty()) {
                System.out.println("La représentation ne peut pas être vide. Veuillez réessayer.");
            } else {
                System.out.println("La représentation doit contenir au maximum 3 caractères. Veuillez réessayer.");
            }
        }
    }
    public static De choisirDegatAttaque() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Entrez les dégâts que votre attaque inflige (nombre entier positif) : ");
            String saisie = scanner.nextLine().trim();

            try {
                int degats = Integer.parseInt(saisie);
                if (degats > 0) {
                    De de =new De(1,degats);
                    return de;
                } else {
                    System.out.println("Les dégâts doivent être un entier strictement positif.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez saisir un nombre entier.");
            }
        }
    }
    public static int choisirPorterAttaque() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Voulez-vous porter une attaque ? (oui/non) : ");
            String reponse = scanner.nextLine().trim().toLowerCase();

            if (reponse.equals("oui")) {
                return 1;
            } else if (reponse.equals("non")) {
                return 0;
            } else {
                System.out.println("Réponse invalide. Veuillez taper 'oui' ou 'non'.");
            }
        }
    }
    public static CaracteristiquesBase choisirCaracteristiques() {
        Scanner scanner = new Scanner(System.in);
        int force, vitesse, initiative, dexterite, pv, armure;

        System.out.println("=== Définissez les caractéristiques de votre monstre ===");

        force = demanderEntier(scanner, "Force");
        vitesse = demanderEntier(scanner, "Vitesse");
        initiative = demanderEntier(scanner, "Initiative");
        dexterite = demanderEntier(scanner, "Dextérité");
        pv = demanderEntier(scanner, "Points de vie (PV)");
        armure = choisirArmure();

        CaracteristiquesBase carac = new CaracteristiquesBase();
        carac.setForce(force);
        carac.setVitesse(vitesse);
        carac.setInitiative(initiative);
        carac.setDexterite(dexterite);
        carac.setPvMax(pv);
        carac.setCurrentPv(pv);
        carac.setArmure(armure);

        return carac;
    }
    public static int choisirArmure() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choisissez une armure :");
            System.out.println("1 - Armure d'écaille");
            System.out.println("2 - Cotte de maille");
            System.out.println("3 - Demi-plate");
            System.out.println("4 - Harmois");
            System.out.print("Votre choix : ");

            String saisie = scanner.nextLine().trim();
            try {
                int choix = Integer.parseInt(saisie);
                switch (choix) {
                    case 1:
                        return 9;
                    case 2:
                        return 11;
                    case 3:
                        return 10;
                    case 4:
                        return 12;
                    default:
                        System.out.println("Choix invalide. Veuillez entrer un nombre entre 1 et 6.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier.\n");
            }
        }
    }

    private static int demanderEntier(Scanner scanner, String nomChamp) {
        while (true) {
            System.out.print(nomChamp + " : ");
            String saisie = scanner.nextLine().trim();
            try {
                int valeur = Integer.parseInt(saisie);
                if (valeur >= 0) {
                    return valeur;
                } else {
                    System.out.println("Veuillez entrer un entier positif ou nul.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
            }
        }
    }

    public static void afficherCaracteristiaque(Integer CurrentPv, Integer PvMax, Integer Dexteriter, Integer Force, Integer Vitesse, Integer Initiative, Integer ClassArmure) {
        System.out.println("Les caracteristiques du joueur sont :");
        System.out.println("- CurrentPv : " + CurrentPv);
        System.out.println("- PvMax : " + PvMax);
        System.out.println("- Dexteriter : " + Dexteriter);
        System.out.println("- Force : " + Force);
        System.out.println("- Vitesse : " + Vitesse);
        System.out.println("- Initiative : " + Initiative);
        System.out.println("- Class d'Armure: " + ClassArmure);
    }





}
