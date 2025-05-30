package jouable.personnage.race;
import jouable.personnage.Personnage;
import stats.CaracteristiquesBase;

public interface Race {
    String toString();
    void ajouterInitRacePerso(Personnage perso);
}
