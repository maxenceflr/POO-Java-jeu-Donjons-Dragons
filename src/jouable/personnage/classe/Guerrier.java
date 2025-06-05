package jouable.personnage.classe;

import jouable.personnage.Personnage;
import objet.Equipement;
import objet.arme.armecourante.MasseDarme;
import objet.arme.armedeguerre.EpeeLongue;
import objet.arme.armedistance.ArbaleteLegere;
import objet.armure.*;
import objet.armure.armurelegere.ArmureEcailles;
import objet.armure.armurelourde.CoteMailles;

import java.util.ArrayList;
import java.util.Arrays;

public class Guerrier extends Classe{
    public Guerrier(){
        super(20, new ArrayList<Equipement>(Arrays.asList(new EpeeLongue(), new CoteMailles(), new ArbaleteLegere())));
    }

    @Override
    public void ajouterClasseInitPerso(Personnage perso)
    {
        perso.setPvMax(m_pv);
        perso.setCurrentPv(m_pv);
        perso.getInventaire().setInventaire(m_listEquipement);
        perso.equiper(perso.getInventaire().getEquipement(new EpeeLongue()));
        perso.equiper(perso.getInventaire().getEquipement(new CoteMailles()));
    }

    @Override
    public String toString() {
        return "Guerrier";
    }
}
