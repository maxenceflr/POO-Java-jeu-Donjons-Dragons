package jouable.personnage;
import jouable.personnage.race.*;
import stats.CaracteristiquesBase;
import jouable.personnage.classe.*;

public interface AffichagePersonnageInterface {
    Classe choisirClasse();
    public Race choisirRace(Personnage perso);
    String choisirNom();
    public void afficherCaracteristique(Personnage perso);

}
