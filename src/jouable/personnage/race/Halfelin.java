package jouable.personnage.race;

import stats.CaracteristiquesBase;
import stats.CaracteristiquesBase;

public class Halfelin implements Race {
    private CaracteristiquesBase m_caracteristiques;

    public Halfelin(CaracteristiquesBase caracteristique) {
        caracteristique.setDexterite(caracteristique.getDexterite() + 4); // +4 dextérité
        caracteristique.setVitesse(caracteristique.getVitesse() + 2);     // +2 vitesse
        this.m_caracteristiques = caracteristique;
    }

    public Halfelin() {
        this.m_caracteristiques = new CaracteristiquesBase(0, 4, 0, 2, 0); // force, dex, init, vit, pvmax
        this.m_caracteristiques.setCurrentPv(m_caracteristiques.getPvMax());
    }
    public String getRace(){
        return "Halfelin";
    }

    @Override
    public String toString() {
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
