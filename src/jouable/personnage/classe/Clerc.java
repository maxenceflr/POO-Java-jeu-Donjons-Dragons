package jouable.personnage.classe;

import objet.arme.*;
import objet.armure.*;

public class Clerc extends Classe{
    public Clerc(){
        super(16);
        this.m_listEquipement.add(new ArbaleteLegere());
        this.m_listEquipement.add(new MasseDarme());
        this.m_listEquipement.add(new ArmureEcailles());
    }
    public String getClasse() {
        return "Clerc";
    }
}