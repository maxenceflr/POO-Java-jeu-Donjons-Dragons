import donjon.*;
import jouable.personnage.Personnage;
import jouable.personnage.classe.Magicien;
import jouable.personnage.race.Elfe;
import stats.CaracteristiquesBase;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String args[])
    {
        Elfe eli = new Elfe();
        Magicien magi = new Magicien();
        CaracteristiquesBase cara = new CaracteristiquesBase(1,1,1,1,1,14);
        Personnage perso = new Personnage("Max",eli,magi,cara);
        List<Personnage> listperso =new ArrayList<>();
        listperso.add(perso);

        Donjon don = new Donjon(listperso);
    }
}