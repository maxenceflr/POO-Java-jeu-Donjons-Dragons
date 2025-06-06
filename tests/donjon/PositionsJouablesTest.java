package donjon;

import jouable.personnage.Personnage;
import jouable.personnage.classe.Guerrier;
import jouable.personnage.race.Humain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stats.CaracteristiquesBase;

import static org.junit.jupiter.api.Assertions.*;

class PositionsJouablesTest {

    @Test
    void Deplacement()
    {
        CaracteristiquesBase stats = new CaracteristiquesBase(10, 10, 10, 10, 10, 10);
        Personnage personnageTest= new Personnage("Maxence", new Humain(), new Guerrier(), stats);
        Position position1 = new Position(10,10);
        Position position2 = new Position(5, 5);

        Donjon donjonTest= new Donjon();
        donjonTest.getPositionsJouables().ajouterJouable(personnageTest, position1);
        donjonTest.getPositionsJouables().deplacerJouable(personnageTest, position2, donjonTest);

        assertEquals(position2, donjonTest.getPositionFromJouable(personnageTest));

    }
}