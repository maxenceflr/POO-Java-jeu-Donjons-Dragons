package jouable.personnage.sorts;

import donjon.Donjon;
import donjon.Position;
import jouable.Monstre;
import jouable.personnage.Personnage;
import jouable.personnage.classe.Guerrier;
import jouable.personnage.classe.Magicien;
import jouable.personnage.race.Halfelin;
import jouable.personnage.race.Humain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stats.CaracteristiquesBase;

import static org.junit.jupiter.api.Assertions.*;

class SortsTest {

    Personnage personnage1;
    Personnage personnage2;
    Monstre monstre1;
    Monstre monstre2;


    Position position1;
    Position position2;
    Position position3;
    Position position4;

    Donjon donjonTest;

    @BeforeEach
    void setUp() {
        CaracteristiquesBase stats = new CaracteristiquesBase(10, 10, 10, 10, 10, 10);
        personnage1 = new Personnage("Maxence", new Humain(), new Guerrier(), stats);
        personnage2 = new Personnage("Maxime", new Halfelin(), new Magicien(), stats);

        monstre1 = Monstre.creerGobelin();;
        monstre2 = Monstre.creerGobelin();

        position1  = new Position(3, 16);
        position2  = new Position(7, 10);
        position3  = new Position(1, 5);
        position4  = new Position(16, 8);

        donjonTest = new Donjon(25, 25);

        donjonTest.getPositionsJouables().ajouterJouable(personnage1, position1);
        donjonTest.getPositionsJouables().ajouterJouable(personnage2, position2);
        donjonTest.getPositionsJouables().ajouterJouable(monstre1, position3);
        donjonTest.getPositionsJouables().ajouterJouable(monstre2, position4);
    }

    @Test
    void BoogieWoogieTest()
    {
        BoogieWoogie testSort = new BoogieWoogie();
        testSort.lancerSort(monstre2, monstre1, donjonTest);

        System.out.println(donjonTest.getPositionsJouables().toString());

        assertEquals(position3, donjonTest.getPositionFromJouable(monstre2));
        assertEquals(position4, donjonTest.getPositionFromJouable(monstre1));
    }



}