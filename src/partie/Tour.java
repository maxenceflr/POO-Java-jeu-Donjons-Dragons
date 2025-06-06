package partie;

import affichage.AffichageTour;
import donjon.Donjon;
import jouable.Jouable;
import jouable.Monstre;
import jouable.personnage.Personnage;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

import static affichage.AffichageTour.*;
import static partie.Partie.partieperdue;


public class Tour {

    private Donjon m_donjon;
    private int m_numeroDeTour;
    private int m_numeroDeDonjon;
    private List<Jouable> m_listeJouable;
    private int m_actionRestante;

    public Tour(Donjon donj, int numTour, int numDonjon)
    {
        m_donjon = donj;
        m_numeroDeTour = numTour;
        m_numeroDeDonjon = numDonjon;
        m_actionRestante = 0;
        m_listeJouable = m_donjon.getPositionsJouables().getListeJouables();
        m_listeJouable.sort(Comparator.comparing(Jouable::getInitiative).reversed());
    }

    public boolean commencerTour()
    {
        int nbJouable = m_donjon.getPositionsJouables().size();

        for (int i = 0; i < nbJouable; i++)
        {
            Jouable j = m_listeJouable.get(i);
            boolean sucee = this.jouer(j);
            if(sucee)
            {
                return true;
            }
        }
        return false;
    }

    public boolean jouer(Jouable j)
    {
        m_actionRestante = 3;
        for (int i = 0; i < 3; i++) {//3 action par joueur
            boolean commandevalide = false;

            if (j instanceof Personnage) {
                Personnage p= (Personnage) j;
                while (!commandevalide) {
                    commandevalide = afficherTourPersonage(m_donjon, m_numeroDeDonjon, this, p, m_listeJouable);
                    if(this.tousLesMonstresMorts())
                    {
                        return true;
                    }
                }
                } else if (j instanceof Monstre) {
                    Monstre m =(Monstre) j;
                    while (!commandevalide) {
                        commandevalide=afficherTourMonstre(m_donjon, m_numeroDeDonjon,this, m, m_listeJouable);
                        Personnage mort = this.getPersonnageMort();
                        if (mort != null) {

                            partieperdue(mort);
                        }
                }
            }
            m_actionRestante-=1;

        }
        return false;
    }
    public Personnage getPersonnageMort() {
        for (Jouable j : m_listeJouable) {
            if (j instanceof Personnage) {
                Personnage p = (Personnage) j;
                if (p.getCurrentPv() < 1) {
                    return p; // retourne le personnage mort
                }
            }
        }
        return null; // aucun personnage mort
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
    public int getNumTour()
    {
        return m_numeroDeTour;
    }
    public int getActionRestante()
    {
        return m_actionRestante;
    }





}
