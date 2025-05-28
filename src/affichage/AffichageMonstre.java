package affichage;

import jouable.personnage.AffichagePersonnageInterface;

import java.util.Scanner;
import partie.*;

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
