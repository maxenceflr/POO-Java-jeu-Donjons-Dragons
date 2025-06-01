package donjon.Jouable;

import jouable.Monstre;
import jouable.personnage.Personnage;
import jouable.personnage.classe.Guerrier;
import jouable.personnage.race.Humain;
import objet.arme.armecourante.Baton;
import objet.armure.armurelegere.DemiPlate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stats.CaracteristiquesBase;

import static org.junit.jupiter.api.Assertions.*;

public class PersonnageTest {
    private Personnage personnage;

    @BeforeEach
    void setUp() {
        CaracteristiquesBase stats = new CaracteristiquesBase(10, 10, 10, 10, 10, 10);
        personnage = new Personnage("Maxence", new Humain(), new Guerrier(), stats);
    }

    @Test
    void testNomEtClasse() {
        assertEquals("Maxence", personnage.getNom());
        assertEquals("Guerrier", personnage.getClasse().toString());
    }

    @Test
    void testEquiperArmeEtArmure() {
        Baton baton = new Baton();
        DemiPlate demi = new DemiPlate();

        personnage.setArme(baton);
        personnage.setArmure(demi);

        assertEquals(personnage.getArme().get(),baton);
        assertEquals(personnage.getArmure().get(),demi);
    }

    @Test
    void testSymboleNom() {
        assertEquals("Max", personnage.getSymbole());
    }


}


