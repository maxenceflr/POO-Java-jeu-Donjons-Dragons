package jouable.personnage.classe;

import objet.arme.*;
import objet.armure.*;

public class Roublard extends Classe{
    public Roublard()
    {
        super(16);

        this.m_listEquipement.add(new Rapiere());
        this.m_listEquipement.add(new ArcCourt());

    }
    public String getClasse() {
        return "Roublard";
    }
}
