package jouable.personnage.classe;

import objet.arme.*;
import objet.armure.*;

public class Guerrier extends Classe{
    public Guerrier(){
        super(20);
        this.m_listEquipement.add(new CoteMailles());
        this.m_listEquipement.add(new EpeeLongue());
        this.m_listEquipement.add(new ArbaleteLegere());

    }
    public String getClasse() {
        return "Guerrier";
    }
}
