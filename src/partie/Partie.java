package partie;

import donjon.Donjon;

public class Partie {

    private Tour m_tour;
    private Donjon m_donjonEnCours;

    public Partie(Donjon donjonEnCours)
    {
        m_tour = new Tour();
        m_donjonEnCours = donjonEnCours;
    }

    public void InitialiserPartie()
    {

    }
}
