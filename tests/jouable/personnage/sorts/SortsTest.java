package jouable.personnage.sorts;

import donjon.Donjon;
import donjon.Position;
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

    Position position1;
    Position position2;

    Donjon donjonTest;

    @BeforeEach
    void setUp() {
        CaracteristiquesBase stats = new CaracteristiquesBase(10, 10, 10, 10, 10, 10);
        personnage1 = new Personnage("Maxence", new Humain(), new Guerrier(), stats);
        personnage2 = new Personnage("Maxime", new Halfelin(), new Magicien(), stats);

        position1  = new Position(3, 16);
        position2  = new Position(7, 10);

        donjonTest = new Donjon();

        donjonTest.getPositionsJouables().ajouterJouable(personnage1, position1);
        donjonTest.getPositionsJouables().ajouterJouable(personnage2, position2);
    }

    @Test
    void BoogieWoogieTest()
    {
        BoogieWoogie testSort = new BoogieWoogie();
        testSort.utiliser(personnage1, personnage2, donjonTest);

        assertEquals(position2, donjonTest.getPositionFromJouable(personnage1));
        assertEquals(position1, donjonTest.getPositionFromJouable(personnage2));
    }
}