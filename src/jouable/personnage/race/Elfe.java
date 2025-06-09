package jouable.personnage.race;

import jouable.personnage.Personnage;
import objet.arme.armedeguerre.EpeeLongue;
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

    @Override
    public boolean equals(Object other) {
        //Run Time Type Information!
        if (other == null || other.getClass() != getClass()) {
            return false;
        } else {
            Elfe conversion = (Elfe) other;
            return  m_dexterite == conversion.m_dexterite;
        }
    }

}
