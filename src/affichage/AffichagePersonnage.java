package affichage;
import java.util.Scanner;

import jouable.personnage.AffichagePersonnageInterface;
import jouable.personnage.Personnage;
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
    public Race choisirRace(Personnage perso) {

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
                    Humain hum = new Humain();
                    hum.ajouterInitRacePerso(perso);
                    return hum;
                case 2:
                    Nain nain = new Nain();
                    nain.ajouterInitRacePerso(perso);
                    return nain;
                case 3:
                    Elfe elfe = new Elfe();
                    elfe.ajouterInitRacePerso(perso);
                    return elfe;
                case 4:
                    Halfelin halfelin = new Halfelin();
                    halfelin.ajouterInitRacePerso(perso);
                    return halfelin;
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



    public void afficherCaracteristique(Personnage perso) {
        System.out.println("\n\n\n\n"+perso.getNom()+" :");
        System.out.println("Race :"+perso.getRace().toString()+" Classe :"+perso.getClasse().toString());
        System.out.println("\n- Current Pv : " + perso.getCurrentPv());
        System.out.println("- Pv Max : " +perso.getPvMax());
        System.out.println("- Dextérité : " + perso.getDexterite());
        System.out.println("- Force : " + perso.getForce());
        System.out.println("- Vitesse : " + perso.getVitesse());
        System.out.println("- Initiative : " + perso.getInitiative());
        System.out.println(perso.getInventaire().toString()+"\n");
        System.out.println("Arme Portée: "+perso.getStringArme());
        System.out.println("Armure Portée: "+perso.getStringArmure()+"\n\n");

    }



}



