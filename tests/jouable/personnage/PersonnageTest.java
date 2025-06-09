package jouable.personnage;

import affichage.AffichageDonjon;
import donjon.Donjon;
import donjon.Position;
import jouable.Monstre;
import jouable.personnage.classe.Guerrier;
import jouable.personnage.race.Humain;
import objet.Equipement;
import objet.arme.armedeguerre.EpeeLongue;
import objet.arme.armedeguerre.Rapiere;
import objet.arme.armedistance.ArbaleteLegere;
import objet.armure.armurelourde.CoteMailles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stats.CaracteristiquesBase;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PersonnageTest {

    Personnage perso;
    Monstre monstre;
    Donjon donjon;
    Position position_perso;
    Position position_monstre;

    @BeforeEach
    void setUp()
    {
        CaracteristiquesBase stats = new CaracteristiquesBase(10, 10, 10, 10, 10, 0);
        perso = new Personnage("Maxence", new Humain(), new Guerrier(), stats);
        monstre = Monstre.creerDragon();
        donjon = new Donjon(25,25);
        position_monstre = new Position(5,5);
        position_perso = new Position(5,6);
        donjon.getPositionsJouables().ajouterJouable(perso, position_perso);
        donjon.getPositionsJouables().ajouterJouable(monstre, position_monstre);
    }

    @Test
    void attaquer() {
        perso.attaquer(position_monstre, donjon);
        System.out.println("Pv du Monstre: " + Integer.toString(monstre.getCurrentPv()) + "/" + Integer.toString(monstre.getPvMax()));
    }

    @Test
    void ramasser() {
        donjon.getPositionsEquipement().ajouterEquipement(new Rapiere(), position_perso);
        perso.ramasser(position_perso, donjon);

        assertEquals(new ArrayList<Equipement>(Arrays.asList(new ArbaleteLegere(), new Rapiere())), perso.getInventaire().getInventaire());
    }
}