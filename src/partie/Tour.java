package partie;

import jouable.Jouable;

import java.util.Comparator;
import java.util.List;

public class Tour
{
    private int m_numeroTour;
    private final List<Jouable> m_ordreJeu;

    public Tour(List<Jouable> jouables)
    {
        m_numeroTour = 0;
        m_ordreJeu = jouables;
        m_ordreJeu.sort(Comparator.comparing(Jouable::getInitiative).reversed());
    }

    public void nextTour()
    {
        m_numeroTour++;     
    }

    public int getNumeroTour()
    {
        return m_numeroTour;
    }

    public List<Jouable> getOrdreJeu()
    {
        return m_ordreJeu;
    }

}
