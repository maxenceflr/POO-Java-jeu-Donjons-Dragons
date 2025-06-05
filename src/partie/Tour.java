package partie;

import affichage.AffichageTour;
import donjon.Donjon;
import jouable.Jouable;
import jouable.Monstre;
import jouable.personnage.Personnage;

import java.util.List;
import java.util.ArrayList;

import static affichage.AffichageTour.afficherPerdue;
import static affichage.AffichageTour.afficherTourPersonage;
import static partie.Partie.partieperdue;


public class Tour {

    private Donjon m_donjon;
    private int m_numeroDeTour;
    private int m_numeroDeDonjon;
    private List<Jouable> m_listeJouable;
    public Tour(Donjon donj,int numTour,int numDonjon)
    {
        m_donjon=donj;
        m_numeroDeTour=numTour;
        m_numeroDeDonjon=numDonjon;
        m_listeJouable=m_donjon.getPositionsJouables().getListeJouables();
    }

    public boolean commencerTour()
    {
        int taille = m_donjon.getPositionsJouables().size();

        for (int i =0;i<taille;i++)
        {
            Jouable j= m_listeJouable.get(i);
            boolean sucee=this.jouer(j);
            if(sucee)
            {
                return true;
            }


        }
        return false;
    }
    public boolean jouer(Jouable j) {
        for (int i = 0; i < 3; i++) {//3 action par joueur
            boolean valide = false;

            if (j instanceof Personnage) {
                Personnage p= (Personnage) j;
                while (!valide) {
                    valide = AffichageTour.afficherTourPersonage(m_donjon, m_numeroDeDonjon, m_numeroDeTour, p, m_listeJouable);
                    if(this.tousLesMonstresMorts())
                    {
                        return true;
                    }
                }
            } else if (j instanceof Monstre) {
                Monstre m =(Monstre) j;
                while (!valide) {
                    AffichageTour.afficherTourMonstre(m_donjon, m_numeroDeDonjon, m_numeroDeTour, m, m_listeJouable);
                    if(this.personnageMort())
                    {
                        partieperdue();
                    }
                }
            }
        }
        return false;
    }
    public boolean personnageMort() {
        for (Jouable j : m_listeJouable) {
            if (j instanceof Personnage) {
                Personnage p=(Personnage) j;
                if (p.getCurrentPv() < 1) {
                    return true; // un perso est mort
                }
            }
        }
        return false; // au moins un personnage est mort
    }

    public boolean tousLesMonstresMorts() {
        for (Jouable j : m_listeJouable) {
            if (j instanceof Monstre) {
                Monstre m = (Monstre) j;
                if (m.getCurrentPv() > 0) {
                    return false; // au moins un monstre est encore en vie
                }
            }
        }
        return true; // tous les monstres sont morts
    }




}
