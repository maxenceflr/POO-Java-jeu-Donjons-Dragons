package jouable.personnage.classe;

import jouable.personnage.sorts.Guerison;
import jouable.personnage.sorts.Sorts;
import objet.Equipement;
import objet.arme.*;
import objet.armure.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Clerc extends Classe{
    public Clerc()
    {
        super(16,
                new ArrayList<Equipement>(Arrays.asList(new MasseDarme(), new ArmureEcailles(), new ArbaleteLegere())),
                Optional.of(new ArrayList<Sorts>(Arrays.asList(new Guerison()))));
    }

    @Override
    public String toString() {
        return "Clerc";
    }
}