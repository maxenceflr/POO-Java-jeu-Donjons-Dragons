package jouable.personnage.classe;

import objet.arme.*;
import objet.armure.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Roublard extends Classe{
    public Roublard()
    {
        super(16, new ArrayList<>(Arrays.asList(new Rapiere(), new ArcCourt())));
    }

    @Override
    public String toString() {
        return "Roublard";
    }
}
