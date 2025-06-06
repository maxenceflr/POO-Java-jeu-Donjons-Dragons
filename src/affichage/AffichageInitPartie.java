package affichage;

import jouable.personnage.Personnage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AffichageInitPartie {
    public static int demanderNbJoueur() {
        String YELLOW = "\u001B[33m";
        String BLUE = "\u001B[34m";
        String RESET = "\u001B[0m";

        System.out.println("\n" +
                YELLOW +
                " .----------------.  .----------------.  .-----------------. .----------------.  .----------------.  .-----------------.  \n" +
                "| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |  \n" +
                "| |  ______      | || |     ____     | || | ____  _____  | || |     _____    | || |     ____     | || | ____  _____  | |  \n" +
                "| | |_   ___ `.  | || |   .'    `.   | || ||_   \\|_   _| | || |    |_   _|   | || |   .'    `.   | || ||_   \\|_   _| | |  \n" +
                "| |   | |   `. \\ | || |  /  .--.  \\  | || |  |   \\ | |   | || |      | |     | || |  /  .--.  \\  | || |  |   \\ | |   | |  \n" +
                "| |   | |    | | | || |  | |    | |  | || |  | |\\ \\| |   | || |   _  | |     | || |  | |    | |  | || |  | |\\ \\| |   | |  \n" +
                "| |  _| |___.' / | || |  \\  `--'  /  | || | _| |_\\   |_  | || |  | |_' |     | || |  \\  `--'  /  | || | _| |_\\   |_  | |  \n" +
                "| | |________.'  | || |   `.____.'   | || ||_____|\\____| | || |  `.___.'     | || |   `.____.'   | || ||_____|\\____| | |  \n" +
                "| |              | || |              | || |              | || |              | || |              | || |              | |  \n" +
                "| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |  \n" +
                " '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'   \n" +
                "                                         .----------------.                                                                                                       \n" +
                "                                        | .--------------. |                                                                                                      \n" +
                "                                        | |   "+ BLUE +" ___     " +  YELLOW+ "  | |                                                                                                      \n" +
                "                                        | |  "+ BLUE +".' _ '.  " +  YELLOW + "   | |                                                                                                      \n" +
                "                                        | |  "+ BLUE +"| (_) '___  " +  YELLOW + "| |                                                                                                      \n" +
                "                                        | | "+ BLUE +" .`___'/ _/  " +  YELLOW + "| |                                                                                                      \n" +
                "                                        | | "+ BLUE +"| (___)  \\_ " +  YELLOW + " | |                                                                                                      \n" +
                "                                        | | "+ BLUE +"`._____.\\__| " +  YELLOW + "| |                                                                                                      \n" +
                "                                        | |              | |                                                                                                      \n" +
                "                                        | '--------------' |                                                                                                      \n" +
                "                                         '----------------'                                                                                                       \n" +
                " .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .-----------------.  \n" +
                "| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |  \n" +
                "| |  ______      | || |  _______     | || |      __      | || |    ______    | || |     ____     | || | ____  _____  | |  \n" +
                "| | |_   ___ `.  | || | |_   __ \\    | || |     /  \\     | || |  .' ___  |   | || |   .'    `.   | || ||_   \\|_   _| | |  \n" +
                "| |   | |   `. \\ | || |   | |__) |   | || |    / /\\ \\    | || | / .'   \\_|   | || |  /  .--.  \\  | || |  |   \\ | |   | |  \n" +
                "| |   | |    | | | || |   |  __ /    | || |   / ____ \\   | || | | |    ____  | || |  | |    | |  | || |  | |\\ \\| |   | |  \n" +
                "| |  _| |___.' / | || |  _| |  \\ \\_  | || | _/ /    \\ \\_ | || | \\ `.___]  _| | || |  \\  `--'  /  | || | _| |_\\   |_  | |  \n" +
                "| | |________.'  | || | |____| |___| | || ||____|  |____|| || |  `._____.'   | || |   `.____.'   | || ||_____|\\____| | |  \n" +
                "| |              | || |              | || |              | || |              | || |              | || |              | |  \n" +
                "| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |  \n" +
                " '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'   \n" +
                RESET);

        Scanner scanner = new Scanner(System.in);

        int nbjoueur = 0;

        while (true) {
            System.out.println("Combien de joueurs êtes-vous ? (hors maître du jeu)");

            if (scanner.hasNextInt()) {
                nbjoueur = scanner.nextInt();
                if (nbjoueur > 0) {
                    break; // Valeur correcte, on sort de la boucle
                } else {
                    System.out.println("Le nombre de joueurs doit être supérieur à 0.");
                }
            } else {
                System.out.println("Veuillez entrer un nombre valide.");
                scanner.next(); // Consomme la mauvaise entrée
            }
        }
        return nbjoueur;
    }
    public static void affichageEntreeDonjon(String nomDonjon,int numDonjon)
    {
        System.out.println("\n\nVous entrez dans le "+nomDonjon);
        switch (numDonjon) {
            case 1:
                System.out.println("Votre groupe fraichement formé entre dans son premier donjon\n\n");
                break;
            case 2:
                System.out.println("Votre groupe est fatigué et a peur le "+nomDonjon+" est terrifiant, une atmosphere de mort y règne\n\n");
                break;
            case 3:
                System.out.println("Votre groupe n'a jamais été aussi soudé que maintenant, \nAu bout du "+nomDonjon+" Vous attend la gloire et la liberté\n\n");
                break;

        }
    }
}
