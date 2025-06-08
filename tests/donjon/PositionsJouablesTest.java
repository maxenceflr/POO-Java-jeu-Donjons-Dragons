package donjon;

import affichage.AffichageDonjon;
import jouable.personnage.Personnage;
import jouable.personnage.classe.Guerrier;
import jouable.personnage.race.Humain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stats.CaracteristiquesBase;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionsJouablesTest {

    @Test
    void Deplacement()
    {
        CaracteristiquesBase stats = new CaracteristiquesBase(10, 10, 10, 10, 10, 10);
        Personnage personnageTest= new Personnage("Maxence", new Humain(), new Guerrier(), stats);
        Position position1 = new Position(10,10);
        Position position2 = new Position(11, 11);

        Donjon donjonTest= new Donjon();
        donjonTest.getPositionsJouables().ajouterJouable(personnageTest, position1);
        donjonTest.getPositionsJouables().deplacerJouable(personnageTest, position2, donjonTest);

        System.out.println(donjonTest.getPositionsJouables().toString());
        assertEquals(position2, donjonTest.getPositionFromJouable(personnageTest));
    }

    @Test
    void DeplacementCode()
    {
        CaracteristiquesBase stats = new CaracteristiquesBase(10, 10, 10, 10, 10, 10);
        Personnage personnageTest= new Personnage("Maxence", new Humain(), new Guerrier(), stats);
        Donjon donjonTest= new Donjon();
        String code = "A1";

        Position position1 = new Position(Position.getPositionFromCode(code));
        donjonTest.getPositionsJouables().ajouterJouable(personnageTest, position1);

        AffichageDonjon.afficherDonjon(donjonTest);
    }

    @Test
    void DeplacementHorsMap()
    {
        CaracteristiquesBase stats = new CaracteristiquesBase(10, 10, 10, 10, 10, 10);
        Personnage personnageTest= new Personnage("Maxence", new Humain(), new Guerrier(), stats);
        Position position1 = new Position(10,10);

        Donjon donjonTest= new Donjon();
        AffichageDonjon.afficherDonjon(donjonTest);

        Position positionTest = Position.getPositionFromCode("Y24");

        assertTrue(donjonTest.positionInDonjon(positionTest));

        //assertEquals(true, donjonTest.positionInDonjon(new Position()));
    }

}