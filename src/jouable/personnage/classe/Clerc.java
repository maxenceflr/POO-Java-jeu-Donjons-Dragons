package jouable.personnage.classe;

import objet.armure.Equipement;

public class Clerc extends Classe{
    public Clerc(){
        super(16);
        this.m_listEquipement.addEquipement(new Equipement())
    }
}