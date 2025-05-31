package jouable.personnage;
import jouable.personnage.race.*;
import stats.CaracteristiquesBase;
import jouable.personnage.classe.*;

public interface AffichagePersonnageInterface {
    Classe choisirClasse();
    Race choisirRace(CaracteristiquesBase car);
    String choisirNom();
    void afficherCaracteristique(Integer currentPv, Integer pvMax, Integer dexterite, Integer force, Integer vitesse, Integer initiative);

}
