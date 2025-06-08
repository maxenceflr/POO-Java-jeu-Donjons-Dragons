package donjon;

import jouable.personnage.Personnage;
import java.util.List;

public interface AffichageDonjonInterface {
    int demanderLargeur();
    int demanderLongeur();
    Position demanderPositionObstacle(Donjon donjon, PositionsObstacle PO);
    PositionsObstacle PlacerObstacle(Donjon donjon);
    Position demanderPositionEquipement(Donjon donjon, PositionsEquipement PE);
    PositionsEquipement placerEquipement(Donjon donjon);
    PositionsJouables PlacerPersonnages(List<Personnage> perso, Donjon donjon);
}