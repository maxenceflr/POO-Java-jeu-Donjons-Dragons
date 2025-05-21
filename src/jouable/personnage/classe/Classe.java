package jouable.personnage.classe;
import objet.armure.Equipement;

import java.util.List;
import java.util.ArrayList;

public abstract class  Classe {
    private Integer m_pv;
    private List<Equipement>  m_listEquipement;

    public Classe(Integer pv) {
        m_pv = pv;
        m_listEquipement = new ArrayList<>();
    }

    public Integer getPv() {
        return m_pv;
    }
    public void addEquipement(Equipement : equipement)
    {
        m_listEquipement.add(equipement);
    }
}
