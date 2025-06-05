package jouable.personnage.classe;

import jouable.personnage.Personnage;
import objet.arme.*;
import objet.arme.armecourante.Baton;
import objet.arme.armedeguerre.Rapiere;
import objet.arme.armedistance.ArcCourt;
import objet.armure.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Roublard extends Classe{
    public Roublard()
    {
        super(16, new ArrayList<>(Arrays.asList(new Rapiere(), new ArcCourt())));
    }

    @Override
    public void ajouterClasseInitPerso(Personnage perso)
    {
        perso.setPvMax(m_pv);
        perso.setCurrentPv(m_pv);
        perso.getInventaire().setInventaire(m_listEquipement);
        perso.equiper(perso.getInventaire().getEquipement(new Rapiere()));
    }

    @Override
    public String toString() {
        return "Roublard";
    }
}
