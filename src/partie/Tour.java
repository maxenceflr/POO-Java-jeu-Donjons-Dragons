package partie;

import affichage.AffichageTour;
import donjon.Donjon;
import jouable.Jouable;


public class Tour {
    private Donjon m_donjon;
    private int m_numeroDeTour;
    private int m_numeroDeDonjon;
    private int m_indiceDujoueur;
    public Tour(Donjon donj,int numTour,int numDonjon)
    {
        m_donjon=donj;
        m_numeroDeTour=numTour;
        m_numeroDeDonjon=numDonjon;
        m_indiceDujoueur=0;

    }

    public void commencerTour()
    {
        int taille = m_donjon.getPositionsJouables().size();

        for (int i =0;i<taille;i++)
        {
            Jouable j= m_donjon.getPositionsJouables().getJouableByIndex(i);

        }
    }
    public static void jouer(Jouable j)
    {
        for (int i=0; i<3;i)
        {
            i+=demanderChoix(j);
        }
    }
    public static int demanderChoix(Jouable j)
    {
        AffichageTour AT = new AffichageTour();
        AT.afficherTour(m_donjon,)
    }


}
