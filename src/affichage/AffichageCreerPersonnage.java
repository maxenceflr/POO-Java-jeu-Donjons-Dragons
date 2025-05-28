package affichage;
import java.util.Scanner;
import jouable.personnage.classe.*;
import jouable.personnage.race.*;
import stats.CaracteristiquesBase;
public class AffichageCreerPersonnage {

    public static Classe choisirClasse() {
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

            switch (choix) {
                case 1:
                    return new Clerc();
                case 2:
                    return new Guerrier();
                case 3:
                    return new Magicien();
                case 4:
                    return new Roublard();
                default:
                    System.out.println("Choix invalide. Veuillez recommencer.\n");
            }
        }
    }
    public static Race choisirRace(CaracteristiquesBase car) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choisissez une race :");
            System.out.println("1 - Humain");
            System.out.println("2 - Nain");
            System.out.println("3 - Elfe");
            System.out.println("4 - Halfelin");

            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    return new Humain(car);
                case 2:
                    return new Nain(car);
                case 3:
                    return new Elfe(car);
                case 4:
                    return new Halfelin(car);
                default:
                    System.out.println("Choix invalide. Race par défaut : Humain");
                    return new Humain();
            }
        }
    }
    public static String choisirNom()
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
    public static String afficherCaracteristiaque(Integer CurrentPv, Integer PvMax, Integer Dexteriter, Integer Force, Integer Vitesse, Integer Initiative) {
        return "Les caracteristiques du joueur sont :\n" +
                "- CurrentPv : " + CurrentPv + "\n" +
                "- PvMax : " + PvMax + "\n" +
                "- Dexteriter : " + Dexteriter + "\n" +
                "- Force : " + Force + "\n" +
                "- Vitesse : " + Vitesse + "\n" +
                "- Initiative : " + Initiative + "\n" ;
    }


}



