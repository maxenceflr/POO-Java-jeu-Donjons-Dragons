package jouable.personnage.race;
import stats.*;
import stats.CaracteristiquesBase;

public class Humain implements Race {
    private CaracteristiquesBase m_caracteristiques;
    public Humain(CaracteristiquesBase caracteristique)
    {
        caracteristique.setDexterite(caracteristique.getDexterite()+2);
        caracteristique.setForce(caracteristique.getForce()+2);
        caracteristique.setInitiative(caracteristique.getInitiative()+2);
        caracteristique.setVitesse(caracteristique.getVitesse()+2);
        caracteristique.setPvMax(caracteristique.getPvMax()+2);
        caracteristique.setCurrentPv(caracteristique.getPvMax()+2);
        this.m_caracteristiques=caracteristique;
    }
    public Humain()
    {
        this.m_caracteristiques= new CaracteristiquesBase(2,2,2,2,2);
    }
    public String getRace(){
        return "Humain";
    }
    @Override
    public String toString()
    {
        return this.getRace()+ " {" +
                "Force=" + m_caracteristiques.getForce() +
                ", Dextérité=" + m_caracteristiques.getDexterite() +
                ", Initiative=" + m_caracteristiques.getInitiative() +
                ", Vitesse=" + m_caracteristiques.getVitesse() +
                ", PV Max=" + m_caracteristiques.getPvMax() +
                ", PV Actuels=" + m_caracteristiques.getCurrentPv() +
                '}';
    }
}