package jouable.personnage.race;

import jouable.personnage.Personnage;
import stats.CaracteristiquesBase;
import stats.CaracteristiquesBase;

public class Halfelin implements Race {
    private Integer m_dexterite;
    private Integer m_vitesse;


    public Halfelin()
    {
        m_dexterite = 4;
        m_vitesse = 2;
    }

    @Override
    public void ajouterInitRacePerso(Personnage perso)
    {
        perso.setDexterite(perso.getDexterite() + m_dexterite);
        perso.setVitesse(perso.getVitesse() + m_dexterite);
    }

    @Override
    public String toString(){
        return "Halfelin";
    }

}
