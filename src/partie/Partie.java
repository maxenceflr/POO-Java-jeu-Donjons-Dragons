package partie;

import affichage.AffichageDonjon;
import donjon.Donjon;
import jouable.personnage.Personnage;

import java.util.ArrayList;
import java.util.List;

import static affichage.AffichageInitPartie.affichageEntreeDonjon;
import static affichage.AffichageInitPartie.demanderNbJoueur;
import static affichage.AffichageTour.afficherGagneé;
import static affichage.AffichageTour.afficherPerdue;

public class Partie {
    public static void DebuterPartie()
    {
        int nbjoueur= demanderNbJoueur();
        List<Personnage> listperso = new ArrayList<>();
        for (int i = 0; i < nbjoueur; i++) {
            System.out.println("Création du personnage " + (i + 1) + " :");
            Personnage perso = new Personnage();
            listperso.add(perso);
        }
        for (int i=0;i<3;i++)
        {
            Donjon donj =new Donjon(listperso);
            explorerDonjon(donj,i+1);
        }
        gagnee();
    }
    public static void explorerDonjon(Donjon donj,int nbDonjon)
    {
        affichageEntreeDonjon(donj.getNom(),nbDonjon);
        int nbTour=1;
        boolean donjonFini=false;
        do {
            Tour tour=new Tour(donj,nbTour,nbDonjon);
            donjonFini =tour.commencerTour();
        }while (donjonFini==false);
    }
    public static void partieperdue(Personnage p)
    {
        afficherPerdue(p);
        afficherGenerique();
        System.exit(0);
    }public static void gagnee()
    {
        afficherGagneé();
        afficherGenerique();
        System.exit(0);
    }
    public static void afficherGenerique() {
        String[][] generique = {
                {"1", "Donjons & Dragons"},
                {"1", "Directeur : Max"},
                {"2", "Fin"},
                {"2", "Scénariste : Etienne Lequentreque"},
                {"3", "Chefs effets spéciaux : Maxime Malys"},
                {"4", "Opérateur image : Maxence Flieller"},
                {"5", "Merci d'avoir joué !"}
        };

        for (String[] ligne : generique) {
            int tempo = Integer.parseInt(ligne[0]);
            String texte = ligne[1];

            // Effet de scroll (moins brutal)
            for (int i = 0; i < 5; i++) System.out.println();

            // Affichage lettre par lettre
            for (char c : texte.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                try {
                    Thread.sleep(40); // vitesse d'apparition des lettres (40 ms = fluide)
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            System.out.println();

            // Pause entre les lignes
            try {
                Thread.sleep(tempo * 500); // chaque tempo = 0.5 seconde ici (plus fluide)
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }


}
