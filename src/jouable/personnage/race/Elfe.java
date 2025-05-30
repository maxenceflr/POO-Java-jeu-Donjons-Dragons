package jouable.personnage.race;

import jouable.personnage.Personnage;
import stats.CaracteristiquesBase;
import stats.CaracteristiquesBase;

public class Elfe implements Race {
    private Integer m_dexterite;

    public Elfe() {
        m_dexterite = 6;
    }

    @Override
    public void ajouterInitRacePerso(Personnage perso)
    {
        perso.setDexterite(perso.getDexterite() + m_dexterite);
    }

    public String toString(){
        return "Elfe";
    }
}
