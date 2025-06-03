package affichage;

import donjon.Donjon;
import jouable.Jouable;
import jouable.Monstre;
import jouable.personnage.Personnage;
import partie.Tour;

public class AffichageTour {
    public void afficherTour(Donjon donj, int numTour, int indiceDuJoueur, Jouable j)
    {
        afficherEnteteDonjon("1",j);/*le 1 sera remplacer par get numDonjon*/

    }
    public static void afficherEnteteDonjon(String numDonjon,Jouable j) {
        System.out.println("********************************************************************************");
        System.out.println("Donjon " + numDonjon + ":");
        System.out.println("                                    " + j.toString() + "             ");
        System.out.println("********************************************************************************");
    }
    public void afficherTour(Donjon donj, int numTour, Jouable j) {
        System.out.println("Tour " + numTour+ ":");
        for (Jouable jo: donj.getPositionsJouables().getListeJouables()) {
            String prefixe = (jo.equals(j)) ? "-> " : "   ";
            if(j instanceof Personnage p)
            {
                String statut = String.format("%s (%s %s, %d/%d)",p.getNom(),p.getRace(),p.getClasse(),p.getCurrentPv(), p.getPvMax());
            }
            else if (jo instanceof Monstre m) {
                String statut = String.format("%s (%d/%d)", m.getStringEspece(), m.getCurrentPv(), m.getPvMax());
                System.out.println(prefixe + statut);
            }
        }
    }
}
