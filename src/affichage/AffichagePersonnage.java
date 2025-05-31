package affichage;
import java.util.Scanner;

import jouable.personnage.AffichagePersonnageInterface;
import jouable.personnage.race.*;
import stats.CaracteristiquesBase;
import jouable.personnage.classe.*;
public class AffichagePersonnage implements AffichagePersonnageInterface {

    private Scanner scanner = new Scanner(System.in);
    public Classe choisirClasse() {
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
                System.out.println("Entrée invalide. Veuillez entrer un nombre.\n");
                continue;
            }

            switch (choix) {
                case 1: return new Clerc();
                case 2: return new Guerrier();
                case 3: return new Magicien();
                case 4: return new Roublard();
                default:
                    System.out.println("Choix invalide. Veuillez recommencer.\n");
            }
        }
    }
    public Race choisirRace(CaracteristiquesBase car) {

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
                System.out.println("Entrée invalide. Veuillez entrer un nombre.\n");
                continue;
            }

            switch (choix) {
                case 1:
                    return new Humain();
                case 2:
                    return new Nain();
                case 3:
                    return new Elfe();
                case 4:
                    return new Halfelin();
                default:
                    System.out.println("Choix invalide. Veuillez recommencer.\n");
            }

        }
    }


    public String choisirNom() {

        while (true) {
            System.out.print("Entrez le nom de votre personnage (lettres uniquement) : ");
            String nom = scanner.nextLine().trim();

            if (nom.isEmpty()) {
                System.out.println("Le nom ne peut pas être vide. Veuillez réessayer.");
            } else if (!nom.matches("[a-zA-ZÀ-ÿ\\- ]+")) {
                System.out.println("Le nom ne doit contenir que des lettres. Aucun chiffre ni symbole n'est autorisé.");
            } else {
                return nom;
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



