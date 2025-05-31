package jouable.personnage.race;
import jouable.personnage.Personnage;
import stats.*;
import stats.CaracteristiquesBase;

public class Humain implements Race {
    private CaracteristiquesBase m_caracteristiques;

    public Humain()
    {
        this.m_caracteristiques= new CaracteristiquesBase(2,2,2,2,0,0);
    }

    @Override
    public void ajouterInitRacePerso(Personnage perso)
    {
        perso.setDexterite(perso.getDexterite() + m_caracteristiques.getDexterite());
        perso.setVitesse(perso.getVitesse() + m_caracteristiques.getVitesse());
        perso.setForce(perso.getForce() + m_caracteristiques.getForce());
        perso.setInitiative(perso.getInitiative() + m_caracteristiques.getInitiative());
    }


    @Override
    public String toString(){
        return "Humain";
    }

}