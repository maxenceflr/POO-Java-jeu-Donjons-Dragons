package jouable.personnage;

import stats.CaracteristiquesBase;

public interface AffichagePersonnageInterface {
    Integer choisirClasse(CaracteristiquesBase car);
    Integer choisirRace(CaracteristiquesBase car);
    String choisirNom();
    void afficherCaracteristique(Integer currentPv, Integer pvMax, Integer dexterite, Integer force, Integer vitesse, Integer initiative);

}
