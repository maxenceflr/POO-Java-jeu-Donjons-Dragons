package jouable.personnage.classe;

import jouable.personnage.Personnage;
import jouable.personnage.sorts.Sorts;
import objet.Equipement;


import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public abstract class  Classe {

    private Integer m_pv;
    private Optional<List<Sorts>> m_sorts;
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

    public void ajouterClasseInitPerso(Personnage perso)
    {
        perso.setPvMax(m_pv);
        perso.setCurrentPv(m_pv);
        perso.getInventaire().setInventaire(m_listEquipement);
    }

    public Integer getPv() {
        return m_pv;
    }

    public List<Equipement> getListeEquipement() {
        return m_listEquipement;
    }

    public abstract String toString();

}
