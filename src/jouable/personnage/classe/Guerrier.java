package jouable.personnage.classe;

import objet.Equipement;
import objet.arme.*;
import objet.armure.*;

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
