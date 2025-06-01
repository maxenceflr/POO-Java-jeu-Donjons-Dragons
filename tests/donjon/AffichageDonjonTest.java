package donjon;

import jouable.Monstre;
import jouable.personnage.Personnage;
import jouable.personnage.classe.Guerrier;
import jouable.personnage.race.Humain;
import objet.arme.armedistance.ArbaleteLegere;
import org.junit.jupiter.api.Test;
import stats.CaracteristiquesBase;

class AffichageDonjonTest
{
    @Test
    void DonjonTestVide()
    {
        Donjon donjon_test = new Donjon();
        AffichageDonjon.afficherDonjon(donjon_test);
    }

    @Test
    void DonjonTestRempli()
    {
        Personnage personnageTest = new Personnage("Maxence", new Humain(), new Guerrier(), new CaracteristiquesBase());
        Monstre monstreTest = Monstre.creerDragon();

        Position positionTest1 = new Position(9, 3);
        Position positionTest2 = new Position(9,9);
        Position positionTest3 = new Position(15,7);
        Position positionTest4 = new Position(12,16);

        Donjon donjon_test = new Donjon();

        donjon_test.getPositionsJouables().ajouterJouable(personnageTest, positionTest1);
        donjon_test.getPositionsObstacle().ajouterObstacle(positionTest2);
        donjon_test.getPositionsEquipement().ajouterEquipement(new ArbaleteLegere(), positionTest3);
        donjon_test.getPositionsJouables().ajouterJouable(monstreTest, positionTest4);

        AffichageDonjon.afficherDonjon(donjon_test);

    }


}