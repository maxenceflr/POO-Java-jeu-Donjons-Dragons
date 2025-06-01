package jouable.personnage.classe;

import objet.Equipement;
import objet.arme.armedeguerre.EpeeLongue;
import objet.arme.armedistance.ArbaleteLegere;
import objet.armure.armurelourde.CoteMailles;

import java.util.ArrayList;
import java.util.Arrays;

public class Guerrier extends Classe{
    public Guerrier(){
        super(20, new ArrayList<Equipement>(Arrays.asList(new CoteMailles(), new EpeeLongue(), new ArbaleteLegere())));
    }

    @Override
    public String toString() {
        return "Guerrier";
    }
}
