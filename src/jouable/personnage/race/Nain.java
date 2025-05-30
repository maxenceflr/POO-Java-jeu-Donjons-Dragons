package jouable.personnage.race;

import jouable.personnage.Personnage;
import stats.CaracteristiquesBase;
import stats.CaracteristiquesBase;

public class Nain implements Race {
    private Integer m_force;

    public Nain()
    {
        m_force = 6;
    }

    @Override
    public void ajouterInitRacePerso(Personnage perso)
    {
        perso.setForce(perso.getForce() + m_force);
    }


    @Override
    public String toString(){
        return "Nain";
    }

}
