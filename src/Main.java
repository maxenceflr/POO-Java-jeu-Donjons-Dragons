import donjon.*;
import jouable.Monstre;
import jouable.personnage.Personnage;
import jouable.personnage.classe.Magicien;
import jouable.personnage.race.Elfe;
import stats.CaracteristiquesBase;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        List<Personnage> listperso = new ArrayList<>();

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


        for (int i = 0; i < nbjoueur; i++) {
            System.out.println("Création du personnage " + (i + 1) + " :");
            Personnage perso = new Personnage();
            listperso.add(perso);
        }


        Donjon don = new Donjon(listperso);
    }
}