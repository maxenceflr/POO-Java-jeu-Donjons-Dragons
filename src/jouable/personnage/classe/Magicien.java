package jouable.personnage.classe;

import objet.arme.*;
import objet.armure.*;


public class Magicien extends Classe{
    public Magicien(){
        super(20);

        this.m_listEquipement.add(new Baton());
        this.m_listEquipement.add(new Fronde());
    }
    public String getClasse() {
        return "Magicien";
    }
}
