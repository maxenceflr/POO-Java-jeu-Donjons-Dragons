package jouable.personnage.race;
import jouable.Monstre;
import jouable.personnage.Personnage;
import stats.CaracteristiquesBase;

public interface Race {
    String toString();
    void ajouterInitRacePerso(Personnage perso);
    @Override
    public boolean equals(Object other);

}
