package jouable.personnage.classe;

import objet.Equipement;


import java.util.List;
import java.util.ArrayList;

public abstract class  Classe {
    private Integer m_pv;
    protected List<Equipement>  m_listEquipement;

    public Classe(Integer pv) {
        m_pv = pv;
        m_listEquipement = new ArrayList<>();
    }

    public Integer getPv() {
        return m_pv;
    }
    public abstract String getClasse();

}
