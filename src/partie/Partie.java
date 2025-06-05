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
    public static void partieperdue()
    {
        afficherPerdue();
        System.exit(0);
    }public void gagnee()
    {
        afficherGagneé();
        System.exit(0);
    }

}
