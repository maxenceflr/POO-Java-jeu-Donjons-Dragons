package jouable.personnage.classe;

import jouable.personnage.sorts.ArmeMagique;
import jouable.personnage.sorts.BoogieWoogie;
import jouable.personnage.sorts.Guerison;
import objet.arme.armecourante.Baton;
import objet.arme.armedistance.Fronde;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;


public class Magicien extends Classe{
    public Magicien(){
        super(20,
                new ArrayList<>(Arrays.asList(new Baton(), new Fronde())),
                Optional.of(new ArrayList<>(Arrays.asList(new Guerison(), new ArmeMagique(), new BoogieWoogie()))));
    }

    @Override
    public String toString() {
        return "Magicien";
    }
}
