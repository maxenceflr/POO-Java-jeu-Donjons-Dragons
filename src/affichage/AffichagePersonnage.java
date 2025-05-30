package affichage;
import java.util.Scanner;

import jouable.personnage.AffichagePersonnageInterface;
import jouable.personnage.classe.*;
import jouable.personnage.race.*;
import stats.CaracteristiquesBase;
public class AffichagePersonnage implements AffichagePersonnageInterface {


    public Integer choisirClasse(CaracteristiquesBase car) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choisissez une classe :");
            System.out.println("1 - Clerc");
            System.out.println("2 - Guerrier");
            System.out.println("3 - Magicien");
            System.out.println("4 - Roublard");
            System.out.print("Votre choix : ");

            int choix;

            try {
                choix = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                continue;
            }

            if (choix >= 1 && choix <= 4) {
                return choix;
            } else {
                System.out.println("Choix invalide. Veuillez recommencer.\n");
            }
        }
    }
    public Integer choisirRace(CaracteristiquesBase car) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choisissez une race :");
            System.out.println("1 - Humain");
            System.out.println("2 - Nain");
            System.out.println("3 - Elfe");
            System.out.println("4 - Halfelin");
            System.out.print("Votre choix : ");

            int choix;

            try {
                choix = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                continue;
            }

            if (choix >= 1 && choix <= 4) {
                return choix;
            } else {
                System.out.println("Choix invalide. Veuillez recommencer.\n");
            }
        }
    }


    public String choisirNom()
    {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Entrez le nom de votre personnage (puis appuyez sur Entrée) : ");
            String nom = scanner.nextLine().trim();

            if (!nom.isEmpty()) {
                return nom;
            } else {
                System.out.println("Le nom ne peut pas être vide. Appuyez sur Entrée après avoir saisi un nom.");
            }
        }

    }



    public void afficherCaracteristique(Integer currentPv, Integer pvMax, Integer dexterite, Integer force, Integer vitesse, Integer initiative) {
        System.out.println("Les caractéristiques du joueur sont :");
        System.out.println("- Current Pv : " + currentPv);
        System.out.println("- Pv Max : " + pvMax);
        System.out.println("- Dextérité : " + dexterite);
        System.out.println("- Force : " + force);
        System.out.println("- Vitesse : " + vitesse);
        System.out.println("- Initiative : " + initiative);
    }



}



