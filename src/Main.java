import donjon.*;
import jouable.Monstre;
import jouable.personnage.Personnage;
import jouable.personnage.classe.Magicien;
import jouable.personnage.race.Elfe;
import stats.CaracteristiquesBase;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String args[])
    {

        Monstre momo = new Monstre();
        Personnage perso = new Personnage();
        List<Personnage> listperso =new ArrayList<>();
        listperso.add(perso);

        Donjon don = new Donjon(listperso);
    }
}