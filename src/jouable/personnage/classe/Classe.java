package jouable.personnage.classe;

import jouable.personnage.Personnage;
import jouable.personnage.sorts.Sorts;
import objet.Equipement;
import stats.CaracteristiquesBase;


import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public abstract class  Classe {

    protected Integer m_pv;
    protected Optional<List<Sorts>> m_sorts;
    protected List<Equipement>  m_listEquipement;

    public Classe(Integer pv)
    {
        this(pv , new ArrayList<>(), Optional.empty());
    }

    public Classe(Integer pv, List<Equipement> equipement) {
        this(pv , equipement, Optional.empty());
    }

    public Classe(Integer pv, List<Equipement> equipement, Optional<List<Sorts>> liste_sort) {
        m_pv = pv;
        m_sorts = liste_sort;
        m_listEquipement = equipement;
    }
    public int getPvClasse()
    {
        return m_pv;
    }

    public abstract void ajouterClasseInitPerso(Personnage perso);

    public Integer getPv() {
        return m_pv;
    }

    public List<Equipement> getListeEquipement() {
        return m_listEquipement;
    }

    public abstract String toString();

}
