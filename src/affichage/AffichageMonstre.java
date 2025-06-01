package affichage;

import jouable.Monstre;
import jouable.personnage.AffichagePersonnageInterface;

import java.util.Scanner;
import partie.*;
import stats.CaracteristiquesBase;

public class AffichageMonstre{
    public static int choisirEspece()
    {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Choisissez l'espèce du monstre ===");
            System.out.println("1 - Gobelin");
            System.out.println("2 - Dragon");
            System.out.println("3 - Démogorgon");
            System.out.println("4 - Monstre personnalisé");
            System.out.print("Votre choix : ");

            String saisie = scanner.nextLine().trim();
            try {
                int choix = Integer.parseInt(saisie);
                if (choix >= 1 && choix <= 4) {
                    return choix;
                } else {
                    System.out.println("Choix invalide. Veuillez entrer 1, 2 ou 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
            }
        }

    }
    public static String choisirEspecePersonaliser() {
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
            System.out.print("Entrez les dégâts que votre attaque inflige (nombre entier positif) : ");
            String saisie = scanner.nextLine().trim();
            try {
                int porter = Integer.parseInt(saisie);
                if (porter > 0) {
                    return porter;
                } else {
                    System.out.println("La poertée doit être un entier strictement positif.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez saisir un nombre entier.");
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

    public static void afficherCaracteristiaque(Monstre monstr) {
        System.out.println("Les caracteristiques du monstre sont :");
        System.out.println("- CurrentPv : " + monstr.getCurrentPv());
        System.out.println("- PvMax : " + monstr.getPvMax());
        System.out.println("- Dexteriter : " + monstr.getDexterite());
        System.out.println("- Force : " + monstr.getForce());
        System.out.println("- Vitesse : " + monstr.getVitesse());
        System.out.println("- Initiative : " + monstr.getInitiative());
        System.out.println("- "+ monstr.getNomArmure()+" avec une protection de ");
    }





}
